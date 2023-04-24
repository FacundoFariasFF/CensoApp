package com.example.censoapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDate;
import java.util.Calendar;

public class FragmentDialogCalendario extends DialogFragment {
    LocalDate fechaSeleccionada;
    public FragmentDialogCalendario(){
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int dayOfMonth = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Light_Dialog_NoActionBar, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                fechaSeleccionada = LocalDate.of(year,(month + 1),dayOfMonth);
                respuestasCalendario.ConfirmarCalendario(FragmentDialogCalendario.this, fechaSeleccionada);
            }
        },year,month,dayOfMonth);

        //calendario.set(2023, 2, 1);//Year,Mounth -1,Day
        calendario.set(1900, 2, 1);//Year,Mounth -1,Day
        dialog.getDatePicker().setMinDate(calendario.getTimeInMillis());
        calendario.set(year,month,dayOfMonth);
        dialog.getDatePicker().setMaxDate(calendario.getTimeInMillis());

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        return dialog;
    }

    public interface RespuestasCalendario{
        public void ConfirmarCalendario(DialogFragment dialogCalendario, LocalDate fechaseleccionada);
        public void CancelarCalendario(DialogFragment dialogCalendario);
    }
    private RespuestasCalendario respuestasCalendario;

    public void ProcesarRespuestaCalendario(RespuestasCalendario r){
        respuestasCalendario=r;
    }

}
