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


public class FragmentDatosPersona extends Fragment implements View.OnClickListener {

    View rootView;

    /*private static String[] opVacia = {"vacio.",
            "vacio.",
    };*/

    private static String[] opGenero = {"Mujer.", "Mujer trans / Travesti.", "Varón.",
            "Varón trans / Masculinidad trans.", "No binario: otra identidad.",
            "Ninguna de las anteriores o prefiero no contestar."
    };
    private static String[] opDiscapacidad = {"Si.", "No."
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



    EditText edtextFechaPersona;
    private int paso;
    String[] opciones = new String[0];
    String seleccionado;
    public FragmentDatosPersona() {
        // Required empty public constructor
    }

    public static FragmentDatosPersona newInstance(int paso) {
        FragmentDatosPersona fragment = new FragmentDatosPersona();
        Bundle args = new Bundle();
        args.putInt("paso", paso);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paso = getArguments().getInt("paso");

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
        TextView txtCantPreguntasPersona= (TextView) rootView.findViewById(R.id.txt_cant_preguntas_persona);
        edtextFechaPersona = (EditText) rootView.findViewById(R.id.edtext_fecha_persona);
        EditText edtextNro = (EditText) rootView.findViewById(R.id.edtext_nro);
        EditText edtextTexto = (EditText) rootView.findViewById(R.id.edtext_texto);

        txtCantPreguntasPersona.setText("Pregunta sobre la Persona "+paso+" de x");


        Boolean radiobuttom = true;
// tengo que pedir nombre, apellido, dni, fecha nacimeinto, genero
        // hay que arreglar las vistas de datos que no son radiobutton
        // validad que pasos saltea o no dependiendo de la pregunta anterior
        switch (paso){
            case 1: opciones=opGenero;
                txtTitulo.setText("De acuerdo a la identidad de género se considera:");
                break;
            case 2: opciones=opDiscapacidad;
                txtTitulo.setText("Tiene alguna dificultad o limitación para caminar o subir escaleras, recordar o concentrarse, comunicarse, oír, aun con el uso de audífonos, ver, aun con anteojos puestos y comer, bañarse o vestirse.");
                break;
            case 3: opciones=opCursa;
                txtTitulo.setText("¿Cursa o asiste a algún establecimiento educativo (guardería, jardín, escuela, universidad)?");
                //SI: deshabilita 6,7,8
                //NO: deshabilita 4,5
                break;
            case 4: opciones=opNivel;
                txtTitulo.setText("¿Qué nivel educativo está cursando?");
                break;
            case 5: //GradoAnioActual;
                txtTitulo.setText("¿Qué grado o año está cursando?");
                break;
            case 6: //NivelMayor
                txtTitulo.setText("¿Cuál fue el nivel más alto que cursó?");
                break;
            case 7: opciones=opCompletoNievelMayot;
                txtTitulo.setText("¿Completó ese nivel?");
                break;
            case 8: //CantAprobados
                txtTitulo.setText("¿Cuántos grados o años aprobó en ese nivel?");
                break;
            case 9: // lugar de nacimiento
                txtTitulo.setText("¿País , provincia y localidad de nacimiento?");
                break;
            case 10: opciones=opViviaHaceCincoAnios;
                txtTitulo.setText("¿Dónde vivía hace 5 años?");
                // en esta lcoalidad o no habia nacido: deshabilita 11
                break;
            case 11: //donde?
                txtTitulo.setText("Seleccione ubicacion");
                break;
            case 12: opciones=opCoberturaSalud;
                txtTitulo.setText("Cobertura de salud.");
                break;
            case 13: opciones=opCobraJubOPen;
                txtTitulo.setText("¿Cobra jubilación o pensión?");
                //SI:
                //No:
                break;
            case 14: opciones=opQueCobra;
                txtTitulo.setText("Cobra:");
                break;
            case 15: opciones=opIndigena;
                txtTitulo.setText("¿Se reconoce indígena o descendiente de pueblos indígenas u originarios?");
                break;
            case 16: //PuebloIndigina
                txtTitulo.setText("¿De qué pueblo indígena u originario?");
                break;
            case 17: opciones=opHablaLenguaIndigena;
                txtTitulo.setText("¿Habla y/o entiende la lengua de ese pueblo indígena u originario?");
                break;
            case 18: opciones=opAfrodescendiente;
                txtTitulo.setText("¿Se reconoce afrodescendiente o tiene antepasados negros o africanos?");
                break;
                ///Preguntas para los mayores de 14 años:
            case 19: opciones=opSemPasadTrabajo;
                txtTitulo.setText("Durante la semana pasada ¿trabajó por lo menos una hora, sin contar las tareas domésticas de su hogar?");
                break;
            case 20: opciones=opSemPasadChanga;
                txtTitulo.setText("En esa semana ¿hizo alguna changa, fabricó algo para vender afuera, ayudó a un familiar o amigo en su chacra o negocio?");
                break;
            case 21: opciones=opSemPasadFalto;
                txtTitulo.setText("En esa semana ¿tenía trabajo y no concurrió?");
                break;
            case 22: opciones=opCuatroSemBusco;
                txtTitulo.setText("Durante las últimas cuatro semanas ¿buscó trabajo de alguna manera?");
                break;
                ////Preguntas sobre el trabajo
            case 23: opciones=opTieneTrabajo;
                txtTitulo.setText("¿Actualmente tiene trabajo?");
                break;
            case 24: opciones=opEstadoTrabajo;
                txtTitulo.setText("¿Cómo realiza su trabajo?");
                break;
            case 25: opciones=opTrabajoDescJubi;
                txtTitulo.setText("En ese trabajo ¿le descuentan para la jubilación?");
                break;
            case 26: opciones=opTrabajoAportJubi;
                txtTitulo.setText("En ese trabajo ¿aporta por sí mismo para la jubilación?");
                break;
            case 27: opciones=opActividadTrabajo;
                txtTitulo.setText("Actividad principal de la empresa, negocio, institución en la que trabaja o del trabajo que realiza por su cuenta:");
                break;
            case 28: //descripcion
                txtTitulo.setText("¿Cómo describiría en detalle esa actividad principal de la empresa, negocio, institución en la que trabaja o del trabajo que realiza por su cuenta?");
                break;
                //mujeres de 14 a 49 años
            case 29: //
                txtTitulo.setText("¿Cuántas hijas e hijos nacidos vivos tuvo en total?");
                txtTitulo.setText("¿Cuántas hijas e hijos están vivos actualmente?");
                txtTitulo.setText("¿Cuál es la fecha de nacimiento de la última hija o hijo nacido vivo?");
                break;
            default:;
        }

        if(radiobuttom==false){ //si radio radiobuttom es false signific a que la pregunta no tiene opcioines de seleccion
            spinnerPersona.setVisibility(View.VISIBLE);
            rgPersona.setVisibility(View.GONE);
            spinnerPersona.setAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item, opciones));
        }else {
            for (String opcion : opciones) {
                RadioButton nuevoRadio = crearRadioButton(opcion);
                rgPersona.addView(nuevoRadio);
            }
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
        //// spinner

        spinnerPersona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cantidad = (String) spinnerPersona.getSelectedItem();
                seleccionado = cantidad;
                //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ cantidad,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No seleccionaron nada
            }
        });












        btnContinuarDatosPersona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //stepView.go(2,true); // esta instruccion pasa al siguiente paso
                //stepView.done(true);
                if(paso<33){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosPersona.newInstance(paso+1)).commit();
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
                if (paso>1){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosPersona.newInstance(paso-1)).commit();
                } else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_ingresar_datos,FragmentAgregarPersona.newInstance()).commit();
                }
            }
        });



        return rootView;
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