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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FragmentDatosPersona extends Fragment implements View.OnClickListener {

    View rootView;

    /*private static String[] opVacia = {"vacio.",
            "vacio.",
    };*/

    private static String[] opGenero = {"Mujer.", "Mujer trans / Travesti.", "Varón.",
            "Varón trans / Masculinidad trans.", "No binario: otra identidad.",
            "Ninguna de las anteriores o prefiero no contestar."
    };
    private static String[] opBoolean = {"Si.", "No."
    };
    private static String[] opCursa = {"Si.", "No."
    };
    private static String[] opNivel = {"Jardín maternal.", "Guardería.", "Centro de cuidado.",
            "Salas de 0 a 3.", "Sala de 4 o 5 -jardín de infantes o preescolar.", "Primario.",
            "Secundario.", "Terciario no universitario.", "Universitario de grado.",
            "Posgrado -especialización.", "Maestría o doctorado."
    };
    private static String[] opCompletoNievelMayot = {"Si.", "No."
    };
    private static String[] opViviaHaceCincoAnios = {"En esta localidad o paraje.",
            "En otra localidad o paraje de esta provincia.", "Otra provincia argentina.",
            "Otro país.", "No había nacido."
    };
    private static String[] opCoberturaSalud = {"Tiene obra social o prepaga (incluye PAMI).",
            "Cuenta con programas o planes estatales de salud.",
            "No tiene obra social, prepaga ni plan estatal de salud.", "Ignorado."
    };
    private static String[] opCobraJubOPen = {"Si.","No."
    };
    private static String[] opQueCobra = {"Solo jubilación.", "Solo pensión por fallecimiento.",
            "Jubilación y pensión por fallecimiento.", "Solo pensión de otro tipo."
    };
    private static String[] opIndigena = {"Si.", "No."
    };
    private static String[] opHablaLenguaIndigena= {"Si.", "No."
    };
    private static String[] opAfrodescendiente = {"Si.", "No."
    };
    //personas mayores de 14 años
    private static String[] opSemPasadTrabajo = {"Si.", "No."
    };
    private static String[] opSemPasadChanga = {"Si.", "No."
    };
    private static String[] opSemPasadFalto = {"Si.", "No."
    };
    private static String[] opCuatroSemBusco = {"Si.", "No."
    };

    //trabajo
    private static String[] opTieneTrabajo = {"Si.", "No."
    };
    private static String[] opEstadoTrabajo = {"Servicio doméstico.", "Empleado u obrero.",
            "Cuenta propia.", "Patrón o empleador.", "Trabajador familiar.", "Ignorado."
    };
    private static String[] opTrabajoDescJubi = {"Si.", "No."
    };
    private static String[] opTrabajoAportJubi = {"Si.", "No."
    };
    private static String[] opActividadTrabajo = {"Educación o salud privada.",
            "Administración pública.", "Educación o salud pública.", "Comercio.",
            "Industria agropecuaria.", "Pesca o minería.", "Construcción.",
            "Transporte o almacenamiento.", "Hotel o restaurante.",
            "Banco, financiera o aseguradora.", "Empresa de electricidad, gas o agua.",
            "Otros servicios personales, técnicos o profesionales.",
    };


    ArrayList<Integer> deshabilitaOpNo = new ArrayList<>();
    ArrayList<Integer> deshabilitaOpSi = new ArrayList<>();
    int deshabilita =0;
    EditText edtextFechaPersona;
    private int indicePaso;
    ArrayList<Integer> pasos = new ArrayList<>();
    ArrayList<Integer> pasosAux = new ArrayList<>();
    String[] opciones = new String[0];
    String seleccionado="";
    String opcionRespuesta =""; // RadioGroupMultiple, RadioGroupBoolean, EditText;
    int canTextView = 1;
    int cantEditTextTexto = 0;
    int cantEditTextNro = 0;
    int cantEditTextFecha = 0;


    public FragmentDatosPersona() {
        // Required empty public constructor
    }

    public static FragmentDatosPersona newInstance(int indicePaso,ArrayList<Integer>pasos,ArrayList<Integer>pasosAux) {
        FragmentDatosPersona fragment = new FragmentDatosPersona();
        Bundle args = new Bundle();
        args.putInt("indicePaso", indicePaso);
        args.putIntegerArrayList("pasos", pasos);
        args.putIntegerArrayList("pasosAux", pasosAux);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            indicePaso = getArguments().getInt("indicePaso");
            pasos = getArguments().getIntegerArrayList("pasos");
            pasosAux = getArguments().getIntegerArrayList("pasosAux");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_datos_persona, container, false);

        Button btnContinuarDatosPersona = (Button) rootView.findViewById(R.id.btn_continuar_datos_persona);
        Button btnVolverDatosPersona = (Button) rootView.findViewById(R.id.btn_volver_datos_persona);
        RadioGroup rgPersona = (RadioGroup)rootView.findViewById(R.id.radiog_persona);
        Spinner spinnerPersona = (Spinner) rootView.findViewById(R.id.spinner_persona);
        TextView txtTitulo= (TextView) rootView.findViewById(R.id.txt_titulo_persona);
        TextView txtTituloAux= (TextView) rootView.findViewById(R.id.txt_titulo_aux);
        TextView txtTituloAuxDos= (TextView) rootView.findViewById(R.id.txt_titulo_aux_dos);
        TextView txtTituloFecha= (TextView) rootView.findViewById(R.id.txt_titulo_fecha);
        TextView txtCantPreguntasPersona= (TextView) rootView.findViewById(R.id.txt_cant_preguntas_persona);
        EditText edtextNro = (EditText) rootView.findViewById(R.id.edtext_nro);
        EditText edtextTexto = (EditText) rootView.findViewById(R.id.edtext_texto);
        EditText edtextTextoAux = (EditText) rootView.findViewById(R.id.edtext_aux);
        EditText edtextTextoAuxDos = (EditText) rootView.findViewById(R.id.edtext_aux_dos);
        edtextFechaPersona = (EditText) rootView.findViewById(R.id.edtext_fecha_persona);
        edtextFechaPersona.setOnClickListener(this);

        txtCantPreguntasPersona.setText("Pregunta sobre la Persona "+indicePaso+" de "+(pasos.size()-1));



        // validad que pasos saltea o no dependiendo de la pregunta anterior
        //validar si es mujer o +14 esas cosas
        switch (pasos.get(indicePaso)){
            case 1: opcionRespuesta="RadioGroupMultiple";
                opciones=opGenero;
                txtTitulo.setText("De acuerdo a la identidad de género se considera:");
                break;
            case 2:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("Tiene alguna dificultad o limitación para caminar o subir escaleras, recordar o concentrarse, comunicarse, oír, aun con el uso de audífonos, ver, aun con anteojos puestos y comer, bañarse o vestirse.");
                break;
            case 3:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Cursa o asiste a algún establecimiento educativo (guardería, jardín, escuela, universidad)?");
                //SI: deshabilita 6,7,8
                deshabilitaOpSi.add(6);
                deshabilitaOpSi.add(7);
                deshabilitaOpSi.add(8);
                //NO: deshabilita 4,5
                deshabilitaOpNo.add(4);
                deshabilitaOpNo.add(5);
                break;
            case 4:opcionRespuesta="RadioGroupMultiple";
                opciones=opNivel;
                txtTitulo.setText("¿Qué nivel educativo está cursando?");
                break;
            case 5: opcionRespuesta="EditText";
                txtTitulo.setText("¿Qué grado o año está cursando?");
                cantEditTextNro=1;
                break;
            case 6: opcionRespuesta="RadioGroupMultiple";
                opciones=opNivel;
                txtTitulo.setText("¿Cuál fue el nivel más alto que cursó?");
                break;
            case 7:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Completó ese nivel?");
                break;
            case 8: opcionRespuesta="EditText";
                txtTitulo.setText("¿Cuántos grados o años aprobó en ese nivel?");
                cantEditTextNro=1;
                break;
            case 9: opcionRespuesta="EditText";
                txtTitulo.setText("¿País de nacimiento?");
                txtTituloAux.setText("¿Provincia de nacimiento?");
                txtTituloAuxDos.setText("¿Localidad de nacimiento?");
                canTextView = 3;
                cantEditTextTexto = 3;
                break;
            case 10:opcionRespuesta="RadioGroupMultiple";
                opciones=opViviaHaceCincoAnios;
                txtTitulo.setText("¿Dónde vivía hace 5 años?");
                // en esta lcoalidad o no habia nacido: deshabilita 11
                deshabilita =11;
                break;
            case 11: opcionRespuesta="EditText";
                txtTitulo.setText("¿País donde vivia hace 5 años?");
                txtTituloAux.setText("¿Provincia donde vivia hace 5 años?");
                txtTituloAuxDos.setText("¿Localidad donde vivia hace 5 años?");
                canTextView = 3;
                cantEditTextTexto = 3;
                break;
            case 12:opcionRespuesta="RadioGroupMultiple";
                opciones=opCoberturaSalud;
                txtTitulo.setText("Cobertura de salud.");
                break;
            case 13:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Cobra jubilación o pensión?");
                //No: deshabilita 14
                deshabilitaOpNo.add(14);
                break;
            case 14:opcionRespuesta="RadioGroupMultiple";
                opciones=opQueCobra;
                txtTitulo.setText("Cobra:");
                break;
            case 15:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Se reconoce indígena o descendiente de pueblos indígenas u originarios?");
                //NO: deshabilita 16,17
                deshabilitaOpNo.add(16);
                deshabilitaOpNo.add(17);
                break;
            case 16: opcionRespuesta="EditText";
                txtTitulo.setText("¿De qué pueblo indígena u originario?");
                cantEditTextTexto=1;
                break;
            case 17:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Habla y/o entiende la lengua de ese pueblo indígena u originario?");
                break;
            case 18:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Se reconoce afrodescendiente o tiene antepasados negros o africanos?");
                break;
                ///Preguntas para los mayores de 14 años:
            case 19:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("Durante la semana pasada ¿trabajó por lo menos una hora, sin contar las tareas domésticas de su hogar?");
                break;
            case 20:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("En esa semana ¿hizo alguna changa, fabricó algo para vender afuera, ayudó a un familiar o amigo en su chacra o negocio?");
                break;
            case 21:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("En esa semana ¿tenía trabajo y no concurrió?");
                break;
            case 22:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("Durante las últimas cuatro semanas ¿buscó trabajo de alguna manera?");
                break;
                ////Preguntas sobre el trabajo
            case 23:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("¿Actualmente tiene trabajo?");
                //NO: deshabilita 24,25,26,27,,28
                deshabilitaOpNo.add(24);
                deshabilitaOpNo.add(25);
                deshabilitaOpNo.add(26);
                deshabilitaOpNo.add(27);
                deshabilitaOpNo.add(28);
                break;
            case 24:opcionRespuesta="RadioGroupMultiple";
                opciones=opEstadoTrabajo;
                txtTitulo.setText("¿Cómo realiza su trabajo?");
                break;
            case 25:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("En ese trabajo ¿le descuentan para la jubilación?");
                break;
            case 26:opcionRespuesta="RadioGroupBoolean";
                opciones=opBoolean;
                txtTitulo.setText("En ese trabajo ¿aporta por sí mismo para la jubilación?");
                break;
            case 27:opcionRespuesta="RadioGroupMultiple";
                opciones=opActividadTrabajo;
                txtTitulo.setText("Actividad principal de la empresa, negocio, institución en la que trabaja o del trabajo que realiza por su cuenta:");
                break;
            case 28: opcionRespuesta="EditText";
                txtTitulo.setText("¿Cómo describiría en detalle esa actividad principal de la empresa, negocio, institución en la que trabaja o del trabajo que realiza por su cuenta?");
                cantEditTextTexto = 1;
                break;
                //mujeres de 14 a 49 años
            case 29: opcionRespuesta="EditText";
                txtTitulo.setText("¿Cuántas hijas e hijos nacidos vivos tuvo en total?");
                //si es cero deshabilita 30
                //HACER ESTO
                deshabilita=30;
                cantEditTextNro=1;
                break;
            case 30: opcionRespuesta="EditText";
                txtTitulo.setText("¿Cuántas hijas e hijos están vivos actualmente?");
                txtTituloFecha.setText("¿Cuál es la fecha de nacimiento de la última hija o hijo nacido vivo?");
                canTextView = 2;
                cantEditTextNro = 1;
                cantEditTextFecha =1;
                break;
            default:;
        }

        switch (opcionRespuesta) {
            case "RadioGroupMultiple":
                for (String opcion : opciones) {
                    RadioButton nuevoRadio = crearRadioButton(opcion);
                    rgPersona.addView(nuevoRadio);
                }
                break;
            case "RadioGroupBoolean":
                for (String opcion : opciones) {
                    RadioButton nuevoRadio = crearRadioButton(opcion);
                    rgPersona.addView(nuevoRadio);
                }
                break;
            case "EditText":
                if (cantEditTextNro>0){
                    edtextNro.setVisibility(View.VISIBLE);
                    edtextNro.setFocusableInTouchMode(true);
                }
                if (cantEditTextTexto == 3){
                    edtextTexto.setVisibility(View.VISIBLE);
                    edtextTexto.setFocusableInTouchMode(true);
                    edtextTextoAux.setVisibility(View.VISIBLE);
                    edtextTextoAux.setFocusableInTouchMode(true);
                    edtextTextoAuxDos.setVisibility(View.VISIBLE);
                    edtextTextoAuxDos.setFocusableInTouchMode(true);
                } else if (cantEditTextTexto == 1) {
                    edtextTexto.setVisibility(View.VISIBLE);
                    edtextTexto.setFocusableInTouchMode(true);
                }
                if (cantEditTextFecha>0) {
                    txtTituloFecha.setVisibility(View.VISIBLE);
                    edtextFechaPersona.setVisibility(View.VISIBLE);
                }
                if (canTextView==3){
                    txtTituloAux.setVisibility(View.VISIBLE);
                    txtTituloAuxDos.setVisibility(View.VISIBLE);
                }

                break;
            default:;
        }

        //// escucha en el radiogroup
        rgPersona.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioSeleccionado;
                for (int i =0; i < opciones.length; i++){
                    radioSeleccionado= (RadioButton) rgPersona.getChildAt(i);
                    if((radioSeleccionado.getId())==checkedId){
                        seleccionado = opciones[i];
                        //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ opciones[i],Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /////
        btnContinuarDatosPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //stepView.go(2,true); // esta instruccion pasa al siguiente paso
                //stepView.done(true);
                pasosAux = (ArrayList<Integer>)pasos.clone();
                if(indicePaso<(pasos.size()-1)){
                    ControlPasos();
                }else {

                    stepView.go(1, true); // esta instruccion pasa al siguiente paso
                    stepView.done(true); //marcado como hecho
                    //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos, FragmentAgregarPersona.newInstance()).commit();
                }
            }
        });
        btnVolverDatosPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stepView.go(0,true);
                stepView.done(false); //marcado como no hecho
                pasos = (ArrayList<Integer>)pasosAux.clone();
                if (indicePaso>1){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosPersona.newInstance(indicePaso-1,pasos,pasosAux)).commit();
                } else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos,FragmentAgregarPersona.newInstance()).commit();
                }
            }
        });
        /////




        return rootView;
    }

    public void ControlPasos(){
        if (deshabilita>0){
            for (int i=1; i<=pasos.size()-1; i++){
                if (pasos.get(i).equals(deshabilita)){
                    pasos.remove(i);
                }
            }
        }
        if (seleccionado.equals("Si.")) {
            if (deshabilitaOpSi.size()>0){
                for (int i=0; i<=pasos.size()-1; i++){
                    for (int j=0; j<=deshabilitaOpSi.size()-1;j++){
                        if (deshabilitaOpSi.get(j).equals(pasos.get(i))){
                            pasos.remove(i);
                        }
                    }
                }
            }
        }
        if (seleccionado.equals("No.")) {
            if (deshabilitaOpNo.size()>0){
                for (int i=0; i<=pasos.size()-1; i++){
                    for (int j=0; j<=deshabilitaOpNo.size()-1;j++){
                        if (deshabilitaOpNo.get(j).equals(pasos.get(i))){
                            pasos.remove(i);
                        }
                    }
                }
            }
        }
        seleccionado="";
        getActivity().getSupportFragmentManager().beginTransaction().replace
                (R.id.fragment_container_view_ingresar_datos,FragmentDatosPersona.newInstance(indicePaso+1,pasos,pasosAux)).commit();
    }

// radiobutton
    private RadioButton crearRadioButton(String opciones) {
        RadioButton nuevoRadio = new RadioButton(getContext());
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(opciones);
        nuevoRadio.setTag(opciones);
        return nuevoRadio;
    }
//// calendario para buscar fechas
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtext_fecha_persona:
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
                edtextFechaPersona.setText(fechaSelec);
            }
            @Override
            public void CancelarCalendario(DialogFragment dialogCalendario) {
            }
        });
    }
////



}