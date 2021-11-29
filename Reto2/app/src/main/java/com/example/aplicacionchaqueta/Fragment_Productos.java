package com.example.aplicacionchaqueta;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_Productos extends Fragment {

    private View view;
    private Drawable drawable1;
    private Drawable drawable2;
    private Drawable drawable3;
    private Drawable drawable4;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;


     public Fragment_Productos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__productos, container, false);
        //--------------------------------------------------------------------------------

        //--------------------------CARGUE DE IMAGENES------------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.cuero,view.getContext().getTheme());
        img1 = (ImageView) view.findViewById(R.id.cueroF);
        img1.setImageDrawable(drawable1);

        //----------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.pana,view.getContext().getTheme());
        img2 = (ImageView) view.findViewById(R.id.panaF);
        img2.setImageDrawable(drawable2);

        //----------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.impermeable,view.getContext().getTheme());
        img3 = (ImageView) view.findViewById(R.id.impermeableF);
        img3.setImageDrawable(drawable3);

        //----------------------------------------------------

        Resources res4 = getResources();
        drawable4 = res4.getDrawable(R.drawable.capucha,view.getContext().getTheme());
        img4 = (ImageView) view.findViewById(R.id.capuchaF);
        img4.setImageDrawable(drawable4);

        //--------------------------------------------------------------------------------

        return view;
    }
}