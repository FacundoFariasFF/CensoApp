package com.example.censoapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FragmentGenerarCodigo extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    View rootView;

    Button btnContinuarGenerar, btnVolverGenerar;
    EditText edtextNroDni, edtextFechaNacimiento,edtextDepartamento,edtextLocalidad,edtextNombreCalleRuta,
            edtextNroPuertaKm, edtextNroPiso, edtextDepartamentoPieza, edtextEntrada, edtextCasa;
    Spinner spinnerProvincia;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentGenerarCodigo() {
        // Required empty public constructor
    }

    public static FragmentGenerarCodigo newInstance() {
        FragmentGenerarCodigo fragment = new FragmentGenerarCodigo();

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
        rootView = inflater.inflate(R.layout.fragment_generar_codigo, container, false);

        btnContinuarGenerar = (Button) rootView.findViewById(R.id.btn_continuar_generar);
        btnVolverGenerar = (Button) rootView.findViewById(R.id.btn_volver_generar);


        edtextNroDni = (EditText) rootView.findViewById(R.id.edtext_nro_dni);
        edtextDepartamento = (EditText) rootView.findViewById(R.id.edtext_departamento);
        edtextLocalidad = (EditText) rootView.findViewById(R.id.edtext_localidad);
        edtextNombreCalleRuta = (EditText) rootView.findViewById(R.id.edtext_nombre_calle_ruta);
        edtextNroPuertaKm = (EditText) rootView.findViewById(R.id.edtext_nro_puerta_km);
        edtextNroPiso = (EditText) rootView.findViewById(R.id.edtext_nro_piso);
        edtextDepartamentoPieza = (EditText) rootView.findViewById(R.id.edtext_departamento_pieza);
        edtextEntrada = (EditText) rootView.findViewById(R.id.edtext_entrada);
        edtextCasa = (EditText) rootView.findViewById(R.id.edtext_casa);

        spinnerProvincia = (Spinner) rootView.findViewById(R.id.spinner_provincia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.provincias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapter);

        edtextFechaNacimiento = (EditText) rootView.findViewById(R.id.edtext_fecha_nacimiento);
        edtextFechaNacimiento.setOnClickListener(this);

        spinnerProvincia = (Spinner) rootView.findViewById(R.id.spinner_provincia);
        spinnerProvincia.setOnItemSelectedListener(this);

        btnContinuarGenerar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Confirmacion();
            }
        });
        btnVolverGenerar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,FragmentInicio.newInstance()).commit();
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
                CodigoVivienda();
            }
            @Override
            public void modificar(FragmentDialogConfirmar dialog) {
            }
        });
    }
    public void CodigoVivienda(){
        FragmentDialogCodigo dialogo = new FragmentDialogCodigo();
        dialogo.show(getActivity().getSupportFragmentManager(), "dialogo");
        dialogo.ProcesarRespuesta(new FragmentDialogCodigo.Respuestas() {
            @Override
            public void continuar(FragmentDialogCodigo dialog) {

                //Toast.makeText(getContext(),"continuar ya ingresate el codigo",Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,FragmentInicio.newInstance()).commit();
            }
            @Override
            public void cancelar(FragmentDialogCodigo dialog) {
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtext_fecha_nacimiento:
                Calendario();
                break;
        }
    }
    public void Calendario(){
        FragmentDialogCalendario dialogCalendario= new FragmentDialogCalendario();
        dialogCalendario.show(getActivity().getSupportFragmentManager(),"dialogo");
        dialogCalendario.ProcesarRespuestaCalendario(new FragmentDialogCalendario.RespuestasCalendario() {
            @Override
            public void ConfirmarCalendario(DialogFragment dialogCalendario, LocalDate fechaseleccionada) {
                String fechaSelec;
                DateTimeFormatter formatoBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaSelec = fechaseleccionada.format(formatoBarra);
                edtextFechaNacimiento.setText(fechaSelec);
            }
            @Override
            public void CancelarCalendario(DialogFragment dialogCalendario) {
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // Se seleccionó un elemento. Puede recuperar el elemento seleccionado usando
        // parent.getItemAtPosition(pos)
        Toast.makeText(getContext(),"seleccionaste"+parent.getItemAtPosition(pos) ,Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Otra devolución de llamada de interfaz
    }

}