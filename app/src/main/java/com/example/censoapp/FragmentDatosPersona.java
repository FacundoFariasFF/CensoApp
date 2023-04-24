package com.example.censoapp;

import static com.example.censoapp.FragmentIngresarDatos.stepView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private static String[] opNivel = {"Jardín maternal.", "Guardería.", "Centro de cuidado.",
            "Salas de 0 a 3.", "Sala de 4 o 5 -jardín de infantes o preescolar.", "Primario.",
            "Secundario.", "Terciario no universitario.", "Universitario de grado.",
            "Posgrado -especialización.", "Maestría o doctorado."
    };
    private static String[] opViviaHaceCincoAnios = {"En esta localidad o paraje.",
            "En otra localidad o paraje de esta provincia.", "Otra provincia argentina.",
            "Otro país.", "No había nacido."
    };
    private static String[] opCoberturaSalud = {"Tiene obra social o prepaga (incluye PAMI).",
            "Cuenta con programas o planes estatales de salud.",
            "No tiene obra social, prepaga ni plan estatal de salud.", "Ignorado."
    };
    private static String[] opQueCobra = {"Solo jubilación.", "Solo pensión por fallecimiento.",
            "Jubilación y pensión por fallecimiento.", "Solo pensión de otro tipo."
    };
    //trabajo
    private static String[] opTieneTrabajo = {"Si.", "No."
    };
    private static String[] opEstadoTrabajo = {"Servicio doméstico.", "Empleado u obrero.",
            "Cuenta propia.", "Patrón o empleador.", "Trabajador familiar.", "Ignorado."
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
    ArrayList<String> deshabilitaCondicion = new ArrayList<>();
    ArrayList<Integer> deshabilita = new ArrayList<>();
    ArrayList<Integer> pasos = new ArrayList<>();
    ArrayList<Integer> pasosAux = new ArrayList<>();
    String[] opciones = new String[0];
    ArrayList<String> seleccionado = new ArrayList<>();

    static List<Persona> personaList = new ArrayList<>(); // lista con los datos de las personas esto deberia ir a la db
    //static String[] respuestasPersona = new String[30];
    static String[] respuestasPersona = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","0","0","0","0","0","0","0","01/01/9999",};

    List<PersonaAgregada> personaAgregadaList = new ArrayList<>();
    String opcionRespuesta =""; // RadioGroupMultiple, RadioGroupBoolean, EditText;
    private int nroPersona;
    private int indicePaso;
    int canTextView = 1;
    int cantEditTextTexto = 0;
    int cantEditTextNro = 0;
    int cantEditTextFecha = 0;
    Boolean respuestaVacia = true;
    EditText edtextFechaPersona;
    RadioGroup rgPersona;
    TextView txtTitulo;
    TextView txtTituloAux;
    TextView txtTituloAuxDos;
    TextView txtTituloFecha;
    TextView txtCantPreguntasPersona;
    TextView txtCantPersona;
    EditText edtextNro;
    EditText edtextTexto;
    EditText edtextTextoAux;
    EditText edtextTextoAuxDos;
    public FragmentDatosPersona() {
        // Required empty public constructor
    }

    public static FragmentDatosPersona newInstance(int nroPersona, int indicePaso,ArrayList<Integer>pasos,ArrayList<Integer>pasosAux, String[] respuestasPersona) {
        FragmentDatosPersona fragment = new FragmentDatosPersona();
        Bundle args = new Bundle();
        args.putInt("nroPersona", nroPersona);
        args.putInt("indicePaso", indicePaso);
        args.putIntegerArrayList("pasos", pasos);
        args.putIntegerArrayList("pasosAux", pasosAux);
        args.putStringArray("respuestasPersona", respuestasPersona);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nroPersona = getArguments().getInt("nroPersona");
            indicePaso = getArguments().getInt("indicePaso");
            pasos = getArguments().getIntegerArrayList("pasos");
            pasosAux = getArguments().getIntegerArrayList("pasosAux");
            respuestasPersona = getArguments().getStringArray("respuestasPersona");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_datos_persona, container, false);

        Button btnContinuarDatosPersona = (Button) rootView.findViewById(R.id.btn_continuar_datos_persona);
        Button btnVolverDatosPersona = (Button) rootView.findViewById(R.id.btn_volver_datos_persona);
        rgPersona = (RadioGroup)rootView.findViewById(R.id.radiog_persona);
        //Spinner spinnerPersona = (Spinner) rootView.findViewById(R.id.spinner_persona);
        txtCantPreguntasPersona= (TextView) rootView.findViewById(R.id.txt_cant_preguntas_persona);
        txtCantPersona= (TextView) rootView.findViewById(R.id.txt_cant_persona);
        txtTitulo= (TextView) rootView.findViewById(R.id.txt_titulo_persona);
        txtTituloAux= (TextView) rootView.findViewById(R.id.txt_titulo_aux);
        txtTituloAuxDos= (TextView) rootView.findViewById(R.id.txt_titulo_aux_dos);
        txtTituloFecha= (TextView) rootView.findViewById(R.id.txt_titulo_fecha);
        edtextNro = (EditText) rootView.findViewById(R.id.edtext_nro);
        edtextTexto = (EditText) rootView.findViewById(R.id.edtext_texto);
        edtextTextoAux = (EditText) rootView.findViewById(R.id.edtext_aux);
        edtextTextoAuxDos = (EditText) rootView.findViewById(R.id.edtext_aux_dos);
        edtextFechaPersona = (EditText) rootView.findViewById(R.id.edtext_fecha_persona);
        edtextFechaPersona.setOnClickListener(this);

        personaAgregadaList=FragmentAgregarPersona.personaAgregadaList; // es la lista de personas de las personas del hogar con sus datos de carga
        txtCantPersona.setText("Persona "+(nroPersona+1)+" de "+(personaAgregadaList.size()));
        txtCantPreguntasPersona.setText("Pregunta sobre "+ personaAgregadaList.get(nroPersona).getNombre()+", " + indicePaso+" de "+(pasos.size()-1));

        GenerarOpciones();

        CrearOpcionRespuesta(opcionRespuesta);

        //// escucha en el radiogroup
        rgPersona.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioSeleccionado;
                for (int i =0; i < opciones.length; i++){
                    radioSeleccionado= (RadioButton) rgPersona.getChildAt(i);
                    if((radioSeleccionado.getId())==checkedId){
                        seleccionado.add(opciones[i]);
                        //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ opciones[i],Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /////
        btnContinuarDatosPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ObtenerRespuesta();
                if (respuestaVacia ==false) {
                    pasosAux = (ArrayList<Integer>) pasos.clone();
                    if (indicePaso + 2 < (pasos.size() - 1)) {
                        ControlPasos();
                        GuardarRespuesta();
                        getActivity().getSupportFragmentManager().beginTransaction().replace
                                (R.id.fragment_container_view_ingresar_datos, FragmentDatosPersona.newInstance
                                        (nroPersona, indicePaso + 1, pasos, pasosAux, respuestasPersona)).commit();
                    } else {
                        GenerarListaPersona();
                        if (nroPersona < personaAgregadaList.size() - 1) {
                            ArrayList<Integer> pasos = new ArrayList<>();
                            ArrayList<Integer> pasosAux = new ArrayList<>();
                            for (int i = 0; i <= 31; i++) { //31 son las preguntas sobre la personas/(los pasos de persona)
                                pasos.add(i, i);
                            }
                            pasosAux = pasos;
                            LimpiarRespuestas();
                            getActivity().getSupportFragmentManager().beginTransaction().replace
                                    (R.id.fragment_container_view_ingresar_datos, FragmentDatosPersona.newInstance
                                            (nroPersona + 1, 1, pasos, pasosAux, respuestasPersona)).commit();
                        } else {
                            stepView.done(true); //marca el step como hecho
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, FragmentIngresarDatos.newInstance(4)).commit();
                        }
                    }
                } else {
                    Toast.makeText(getContext(),"Debe seleccionar una opción",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnVolverDatosPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pasos = (ArrayList<Integer>)pasosAux.clone();
                if (indicePaso>1){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosPersona.newInstance(nroPersona,indicePaso-1,pasos,pasosAux,respuestasPersona)).commit();
                } else{
                    stepView.go(1,false);
                    stepView.done(false); //marcado como no hecho
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos,FragmentAgregarPersona.newInstance()).commit();
                }
            }
        });
        /////



        return rootView;
    }
    public void GenerarOpciones(){
        // validad que pasos saltea o no dependiendo de la pregunta anterior
        //validar si es mujer o +14 esas cosas
        switch (pasos.get(indicePaso)){
            case 1: opcionRespuesta="RadioGroupMultiple";
                opciones=opGenero;
                txtTitulo.setText("De acuerdo a la identidad de género se considera:");
                break;
            case 2:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("Tiene alguna dificultad o limitación para caminar o subir escaleras, recordar o concentrarse, comunicarse, oír, aun con el uso de audífonos, ver, aun con anteojos puestos y comer, bañarse o vestirse.");
                break;
            case 3:opcionRespuesta="RadioGroupMultiple";
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
            case 7:opcionRespuesta="RadioGroupMultiple";
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
                deshabilitaCondicion.add("En esta localidad o paraje.");
                deshabilitaCondicion.add("No había nacido.");
                deshabilita.add(11);
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
            case 13:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("¿Cobra jubilación o pensión?");
                //No: deshabilita 14
                deshabilitaOpNo.add(14);
                break;
            case 14:opcionRespuesta="RadioGroupMultiple";
                opciones=opQueCobra;
                txtTitulo.setText("Cobra:");
                break;
            case 15:opcionRespuesta="RadioGroupMultiple";
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
            case 17:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("¿Habla y/o entiende la lengua de ese pueblo indígena u originario?");
                break;
            case 18:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("¿Se reconoce afrodescendiente o tiene antepasados negros o africanos?");
                break;
            ///Preguntas para los mayores de 14 años:
            case 19:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("Durante la semana pasada ¿trabajó por lo menos una hora, sin contar las tareas domésticas de su hogar?");
                break;
            case 20:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("En esa semana ¿hizo alguna changa, fabricó algo para vender afuera, ayudó a un familiar o amigo en su chacra o negocio?");
                break;
            case 21:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("En esa semana ¿tenía trabajo y no concurrió?");
                break;
            case 22:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("Durante las últimas cuatro semanas ¿buscó trabajo de alguna manera?");
                break;
            ////Preguntas sobre el trabajo
            case 23:opcionRespuesta="EditText";
                txtTitulo.setText("¿Actualmente cuántos trabajos tiene?(si no tiene trabajo ingrese cero)");
                deshabilitaCondicion.add("0");
                cantEditTextNro=1;
                //deshabilita 24,25,26,27,,28
                deshabilita.add(24);
                deshabilita.add(25);
                deshabilita.add(26);
                deshabilita.add(27);
                deshabilita.add(28);
                break;
            case 24:opcionRespuesta="RadioGroupMultiple";
                opciones=opEstadoTrabajo;
                txtTitulo.setText("¿Cómo realiza su trabajo principal?");
                break;
            case 25:opcionRespuesta="RadioGroupMultiple";
                opciones=opBoolean;
                txtTitulo.setText("En ese trabajo ¿le descuentan para la jubilación?");
                break;
            case 26:opcionRespuesta="RadioGroupMultiple";
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
                deshabilitaCondicion.add("0");
                deshabilita.add(30);
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
    }
    public void CrearOpcionRespuesta(String opcionRespuesta){
        switch (this.opcionRespuesta) {
            case "RadioGroupMultiple":
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
    }
    public void ObtenerRespuesta(){

        if (!opcionRespuesta.equals("RadioGroupMultiple")) {
            if (!edtextNro.getText().equals("")) {
                seleccionado.add(String.valueOf(edtextNro.getText()));
            }
            if (!edtextTexto.getText().equals("")) {
                seleccionado.add(String.valueOf(edtextTexto.getText()));

            }
            if (!edtextTextoAux.getText().equals("")) {
                seleccionado.add(String.valueOf(edtextTextoAux.getText()));
            }
            if (!edtextTextoAuxDos.getText().equals("")) {
                seleccionado.add(String.valueOf(edtextTextoAuxDos.getText()));
            }

            if (!edtextFechaPersona.getText().equals("")) {
                seleccionado.add(String.valueOf(edtextFechaPersona.getText()));
            }
            respuestaVacia = false;
        }else {
            if (seleccionado.size()!=0){
                respuestaVacia = false;
            }
        }
    }
    public void GuardarRespuesta(){
        switch (pasos.get(indicePaso)){
            case 1: respuestasPersona[0] = seleccionado.get(0); //genero
                break;
            case 2: respuestasPersona[1] = seleccionado.get(0); //discapacidad
                break;
            case 3: respuestasPersona[2] = seleccionado.get(0); //cursa
                break;
            case 4: respuestasPersona[3] = seleccionado.get(0); //nivel
                break;
            case 5: respuestasPersona[4] = seleccionado.get(0); //gradoAnioActual
                break;
            case 6: respuestasPersona[5] = seleccionado.get(0); //nivelMayor
                break;
            case 7: respuestasPersona[6] = seleccionado.get(0); //completoNievelMayot
                break;
            case 8: respuestasPersona[7] = seleccionado.get(0); //cantAprobados
                break;
            case 9: respuestasPersona[8] = seleccionado.get(1); //nacimientoPais
                    respuestasPersona[9] = seleccionado.get(2); //nacimientoProvincia
                    respuestasPersona[10] = seleccionado.get(3); //nacimientoLocalidad
                break;
            case 10: respuestasPersona[11] = seleccionado.get(0); //viviaHaceCincoAnios
                break;
            case 11: respuestasPersona[12] = seleccionado.get(0); //haceCincoAniosNacimientoPais
                     respuestasPersona[13] = seleccionado.get(1); //haceCincoAniosNacimientoProvincia
                     respuestasPersona[14] = seleccionado.get(2); //haceCincoAniosNacimientoLocalidad
                break;
            case 12: respuestasPersona[15] = seleccionado.get(0); //coberturaSalud
                break;
            case 13: respuestasPersona[16] = seleccionado.get(0); //cobraJubOPen
                break;
            case 14: respuestasPersona[17] = seleccionado.get(0); //queCobra
                break;
            case 15: respuestasPersona[18] = seleccionado.get(0); //indigena
                break;
            case 16: respuestasPersona[19] = seleccionado.get(0); //puebloIndigina
                break;
            case 17: respuestasPersona[20] = seleccionado.get(0); //hablaLenguaIndigena
                break;
            case 18: respuestasPersona[21] = seleccionado.get(0); //afrodescendiente
                break;
            case 19: respuestasPersona[22] = seleccionado.get(0); //semPasadTrabajo
                break;
            case 20: respuestasPersona[23] = seleccionado.get(0); //semPasadChanga
                break;
            case 21: respuestasPersona[24] = seleccionado.get(0); //semPasadFalto
                break;
            case 22: respuestasPersona[25] = seleccionado.get(0); //cuatroSemBusco
                break;
            case 23: respuestasPersona[26] = seleccionado.get(0); //tieneTrab
                break;
            case 24: respuestasPersona[27] = seleccionado.get(0); //estadoTrabajo
                break;
            case 25: respuestasPersona[28] = seleccionado.get(0); //trabajoDescJubi
                break;
            case 26: respuestasPersona[29] = seleccionado.get(0); //trabajoAportJubi
                break;
            case 27: respuestasPersona[30] = seleccionado.get(0); //actividadTrabajo
                break;
            case 28: respuestasPersona[31] = seleccionado.get(1); //detalleTrabajo
                break;
            case 29: respuestasPersona[32] = seleccionado.get(0); //hijosNacidos
                break;
            case 30: respuestasPersona[33] = seleccionado.get(0); //hijosVivos
                     respuestasPersona[34] = seleccionado.get(1); //fechaNacUltimoHijo
                break;
            default:;
        }


    }
    public void GenerarListaPersona(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterbarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFechaNacimiento = LocalDate.parse((String.valueOf(personaAgregadaList.get(nroPersona).getFechaNacimiento())), formatter);
        LocalDate dateFechaNacUltimoHijo;
        dateFechaNacUltimoHijo = LocalDate.parse(respuestasPersona[34], formatterbarra);

        // lo comentado es el dato del parametro correspondiente de Persona
        Persona persona = new Persona(
                Integer.parseInt(String.valueOf((personaAgregadaList.get(nroPersona).getNroDni()))), //int nroDni
                String.valueOf(personaAgregadaList.get(nroPersona).getNombre()), //String nombre
                String.valueOf(personaAgregadaList.get(nroPersona).getApellido()), //String apellido
                String.valueOf(personaAgregadaList.get(nroPersona).getSexo()), //String sexo
                dateFechaNacimiento, // LocalDate fechaNacimiento
                "relacionReferencia", //String relacionReferencia
                respuestasPersona[0], //String genero
                respuestasPersona[1], //String discapacidad
                respuestasPersona[2], //String cursa
                respuestasPersona[3], //String nivel
                respuestasPersona[4], //String gradoAnioActual
                respuestasPersona[5], //String nivelMayor
                respuestasPersona[6], //String completoNievelMayor
                respuestasPersona[7], //String cantAprobados
                respuestasPersona[8], //String nacimientoPais
                respuestasPersona[9], //String nacimientoProvincia
                respuestasPersona[10], //String nacimientoLocalidad
                respuestasPersona[11], //String viviaHaceCincoAnios
                respuestasPersona[12], //String haceCincoAniosNacimientoPais
                respuestasPersona[13], //String haceCincoAniosNacimientoProvincia
                respuestasPersona[14], //String haceCincoAniosNacimientoLocalidad
                respuestasPersona[15], //String coberturaSalud
                respuestasPersona[16], //String cobraJubOPen
                respuestasPersona[17], //String queCobra
                respuestasPersona[18], //String indigena
                respuestasPersona[19], //String puebloIndigina
                respuestasPersona[20], //String hablaLenguaIndigena
                respuestasPersona[21], //String afrodescendiente
                respuestasPersona[22], //String semPasadTrabajo
                respuestasPersona[23], //String semPasadChanga
                respuestasPersona[24], //String semPasadFalto
                respuestasPersona[25], //String cuatroSemBusco
                respuestasPersona[26], //String tieneTrab
                respuestasPersona[27], //String estadoTrabajo
                respuestasPersona[28], //String trabajoDescJubi
                respuestasPersona[29], //String trabajoAportJubi
                respuestasPersona[30], //String actividadTrabajo
                respuestasPersona[31], //String detalleTrabajo
                Integer.parseInt(respuestasPersona[32]), //int hijosNacidos
                Integer.parseInt(respuestasPersona[33]), //int hijosVivos
                dateFechaNacUltimoHijo); //LocalDate fechaNacUltimoHijo

        personaList.add(persona);

        AdminSQLiteOpenHelper.getInstance(getActivity()).EliminarPersona();


        AdminSQLiteOpenHelper.getInstance(getActivity()).RegistrarPersona(personaList);

        Toast.makeText(getContext(),"Se guardaron los datos de la persona",Toast.LENGTH_SHORT).show();
    }
    public void ControlPasos(){
        if (deshabilita.size()>0){
            for (int i=0; i<=deshabilitaCondicion.size()-1; i++){
                if (deshabilitaCondicion.get(i).equals(seleccionado.get(0))){
                    for (int j=1; j<=pasos.size()-1; j++){
                        for (int k=0; k<=deshabilita.size()-1;k++){
                            if (deshabilita.get(k).equals(pasos.get(j))){
                                pasos.remove(j);
                            }
                        }
                    }
                }
            }
        }
        if ((seleccionado.get(0)).equals("Si.")) {
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
        if ((seleccionado.get(0)).equals("No.")) {
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
        //seleccionado.clear();
    }
    public void LimpiarRespuestas(){
        respuestasPersona = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "0", "0", "0", "0", "0", "0", "0", "01/01/9999",};
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