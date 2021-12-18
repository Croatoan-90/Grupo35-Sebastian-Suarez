package com.example.aplicacionchaqueta.Vista;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplicacionchaqueta.Modelo.DataBaseSQLController;
import com.example.aplicacionchaqueta.Modelo.Productos.AdaptadorProducto;
import com.example.aplicacionchaqueta.Modelo.Productos.EntidadProducto;
import com.example.aplicacionchaqueta.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Productos extends Fragment {

    private View view;
   // private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();
    private int[] listImg = {R.drawable.cuero,R.drawable.pana,R.drawable.impermeable, R.drawable.capucha};
    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;
    private TextView tituloProd;

    public Fragment_Productos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__productos, container, false);
        //--------------------------------------------------------------------------------
        tituloProd = (TextView) view.findViewById(R.id.prodTit);
        listViewProd = (ListView) view.findViewById(R.id.viewProducts);
        adaptadorProducto = new AdaptadorProducto(getProdItems(),getActivity());
        listViewProd.setAdapter(adaptadorProducto);

        //-----------------------------------------------------------------------------
        return view;
    }

    private ArrayList<EntidadProducto> getProdItems() {
        //-----------------------------------------
        if (listaProductos.isEmpty()) {
            String url = "https://ge3e1bb39c96dbd-appchaquetas.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/AppChaqueta/productos";

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            int id = jsonObject.getInt("id");
                            String titulo = jsonObject.getString("titulo");
                            String descripcion = jsonObject.getString("descripcion");

                            listaProductos.add(new EntidadProducto(listImg[id], titulo, descripcion));


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    tituloProd.setText("PRODUCTOS DISPONIBLES" + '\n');

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            requestQueue.add(jsonObjectRequest);


        }
        return listaProductos;
    }
}