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

import com.example.aplicacionchaqueta.Modelo.DataBaseSQLController;
import com.example.aplicacionchaqueta.Modelo.Productos.AdaptadorProducto;
import com.example.aplicacionchaqueta.Modelo.Productos.EntidadProducto;
import com.example.aplicacionchaqueta.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Productos extends Fragment {

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();
    private int[] listImg = {R.drawable.cuero,R.drawable.pana,R.drawable.impermeable, R.drawable.capucha};
    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;

    public Fragment_Productos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__productos, container, false);
        //--------------------------------------------------------------------------------
        listViewProd = (ListView) view.findViewById(R.id.viewProducts);
        adaptadorProducto = new AdaptadorProducto(getProdItems(),getActivity());
        listViewProd.setAdapter(adaptadorProducto);

        //-----------------------------------------------------------------------------
        return view;
    }

    private ArrayList<EntidadProducto> getProdItems(){
        DataBaseSQLController conector = new DataBaseSQLController(this.getActivity(), "AppChaqueta", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();


        conector.onUpgrade(db_read,1,2);
        cursor = db_read.rawQuery("SELECT * FROM productos", null);



        //Escritura de elementos de la Base de Datos a la parte visual
        while (cursor.moveToNext()) {
            listaProductos.add(new EntidadProducto(listImg[cursor.getInt(0)],cursor.getString(1),cursor.getString(2) ));
            //lista.append(cursor.getString(0)+" "+cursor.getString(1));

        }
        return listaProductos;
    }

 }