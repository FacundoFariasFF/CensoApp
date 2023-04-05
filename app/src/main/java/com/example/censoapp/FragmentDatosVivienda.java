package com.example.censoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FragmentDatosVivienda extends Fragment {

    View rootView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentDatosVivienda() {
        // Required empty public constructor
    }

    public static FragmentDatosVivienda newInstance() {
        FragmentDatosVivienda fragment = new FragmentDatosVivienda();

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
        rootView = inflater.inflate(R.layout.fragment_datos_vivienda, container, false);

        Button btnContinuarGenerar = (Button) rootView.findViewById(R.id.btn_continuar_generar);
        Button btnVolverGenerar = (Button) rootView.findViewById(R.id.btn_volver_generar);





        btnContinuarGenerar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Continuar",Toast.LENGTH_SHORT).show();
            }
        });
        btnVolverGenerar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Volver",Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }



    public void Confirmacion(){
        FragmentDialogConfirmar dialogo = new FragmentDialogConfirmar();
        dialogo.show(getActivity().getSupportFragmentManager(), "dialogo");
        dialogo.ProcesarRespuesta(new FragmentDialogConfirmar.Respuestas() {
            @Override
            public void confirmar(FragmentDialogConfirmar dialog) {

                Toast.makeText(getContext(),"confirmaste los datos ingresados",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void modificar(FragmentDialogConfirmar dialog) {
            }
        });
    }



}