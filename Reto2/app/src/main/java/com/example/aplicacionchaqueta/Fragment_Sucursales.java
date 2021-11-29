package com.example.aplicacionchaqueta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Sucursales extends Fragment {

    private View view;

    public Fragment_Sucursales() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //--------------------------------------------------------------------------------


        //--------------------------------------------------------------------------------

        return view;
    }
}