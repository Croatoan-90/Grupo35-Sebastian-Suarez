package com.example.aplicacionchaqueta.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aplicacionchaqueta.Modelo.DataBaseSQLController;
import com.example.aplicacionchaqueta.Modelo.Servicios.AdaptadorServicio;
import com.example.aplicacionchaqueta.Modelo.Servicios.EntidadServicio;
import com.example.aplicacionchaqueta.R;

import java.util.ArrayList;

public class Fragment_Servicios extends Fragment {

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadServicio> listaServicio = new ArrayList<>();
    private int[] listImg = {R.drawable.buyicon, R.drawable.laundry, R.drawable.exchang};
    private ListView listViewServ;
    private AdaptadorServicio adaptadorServicio;

    public Fragment_Servicios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__servicios, container, false);
        //--------------------------------------------------------------------------------
        listViewServ = (ListView) view.findViewById(R.id.viewServices);
        adaptadorServicio = new AdaptadorServicio(getServItems(),getActivity());
        listViewServ.setAdapter(adaptadorServicio);


        return view;
    }

    private ArrayList<EntidadServicio> getServItems(){

        DataBaseSQLController conector = new DataBaseSQLController(this.getActivity(), "AppChaqueta", null, 1);

        SQLiteDatabase db_readS = conector.getReadableDatabase();
        conector.onUpgrade(db_readS,1,2);
        cursor = db_readS.rawQuery("SELECT * FROM servicios",null);

        //Escritura de elementos de la Base de Datos a la parte visual
        while(cursor.moveToNext()){
            listaServicio.add(new EntidadServicio(listImg[cursor.getInt(0)],cursor.getString(1) ));
        }

        return listaServicio;
    }
}