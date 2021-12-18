package com.example.aplicacionchaqueta.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplicacionchaqueta.R;

public class Fragment_Favoritos extends Fragment {

    private View view;

    public Fragment_Favoritos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //--------------------------------------------------------------------------------


        //--------------------------------------------------------------------------------

        return view;
    }
}