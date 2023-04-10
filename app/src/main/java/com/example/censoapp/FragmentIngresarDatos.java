package com.example.censoapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.shuhart.stepview.StepView;


public class FragmentIngresarDatos extends Fragment {

    View rootView;
    static StepView stepView;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentIngresarDatos() {
        // Required empty public constructor
    }

    public static FragmentIngresarDatos newInstance() {
        FragmentIngresarDatos fragment = new FragmentIngresarDatos();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_ingresar_datos, container, false);

        stepView = rootView.findViewById(R.id.step_view);

        stepView.getState()
                .animationType(StepView.ANIMATION_ALL)
                .stepsNumber(5)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .commit();


        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos,FragmentDatosVivienda.newInstance(1,FragmentDatosVivienda.respuestas)).commit();


        return rootView;
    }




}