package com.example.censoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentInicio extends Fragment {

    View rootView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentInicio() {
        // Required empty public constructor
    }

    public static FragmentInicio newInstance() {
        FragmentInicio fragment = new FragmentInicio();

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
        rootView = inflater.inflate(R.layout.fragment_inicio, container, false);


        Button btnGenerarCodigo = (Button) rootView.findViewById(R.id.btn_generar_codigo);
        Button btnIngresar = (Button) rootView.findViewById(R.id.btn_ingresar);


        btnGenerarCodigo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,FragmentGenerarCodigo.newInstance()).commit();


                //Toast.makeText(getContext(),"Continuar",Toast.LENGTH_SHORT).show();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                CodigoVivienda();

                //Toast.makeText(getContext(),"Ingresar",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void CodigoVivienda(){
        FragmentDialogCodigo dialogo = new FragmentDialogCodigo();
        dialogo.show(getActivity().getSupportFragmentManager(), "dialogo");
        dialogo.ProcesarRespuesta(new FragmentDialogCodigo.Respuestas() {
            @Override
            public void continuar(FragmentDialogCodigo dialog) {

               //Toast.makeText(getContext(),"continuar ya ingresate el codigo",Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,FragmentIngresarDatos.newInstance()).commit();
            }
            @Override
            public void cancelar(FragmentDialogCodigo dialog) {
            }
        });
    }

}