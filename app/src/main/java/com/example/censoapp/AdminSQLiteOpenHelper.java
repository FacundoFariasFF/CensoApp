package com.example.censoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


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
        // genero,discapacidad, cursa,nivel ,gradoAnioActual,nivelMayor, completoNievelMayot, cantAprobados,nacimientoPais,
        // nacimientoProvincia, nacimientoLocalidad,viviaHaceCincoAnios,haceCincoAniosNacimientoPais,haceCincoAniosNacimientoProvincia,
        // haceCincoAniosNacimientoLocalidad, coberturaSalud,cobraJubOPen, queCobra,indigena, puebloIndigina,
        // hablaLenguaIndigena, afrodescendiente,semPasadTrabajo,semPasadChanga, semPasadFalto, cuatroSemBusco,
        // tieneTrab, hijosNacidos, hijosVivos,fechaNacUltimoHijo)
        BaseDeDatos.execSQL("create table persona(nroDni integer primary key, nombre text, apellido text, sexo text,fechaNacimiento text,relacionReferencia text,genero text," +
                "discapacidad text,cursa text,nivel text,gradoAnioActual text,nivelMayor text,completoNievelMayot text,cantAprobados text,nacimientoPais text," +
                "nacimientoProvincia text,nacimientoLocalidad text,viviaHaceCincoAnios text,haceCincoAniosNacimientoPais text,haceCincoAniosNacimientoProvincia text," +
                "haceCincoAniosNacimientoLocalidad text,coberturaSalud text,cobraJubOPen text,queCobra text,indigena text,puebloIndigina text,hablaLenguaIndigena text," +
                "afrodescendiente text,semPasadTrabajo text,semPasadChanga text,semPasadFalto text,cuatroSemBusco text,tieneTrab text,hijosNacidos integer,hijosVivos integer,fechaNacUltimoHijo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  " + "persona");
        onCreate(sqLiteDatabase);
    }

    //este metodo regresa una instancia unica del objeto
    public static AdminSQLiteOpenHelper getInstance(Context context) {
        //si instance es null significa que aun no se creo una instacia de este objeto, y debemos crearla
        if (instance == null) {
            instance = new AdminSQLiteOpenHelper(context.getApplicationContext(), "dbpersona.db", null, 1);
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

    /*public void RegistrarPersona(ArrayList<DolarHistorico> cotizaciones) {
        open();
        for (int j=0; j<cotizaciones.size();j++) {
            ContentValues registro = new ContentValues();
            // registramos en la db los campos fecha,compra y venta
            registro.put("fecha", String.valueOf(cotizaciones.get(j).getDolarFecha()));
            registro.put("compra", cotizaciones.get(j).getDolarCompra());
            registro.put("venta", cotizaciones.get(j).getDolarVenta());
            // los insertamos en la "tabla"
            BaseDeDatos.insert("historico", null, registro);
        }
        close();
    }*/
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
    public void Eliminar() {
        open();
        BaseDeDatos.delete("historico", null, null);
        close();
    }

}
