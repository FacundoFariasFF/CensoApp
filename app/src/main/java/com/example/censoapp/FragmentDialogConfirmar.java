package com.example.censoapp;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentDialogConfirmar extends androidx.fragment.app.DialogFragment {
    public FragmentDialogConfirmar(){

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("TITULO");

            View dialog = getLayoutInflater().inflate(R.layout.fragment_dialog_confirmar, null);
            builder.setView(dialog);



        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuestas.confirmar(FragmentDialogConfirmar.this);
            }
        });
        builder.setNegativeButton("Modificar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                respuestas.modificar(FragmentDialogConfirmar.this);

            }
        });
        return builder.create();
    }

    public interface Respuestas{
        public void confirmar(FragmentDialogConfirmar dialog);
        public void modificar(FragmentDialogConfirmar dialog);

    }

    private Respuestas respuestas;

    public void ProcesarRespuesta(Respuestas r){

        respuestas = r;
    }



}
