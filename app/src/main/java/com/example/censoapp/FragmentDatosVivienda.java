package com.example.censoapp;

import static com.example.censoapp.FragmentIngresarDatos.stepView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class FragmentDatosVivienda extends Fragment {

    View rootView;


    private static String[] opTipoVivienda = {"Casa.", "Rancho.", "Casilla.", "Departamento.",
            "Pieza ocupada en inquilinato.", "Hotel familiar o pensión.",
            "Local no construido para habitación ocupado.", "Vivienda móvil ocupada -Casa rodante.",
            "Barco.","Carpa u otra - persona en situación de calle."
    };
    private static String[] opSituacion = {"Propia.", "Alquilada.", "Cedida por trabajo.",
            "Prestada u otra situación."
    };
    private static String[] opDocumentacion = {"Escritura.", "Boleto de compra-venta.",
            "Otra documentación.", "No tiene documentación.",
    };
    private static String[] opMaterialPisos = {"Cerámica.", "Mosaico.", "Baldosa.", "Alfombra.",
            "Madera.", "Flotante.", "Vinílico.", "Microcemento.", "Cemento alisado o mármol.",
            "Carpeta.", "Contrapiso.", "Ladrillo fijo o tierra o ladrillo suelto."
    };
    private static String[] opMaterialTecho = {"Baldosa.", "Membrana.", "Pintura asfáltica.",
            "Pizarra o teja.", "Losa o carpeta a la vista.", "Chapa de metal.", "Chapa de cartón.",
            "Caña.", "Palma.","Tabla con barro.", "Paja con barro o paja sola."
    };
    private static String[] opRevestimiento = {"Revestimiento interior.", "Cielorraso."
    };
    private static String[] opAguaPotable = {"Cañería dentro de la vivienda.",
            "Fuera de la vivienda, pero dentro del terreno.",
            "Fuera de la vivienda, pero  fuera del terreno.",
    };
    private static String[] opOrigenAgua = {"Red pública (agua corriente).",
            "Perforación con bomba a motor.", "Perforación con bomba manual.", "Pozo sin bomba.",
            "Transporte por cisterna.", "Agua de lluvia.", "Río.", "Canal.",
            "Arroyo o acequia u otra procedencia.",
    };
    private static String[] opBanioUbicacion = {"Dentro de la vivienda.",
            "Fuera de la vivienda, pero dentro del terreno.", "No tiene.",
    };
    //aca va cantidad de baños que es un spinner
    private static String[] opCantBanios = {"1", "2", "3","4","5",
    };
    //
    private static String[] opBanio = {"Inodoro con botón.", "Mochila o cadena.",
            "Inodoro sin botón ni cadena (a balde) o pozo.",
    };
    private static String[] opDesague = {"Red pública.", "Cámara séptica y pozo ciego.",
            "Solo a pozo ciego o a hoyo.", "Excavación en la tierra.",
    };
    private static String[] opCocinaCombustible = {"Electricidad.", "Gas de red.",
            "Gas en tubo o a granel (zeppelin).", "Gas en garrafa.",
            "Leña o carbón u otro combustible.",
    };
    private static String[] opCantAmbientes = {"1", "2", "3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20"
    };
    private static String[] opCantAmbientesDormir = {"1", "2", "3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20"
    };
    private static String[] opConectividad = {"Internet en la vivienda.", "Celular con internet",
            "Computadora, tablet, etcétera, con internet ", "Sin internet en la vivienda."
    };

    /*private static String[] opVacia = {"vacio.",
            "vacio.",
    };*/

    //RecyclerView recyclerView;
    List<Vivienda> viviendaList;
    //ViviendaAdapter viviendaAdapter;

    String[] opciones = new String[0];
    static String[] respuestas = new String[17];

    String seleccionado;
    private int paso;


    public FragmentDatosVivienda() {
        // Required empty public constructor
    }

    public static FragmentDatosVivienda newInstance(int paso, String[] respuestas) {
        FragmentDatosVivienda fragment = new FragmentDatosVivienda();
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
        rootView = inflater.inflate(R.layout.fragment_datos_vivienda, container, false);

        Button btnContinuarVivienda = (Button) rootView.findViewById(R.id.btn_continuar_vivienda);
        Button btnVolverVivienda = (Button) rootView.findViewById(R.id.btn_volver_vivienda);
        RadioGroup rgVivienda = (RadioGroup)rootView.findViewById(R.id.radiog_vivienda);
        Spinner spinnerCantidad = (Spinner) rootView.findViewById(R.id.spinner_cantidad);
        TextView txtTitulo= (TextView) rootView.findViewById(R.id.txt_titulo_vivienda);
        TextView txtCantPreguntasVivienda= (TextView) rootView.findViewById(R.id.txt_cant_preguntas_viviendas);


        ////
        txtCantPreguntasVivienda.setText("Pregunta sobre la Vivienda "+paso+" de 16");

        Boolean radiobuttom = true;

        switch (paso){
            case 1: opciones=opTipoVivienda;
                txtTitulo.setText("Seleccione el Tipo de vivienda.");
            break;
            case 2: opciones=opSituacion;
                txtTitulo.setText("Situacion de la vivienda");
            break;
            case 3: opciones=opDocumentacion;
                txtTitulo.setText("Documentación de la vivienda.");
                break;
            case 4: opciones=opMaterialPisos;
                txtTitulo.setText("Material del Piso.");
                break;
            case 5: opciones=opMaterialTecho;
                txtTitulo.setText("Material predominante de la cubierta exterior del techo.");
                break;
            case 6: opciones=opRevestimiento;
                txtTitulo.setText("¿Tiene revestimiento interior o cielorraso?");
                break;
            case 7: opciones=opAguaPotable;
                txtTitulo.setText("Servicio de agua potable.");
                break;
            case 8: opciones=opOrigenAgua;
                txtTitulo.setText("Origen del agua que usa este hogar para beber y cocinar.");
                break;
            case 9: opciones=opBanioUbicacion;
                txtTitulo.setText("Ubicacion del Baño o letrina.");
                break;
            case 10: opciones=opCantBanios;
                txtTitulo.setText("¿Cuántos baños tiene este hogar?");
                radiobuttom = false;
                break;
            case 11: opciones=opBanio;
                txtTitulo.setText("El baño cuenta con:");
                break;
            case 12: opciones=opDesague;
                txtTitulo.setText("¿Cómo es el desagüe del inodoro?");
                break;
            case 13: opciones=opCocinaCombustible;
                txtTitulo.setText("¿Qué utiliza para cocinar?");
                break;
            case 14: opciones=opCantAmbientes;
                txtTitulo.setText("¿Cuántos ambientes, habitaciones o piezas tiene en total, sin contar baños ni cocina?");
                radiobuttom = false;
                break;
            case 15: opciones=opCantAmbientesDormir;
                txtTitulo.setText("¿Cuántos ambientes tiene para dormir, independientemente de si los usa para tal fin?.");
                radiobuttom = false;
                break;
            case 16: opciones=opConectividad;
                txtTitulo.setText("¿Qué conectividad tiene el hogar?");
                break;

            default:;
        }

        if(radiobuttom==false){ //si radio radiobuttom es false signific a que la pregunta no tiene opcioines de seleccion
            spinnerCantidad.setVisibility(View.VISIBLE);
            rgVivienda.setVisibility(View.GONE);
            spinnerCantidad.setAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item, opciones));
        }else {
            for (String opcion : opciones) {
                RadioButton nuevoRadio = crearRadioButton(opcion);
                rgVivienda.addView(nuevoRadio);
            }
        }


        //// escucha en el radiogroup
        rgVivienda.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioSeleccionado;
                for (int i =0; i < opciones.length; i++){
                    radioSeleccionado= (RadioButton) rgVivienda.getChildAt(i);
                    if((radioSeleccionado.getId())==checkedId){
                        seleccionado = opciones[i];
                        //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ opciones[i],Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //// spinner

        spinnerCantidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cantidad = (String) spinnerCantidad.getSelectedItem();
                seleccionado = cantidad;
                //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ cantidad,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No seleccionaron nada
            }
        });

       ////// botones continuar y volver
        btnContinuarVivienda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Seleccionaste la opcion: "+ seleccionado,Toast.LENGTH_SHORT).show();
                switch (paso){
                    case 1: respuestas[1] = seleccionado;
                        break;
                    case 2: respuestas[14] = seleccionado;
                        break;
                    case 3: respuestas[15] = seleccionado;
                        break;
                    case 4: respuestas[2] = seleccionado;
                        break;
                    case 5: respuestas[3] = seleccionado;
                        break;
                    case 6: respuestas[4] = seleccionado;
                        break;
                    case 7: respuestas[5] = seleccionado;
                        break;
                    case 8: respuestas[6] = seleccionado;
                        break;
                    case 9: respuestas[7] = seleccionado;
                        break;
                    case 10: respuestas[8] = seleccionado;
                        break;
                    case 11: respuestas[9] = seleccionado;
                        break;
                    case 12: respuestas[10] = seleccionado;
                        break;
                    case 13: respuestas[11] = seleccionado;
                        break;
                    case 14: respuestas[12] = seleccionado;
                        break;
                    case 15: respuestas[13] = seleccionado;
                        break;
                    case 16: respuestas[16] = seleccionado;
                        break;
                    default:respuestas[0] = "0";
                }

               // Toast.makeText(getContext(),vivienda.tipo ,Toast.LENGTH_SHORT).show();
                if(paso<16){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosVivienda.newInstance(paso+1,respuestas)).commit();
                }else {
                    respuestas[0] = "0";
                    Vivienda vivienda = new Vivienda(respuestas[0],respuestas[1],respuestas[2],
                            respuestas[3],respuestas[4],respuestas[5], respuestas[6],respuestas[7],
                            Integer.parseInt(respuestas[8]),respuestas[9],respuestas[10],
                            respuestas[11],Integer.parseInt(respuestas[12]),
                            Integer.parseInt(respuestas[13]),respuestas[14],respuestas[15],respuestas[16]);

                    viviendaList = new ArrayList<>();
                    viviendaList.add(vivienda);

                    stepView.go(1, true); // esta instruccion pasa al siguiente paso
                    stepView.done(true); //marcado como hecho
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos, FragmentAgregarPersona.newInstance()).commit();
                }
            }
        });
        btnVolverVivienda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Volver",Toast.LENGTH_SHORT).show();
                if (paso>1){
                    getActivity().getSupportFragmentManager().beginTransaction().replace
                            (R.id.fragment_container_view_ingresar_datos,FragmentDatosVivienda.newInstance(paso-1,respuestas)).commit();
                } else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,FragmentInicio.newInstance()).commit();
                }
                //stepView.done(false); //marcado como no hecho
            }
        });
        //////

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
//radio button
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




}