package com.example.aplicacionchaqueta.Vista;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aplicacionchaqueta.Modelo.Compra.AdaptadorCompra;
import com.example.aplicacionchaqueta.Modelo.Compra.EntidadCompra;
import com.example.aplicacionchaqueta.Modelo.DataBaseSQLController;
import com.example.aplicacionchaqueta.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Fragment_ShoppingCar extends Fragment {

    private View view;
    private Cursor cursor;
    private ListView listViewComp;
    private int[] listaComp= {R.drawable.check};
    private AdaptadorCompra adaptadorCompra;
    DataBaseSQLController conector;
    private Button finalizar;
    private ArrayList<EntidadCompra> listaCompra = new ArrayList<>();

    public Fragment_ShoppingCar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment__shopping_car, container, false);
        //----------------------------------------------------------------------------------

        finalizar = (Button) view.findViewById(R.id.finalizarCompra);
        listViewComp = (ListView) view.findViewById(R.id.viewShopping);
        adaptadorCompra = new AdaptadorCompra(getProdComp(),getContext());
        listViewComp.setAdapter(adaptadorCompra);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Dirigiendo a la pagina de pagos",Toast.LENGTH_SHORT).show();
            }
        });

     return view;
    }

    private ArrayList<EntidadCompra> getProdComp(){

        conector = new DataBaseSQLController(getContext(), "AppChaqueta", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();

        cursor = db_read.rawQuery("SELECT * FROM compra", null);

        //Escritura de elementos de la Base de Datos a la parte visual
        while(cursor.moveToNext()){
            listaCompra.add(new EntidadCompra(listaComp[cursor.getInt(0)], cursor.getString(1)));
        }

        return listaCompra;
    }
}