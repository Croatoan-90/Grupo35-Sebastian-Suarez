package com.example.aplicacionchaqueta.Modelo.Servicios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplicacionchaqueta.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdaptadorServicio extends BaseAdapter {

    private ArrayList<EntidadServicio> listaServ;
    private Context context;

    public AdaptadorServicio(ArrayList<EntidadServicio> listaServ, Context context) {
        this.listaServ = listaServ;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaServ.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaServ.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    /**
     * Se ponen los valores que corresponden a cada item
     * @param pos
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        EntidadServicio item = (EntidadServicio) getItem(pos);
        view = LayoutInflater.from(context).inflate(R.layout.item_servicio,null);
        //--------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.imgServicio);
        TextView descripcion = (TextView) view.findViewById(R.id.textServicio);
        CheckBox favServicio = (CheckBox) view.findViewById(R.id.favServicio);

        //--------------------ENLAZAR ELEMENTOS-------------------
        img1.setImageResource(item.getImg());
        descripcion.setText(item.getDescripcion());

        return view;
    }
}
