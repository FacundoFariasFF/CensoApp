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

import java.util.ArrayList;


public class FragmentIngresarDatos extends Fragment {

    View rootView;
    static StepView stepView;

    private int nroPaso;



    public FragmentIngresarDatos() {
        // Required empty public constructor
    }

    public static FragmentIngresarDatos newInstance(int nroPaso) {
        FragmentIngresarDatos fragment = new FragmentIngresarDatos();
        Bundle args = new Bundle();
        args.putInt("nroPaso", nroPaso);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nroPaso = getArguments().getInt("nroPaso");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_ingresar_datos, container, false);

        stepView = rootView.findViewById(R.id.step_view);

        stepView.getState()
                .animationType(StepView.ANIMATION_ALL)
                .steps(new ArrayList<String>() {{
                    add("Caracteristicas de la vivienda");
                    add("Personas del hogar");
                    add("Datos de cada persona");
                    add("Comprobante");
                }})
                .stepsNumber(5)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .commit();

        TextView step = (TextView) rootView.findViewById(R.id.txt_steptext);
        TextView descripcion = (TextView) rootView.findViewById(R.id.txt_descripciontext);

        step.setText("CensoApp");
        switch (nroPaso){
            case  1:stepView.go(0,true); // esta instruccion pasa al siguiente paso
                descripcion.setText("Ingrese los datos sobre su vivienda");
                getActivity().getSupportFragmentManager().beginTransaction().replace
                       (R.id.fragment_container_view_ingresar_datos,FragmentDatosVivienda.newInstance
                               (1,FragmentDatosVivienda.respuestasVivienda)).commit();
                break;
            case 2:stepView.go(1,true); // esta instruccion pasa al siguiente paso
                descripcion.setText("Ingrese los datos sobre las personas de su hogar");
                getActivity().getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container_view_ingresar_datos, FragmentAgregarPersona.newInstance()).commit();
                break;
            case 3:stepView.go(2,true); // esta instruccion pasa al siguiente paso
                descripcion.setText("Ingrese los datos de la persona");
                ArrayList<Integer> pasos = new ArrayList<>();
                ArrayList<Integer> pasosAux = new ArrayList<>();
                for (int i=0; i<=31; i++){ //31 son las preguntas sobre la personas/(los pasos de persona)
                    pasos.add(i,i);
                }
                pasosAux = pasos;
                getActivity().getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container_view_ingresar_datos, FragmentDatosPersona.newInstance
                                (0,1,pasos,pasosAux,FragmentDatosPersona.respuestasPersona)).commit();
                break;
            case 4:
                stepView.go(3,true); // esta instruccion pasa al siguiente paso
                descripcion.setText("Comprobante de censo completado");
                getActivity().getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container_view,FragmentComprobante.newInstance()).commit();
                break;
            default:;

        }

        //IMPORTANTE: controlar desde aca el ingreso de datos, es decir agregar aca abajo el grafment persona etc, manejarlo por el numero de paso


        return rootView;
    }




}