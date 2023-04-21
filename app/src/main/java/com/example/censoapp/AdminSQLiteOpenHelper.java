package com.example.censoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;


//esta class administra la db
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private static AdminSQLiteOpenHelper instance;
    AdminSQLiteOpenHelper admin;
    SQLiteDatabase BaseDeDatos;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        //creamos una tabla llamada persona con columnas (nroDni,nombre , apellido, sexo,fechaNacimiento,relacionReferencia,
        // genero,discapacidad, cursa,nivel ,gradoAnioActual,nivelMayor, completoNievelMayor, cantAprobados,nacimientoPais,
        // nacimientoProvincia, nacimientoLocalidad,viviaHaceCincoAnios,haceCincoAniosNacimientoPais,haceCincoAniosNacimientoProvincia,
        // haceCincoAniosNacimientoLocalidad, coberturaSalud,cobraJubOPen, queCobra,indigena, puebloIndigina,
        // hablaLenguaIndigena, afrodescendiente,semPasadTrabajo,semPasadChanga, semPasadFalto, cuatroSemBusco,
        // tieneTrab, estadoTrabajo, trabajoDescJubi, trabajoAportJubi, actividadTrabajo, detalleTrabajo,
        // hijosNacidos, hijosVivos,fechaNacUltimoHijo)
        BaseDeDatos.execSQL("create table persona(nroDni integer primary key, nombre text, apellido text, " +
                "sexo text,fechaNacimiento text,relacionReferencia text,genero text,discapacidad text,cursa text," +
                "nivel text,gradoAnioActual text,nivelMayor text,completoNievelMayor text,cantAprobados text," +
                "nacimientoPais text,nacimientoProvincia text,nacimientoLocalidad text,viviaHaceCincoAnios text," +
                "haceCincoAniosNacimientoPais text,haceCincoAniosNacimientoProvincia text," +
                "haceCincoAniosNacimientoLocalidad text,coberturaSalud text,cobraJubOPen text,queCobra text," +
                "indigena text,puebloIndigina text,hablaLenguaIndigena text,afrodescendiente text," +
                "semPasadTrabajo text,semPasadChanga text,semPasadFalto text,cuatroSemBusco text,tieneTrab text," +
                "estadoTrabajo text,trabajoDescJubi text,trabajoAportJubi text,actividadTrabajo text,detalleTrabajo text," +
                "hijosNacidos integer,hijosVivos integer,fechaNacUltimoHijo text)");

        //creamos una tabla llamada vivienda con las columnas(codigo, tipo, materialPisos, materialTecho,
        //revestimiento, aguaPotable, origenAgua, banioUbicacion, cantBanios, banio, desague, cocinaCombustible,
        //cantAmbientes, cantAmbientesDormir, situacion, documentacion, conectividad)
        BaseDeDatos.execSQL("create table vivienda(codigo text primary key, tipo text, materialPisos text" +
                ", materialTecho text, revestimiento text, aguaPotable text, origenAgua text" +
                ", banioUbicacion text, cantBanios integer, banio text, desague text, cocinaCombustible text" +
                ", cantAmbientes integer, cantAmbientesDormir integer, situacion text, documentacion text" +
                ", conectividad text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  " + "persona");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  " + "vivienda");
        onCreate(sqLiteDatabase);
    }

    //este metodo regresa una instancia unica del objeto
    public static AdminSQLiteOpenHelper getInstance(Context context) {
        //si instance es null significa que aun no se creo una instacia de este objeto, y debemos crearla
        if (instance == null) {
            instance = new AdminSQLiteOpenHelper(context.getApplicationContext(), "dbcenso.db", null, 1);
        }
        return instance;
    }

    public void open() {
        admin = AdminSQLiteOpenHelper.instance;
        BaseDeDatos = admin.getWritableDatabase();
    }

    public void close() {

        BaseDeDatos.close();
    }

    public void RegistrarVivienda(List<Vivienda> viviendas) {
        open();
        for (int j=0; j<viviendas.size();j++) {
            ContentValues registro = new ContentValues();
            // registramos en la db los campos
            registro.put("codigo", viviendas.get(j).getCodigo());
            registro.put("tipo", viviendas.get(j).getTipo());
            registro.put("materialPisos", viviendas.get(j).getMaterialPisos());
            registro.put("materialTecho", viviendas.get(j).getMaterialTecho());
            registro.put("revestimiento", viviendas.get(j).getRevestimiento());
            registro.put("aguaPotable", viviendas.get(j).getAguaPotable());
            registro.put("origenAgua", viviendas.get(j).getOrigenAgua());
            registro.put("banioUbicacion", viviendas.get(j).getBanioUbicacion());
            registro.put("cantBanios", viviendas.get(j).getCantBanios());
            registro.put("banio", viviendas.get(j).getBanio());
            registro.put("desague", viviendas.get(j).getDesague());
            registro.put("cocinaCombustible", viviendas.get(j).getCocinaCombustible());
            registro.put("cantAmbientes", viviendas.get(j).getCantAmbientes());
            registro.put("cantAmbientesDormir", viviendas.get(j).getCantAmbientesDormir());
            registro.put("situacion", viviendas.get(j).getSituacion());
            registro.put("documentacion", viviendas.get(j).getDocumentacion());
            registro.put("conectividad", viviendas.get(j).getConectividad());
            // los insertamos en la "tabla" "vivienda"
            BaseDeDatos.insert("vivienda", null, registro);
        }
        close();
    }
    public void RegistrarPersona(List<Persona> personas) {
        open();
        for (int j=0; j<personas.size();j++) {
            ContentValues registro = new ContentValues();
            // registramos en la db los campos
            registro.put("nroDni", personas.get(j).getNroDni());
            registro.put("nombre", personas.get(j).getNombre());
            registro.put("apellido", personas.get(j).getApellido());
            registro.put("sexo", personas.get(j).getSexo());
            registro.put("fechaNacimiento", String.valueOf(personas.get(j).getFechaNacimiento()));
            registro.put("relacionReferencia", personas.get(j).getRelacionReferencia());
            registro.put("genero", personas.get(j).getGenero());
            registro.put("discapacidad", personas.get(j).getDiscapacidad());
            registro.put("cursa", personas.get(j).getCursa());
            registro.put("nivel", personas.get(j).getNivel());
            registro.put("gradoAnioActual", personas.get(j).getGradoAnioActual());
            registro.put("nivelMayor", personas.get(j).getNivelMayor());
            registro.put("completoNievelMayor", personas.get(j).getCompletoNievelMayor());
            registro.put("cantAprobados", personas.get(j).getCantAprobados());
            registro.put("nacimientoPais", personas.get(j).getNacimientoPais());
            registro.put("nacimientoProvincia", personas.get(j).getNacimientoProvincia());
            registro.put("nacimientoLocalidad", personas.get(j).getNacimientoLocalidad());
            registro.put("viviaHaceCincoAnios", personas.get(j).getViviaHaceCincoAnios());
            registro.put("haceCincoAniosNacimientoPais", personas.get(j).getHaceCincoAniosNacimientoPais());
            registro.put("haceCincoAniosNacimientoProvincia", personas.get(j).getHaceCincoAniosNacimientoProvincia());
            registro.put("haceCincoAniosNacimientoLocalidad", personas.get(j).getHaceCincoAniosNacimientoLocalidad());
            registro.put("coberturaSalud", personas.get(j).getCoberturaSalud());
            registro.put("cobraJubOPen", personas.get(j).getCobraJubOPen());
            registro.put("queCobra", personas.get(j).getQueCobra());
            registro.put("indigena", personas.get(j).getIndigena());
            registro.put("puebloIndigina", personas.get(j).getPuebloIndigina());
            registro.put("hablaLenguaIndigena", personas.get(j).getHablaLenguaIndigena());
            registro.put("afrodescendiente", personas.get(j).getAfrodescendiente());
            registro.put("semPasadTrabajo", personas.get(j).getSemPasadTrabajo());
            registro.put("semPasadChanga", personas.get(j).getSemPasadChanga());
            registro.put("semPasadFalto", personas.get(j).getSemPasadFalto());
            registro.put("cuatroSemBusco", personas.get(j).getCuatroSemBusco());
            registro.put("tieneTrab", personas.get(j).getTieneTrab());
            registro.put("estadoTrabajo", personas.get(j).getEstadoTrabajo());
            registro.put("trabajoDescJubi", personas.get(j).getTrabajoDescJubi());
            registro.put("trabajoAportJubi", personas.get(j).getTrabajoAportJubi());
            registro.put("actividadTrabajo", personas.get(j).getActividadTrabajo());
            registro.put("detalleTrabajo", personas.get(j).getDetalleTrabajo());
            registro.put("hijosNacidos", personas.get(j).getHijosNacidos());
            registro.put("hijosVivos", personas.get(j).getHijosVivos());
            registro.put("fechaNacUltimoHijo", String.valueOf(personas.get(j).getFechaNacUltimoHijo()));

            // los insertamos en la "tabla" "persona"
            BaseDeDatos.insert("persona", null, registro);
        }
        close();
    }
   /* public ArrayList<DolarHistorico> Buscar() {
        LocalDate dateFecha,dateFechaDB;
        String fecha;
        String compra;
        String venta;

        ArrayList<DolarHistorico> historialCotizaciones = new ArrayList();

        open();

        Cursor fila = BaseDeDatos.rawQuery("SELECT fecha, compra, venta FROM historico", null);
        //Cursor fila = BaseDeDatos.rawQuery("SELECT compra, venta FROM historico WHERE fecha='" + db_fecha_cal + "'", null);
        DolarHistorico dolar;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (fila.moveToFirst()) { //retorna true si encuentra datos dentro de la "tabla" y los muestra en pantalla
            dateFechaDB = LocalDate.parse((fila.getString(0)), formatter);
            do {
                //if (dateFechaDB.equals(datefechaSelec)) {
                fecha = (fila.getString(0));
                dateFecha = LocalDate.parse(fecha, formatter);
                compra = (fila.getString(1));
                venta = (fila.getString(2));

                dolar = new DolarHistorico(dateFecha,compra,venta);
                historialCotizaciones.add(dolar);
                //}
            } while (fila.moveToNext());
        }
        close();
        return historialCotizaciones;
    }*/


    //metodo para elimiar
    public void EliminarVivienda() {
        open();
        BaseDeDatos.delete("vivienda", null, null);
        close();
    }
    public void EliminarPersona() {
        open();
        BaseDeDatos.delete("persona", null, null);
        close();
    }

}
