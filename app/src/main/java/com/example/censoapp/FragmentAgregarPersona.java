package com.example.censoapp;

import static com.example.censoapp.FragmentIngresarDatos.stepView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FragmentAgregarPersona extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener  {

    View rootView;
    private static String[] opSexo = {"","Mujer / Femenino.", "Varón / Masculino.",
            "X / Ninguna de las anteriores."
    };

    TextView txtNroPersona;
    EditText edtextFechaNacimiento;
    Spinner spinnerSexo;
    int nroCant=0, nroPersona=0;
    String nombre,apellido,nroDNI;
    List<Persona> personaList;

    public FragmentAgregarPersona() {
        // Required empty public constructor
    }

    public static FragmentAgregarPersona newInstance() {
        FragmentAgregarPersona fragment = new FragmentAgregarPersona();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_agregar_persona, container, false);

        Button btnContinuarAgregar = (Button) rootView.findViewById(R.id.btn_continuar_agregar);
        Button btnVolverAgregar = (Button) rootView.findViewById(R.id.btn_volver_agregar);
        Button btnConfirmarCantidad = (Button) rootView.findViewById(R.id.btn_confirmar_cantidad_personas);
        Button btnAgregarPersona = (Button) rootView.findViewById(R.id.btn_agregar_persona);
        txtNroPersona= (TextView) rootView.findViewById(R.id.txt_nro_persona);
        TextView txtNombre= (TextView) rootView.findViewById(R.id.txt_nombre);
        TextView txtApellido= (TextView) rootView.findViewById(R.id.txt_apellido);
        TextView txtSexo= (TextView) rootView.findViewById(R.id.txt_sexo);
        TextView txtDni= (TextView) rootView.findViewById(R.id.txt_dni);
        TextView txtFechaNacimiento= (TextView) rootView.findViewById(R.id.txt_fecha_de_nacimiento);

        EditText edtextCantPersonas = (EditText) rootView.findViewById(R.id.edtext_cant_personas);
        EditText edtextNombre = (EditText) rootView.findViewById(R.id.edtext_nombre);
        EditText edtextApellido = (EditText) rootView.findViewById(R.id.edtext_apellido);
        EditText edtextNroDni = (EditText) rootView.findViewById(R.id.edtext_nro_dni);
        edtextFechaNacimiento = (EditText) rootView.findViewById(R.id.edtext_fecha_nacimiento);

        edtextFechaNacimiento.setOnClickListener(this);

        spinnerSexo = (Spinner) rootView.findViewById(R.id.spinner_sexo);
        spinnerSexo.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,opSexo));

        spinnerSexo.setOnItemSelectedListener(this);

        btnAgregarPersona.setVisibility(View.INVISIBLE);
        edtextNombre.setFocusable(View.NOT_FOCUSABLE);
        edtextApellido.setFocusable(View.NOT_FOCUSABLE);
        edtextNroDni.setFocusable(View.NOT_FOCUSABLE);












        btnConfirmarCantidad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nroCant = Integer.parseInt(String.valueOf(edtextCantPersonas.getText()));
                if (nroCant !=0) {
                    btnConfirmarCantidad.setVisibility(View.GONE);
                    edtextCantPersonas.setFocusable(View.NOT_FOCUSABLE);
                    txtNombre.setVisibility(View.VISIBLE);
                    edtextNombre.setVisibility(View.VISIBLE);
                    edtextNombre.setFocusableInTouchMode(true);
                    txtApellido.setVisibility(View.VISIBLE);
                    edtextApellido.setVisibility(View.VISIBLE);
                    edtextApellido.setFocusableInTouchMode(true);
                    txtSexo.setVisibility(View.VISIBLE);
                    spinnerSexo.setVisibility(View.VISIBLE);
                    spinnerSexo.setFocusableInTouchMode(true);
                    txtDni.setVisibility(View.VISIBLE);
                    edtextNroDni.setVisibility(View.VISIBLE);
                    edtextNroDni.setFocusableInTouchMode(true);
                    txtFechaNacimiento.setVisibility(View.VISIBLE);
                    edtextFechaNacimiento.setVisibility(View.VISIBLE);
                    btnAgregarPersona.setVisibility(View.VISIBLE);

                    nroPersona = 1;
                    txtNroPersona.setText("Pesona "+nroPersona+" de "+ nroCant +".");
                }
                else {

                }
            }
        });
        btnAgregarPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getContext(),edtextCantPersonas.getText(),Toast.LENGTH_SHORT).show();
                if (nroPersona < nroCant){

                    nombre = edtextNombre.getText().toString();
                    apellido = edtextApellido.getText().toString();
                    nroDNI = edtextNroDni.getText().toString();
                    nroPersona++;
                    txtNroPersona.setText("Pesona "+nroPersona+" de "+ nroCant +".");
                    //Persona persona = new Persona(nombre,apellido,nroDNI);


                    //personaList = new ArrayList<>();
                    //personaList.add(persona);

                    edtextNombre.setText("");
                    edtextApellido.setText("");
                    spinnerSexo.setSelection(0);
                    edtextNroDni.setText("");
                    edtextFechaNacimiento.setText("");

                }else if (nroPersona == nroCant){
                    txtNroPersona.setText("Pesona "+nroPersona+" de "+ nroCant +".");
                    btnAgregarPersona.setVisibility(View.INVISIBLE);
                    btnContinuarAgregar.setVisibility(View.VISIBLE);
                }
            }
        });
        btnContinuarAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container_view_ingresar_datos, FragmentDatosPersona.newInstance(1)).commit();
                //stepView.go(2,true); // esta instruccion pasa al siguiente paso
                //stepView.done(true);
            }
        });
        btnVolverAgregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stepView.go(0,true);
                stepView.done(false); //marcado como no hecho
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos,FragmentDatosVivienda.newInstance(16,FragmentDatosVivienda.respuestas)).commit();
                //Toast.makeText(getContext(),"Volver",Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }

//// spinner para seleccionar el sexo
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Se seleccionó un elemento. Puede recuperar el elemento seleccionado usando
        // parent.getItemAtPosition(pos)
        Toast.makeText(getContext(),"seleccionaste"+parent.getItemAtPosition(pos) ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Otra devolución de llamada de interfaz
    }
////calendario para fecha de nacimiento
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
///////



}