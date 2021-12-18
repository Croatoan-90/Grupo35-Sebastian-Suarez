package com.example.aplicacionchaqueta.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplicacionchaqueta.Modelo.DataBaseSQLController;
import com.example.aplicacionchaqueta.Modelo.Productos.EntidadProducto;
import com.example.aplicacionchaqueta.Modelo.Servicios.AdaptadorServicio;
import com.example.aplicacionchaqueta.Modelo.Servicios.EntidadServicio;
import com.example.aplicacionchaqueta.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_Servicios extends Fragment {

    private View view;
    private ArrayList<EntidadServicio> listaServicio = new ArrayList<>();
    private int[] listImg = {R.drawable.buyicon, R.drawable.laundry, R.drawable.exchang};
    private ListView listViewServ;
    private AdaptadorServicio adaptadorServicio;
    private TextView tituloServ;

    public Fragment_Servicios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__servicios, container, false);
        //--------------------------------------------------------------------------------
        tituloServ = (TextView) view.findViewById(R.id.servTit);
        listViewServ = (ListView) view.findViewById(R.id.viewServices);
        adaptadorServicio = new AdaptadorServicio(getServItems(),getActivity());
        listViewServ.setAdapter(adaptadorServicio);


        return view;
    }

    private ArrayList<EntidadServicio> getServItems() {

        //-----------------------------------------
        if (listaServicio.isEmpty()) {
            String url = "https://ge3e1bb39c96dbd-appchaquetas.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/AppChaqueta/servicios";

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        JSONArray jsonArrayS = response.getJSONArray("items");
                        for (int i = 0; i < jsonArrayS.length(); i++) {
                            JSONObject jsonObject = jsonArrayS.getJSONObject(i);

                            int id = jsonObject.getInt("id");
                            String descripcion = jsonObject.getString("descripcion");
                            listaServicio.add(new EntidadServicio(listImg[id], descripcion));

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    tituloServ.setText("SERVICIOS DISPONIBLES" + '\n');

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            requestQueue.add(jsonObjectRequest);


        }
        return listaServicio;
    }
}