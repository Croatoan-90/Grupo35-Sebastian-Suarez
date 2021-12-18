package com.example.aplicacionchaqueta.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplicacionchaqueta.BuildConfig;
import com.example.aplicacionchaqueta.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class Fragment_Sucursales extends Fragment {

    private View view;
    private MapView myOpenMapView;
    private MapController mapController;

    public Fragment_Sucursales() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //--------------------------------------------------------------------------------

        myOpenMapView = (MapView) view.findViewById(R.id.mapView);

        //-------- VALOR DE AGENTE DE USUARIO----------------

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*--- Puntos de Geolocalización--------*/

        GeoPoint bogota = new GeoPoint(4.6351,-74.0703);
        GeoPoint parque93 = new GeoPoint(4.6765268,-74.0494101);
        GeoPoint centro = new GeoPoint(4.6012645,-74.0810494);
        GeoPoint bonanza = new GeoPoint(4.688613,-74.0944565);

        /*-- Enlaces --*/

        myOpenMapView.setBuiltInZoomControls(true);

        mapController = (MapController) myOpenMapView.getController();
        mapController.setCenter(bogota);
        mapController.setZoom(13);

        myOpenMapView.setMultiTouchControls(true);

        /*-- Hilo de cargue dinámico de mapa --*/

        final MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()),myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationNewOverlay);
        myLocationNewOverlay.enableMyLocation();

        myLocationNewOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                mapController.animateTo(myLocationNewOverlay.getMyLocation());
            }
        });

        //--------------------------------------------------------------------------------

        /*--- Puntos sucursal ---*/

        ArrayList<OverlayItem> sucursales = new ArrayList<OverlayItem>();
        sucursales.add(new OverlayItem("Sucursal Norte","Parque de a 93",parque93));
        sucursales.add(new OverlayItem("Sucursal Centro", "Santa Inés", centro ));
        sucursales.add(new OverlayItem("Sucursal Occidente", "Bonanza", bonanza));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(),sucursales,tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        return view;
    }
}