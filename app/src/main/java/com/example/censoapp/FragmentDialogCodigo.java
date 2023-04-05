package com.example.censoapp;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentDialogCodigo extends androidx.fragment.app.DialogFragment {
    public FragmentDialogCodigo(){

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Codigo unico de la vivienda:");

            View dialog = getLayoutInflater().inflate(R.layout.fragment_dialog_codigo, null);
            builder.setView(dialog);



        builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuestas.continuar(FragmentDialogCodigo.this);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                respuestas.cancelar(FragmentDialogCodigo.this);

            }
        });
        return builder.create();
    }

    public interface Respuestas{
        public void continuar(FragmentDialogCodigo dialog);
        public void cancelar(FragmentDialogCodigo dialog);

    }

    private Respuestas respuestas;

    public void ProcesarRespuesta(Respuestas r){

        respuestas = r;
    }



}
