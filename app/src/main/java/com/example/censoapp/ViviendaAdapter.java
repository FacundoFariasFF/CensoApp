package com.example.censoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ViviendaAdapter extends RecyclerView.Adapter<ViviendaAdapter.ViewHolder>{

    Context context;
    List<Vivienda> viviendaList;

    private static String[] opcionesTipoCasa = {"casa", "departamento", "carpa", "barril","casilla rodante"};

    public ViviendaAdapter(Context context, List<Vivienda>viviendaList){
        setHasStableIds(true);
        this.context = context;
        this.viviendaList = viviendaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vivienda,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vivienda vivienda = viviendaList.get(position);

        holder.titulo.setText("Selecciona el tipo de vivienda: ");


        for(String tipoCasa : opcionesTipoCasa) {
            RadioButton nuevoRadio = crearRadioButtonTipoVivienda(tipoCasa);
            holder.rgTipoCasa.addView(nuevoRadio);
        }


    }

    @Override
    public int getItemCount() {
        return viviendaList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        //TextView nombre,compra,venta,fecha;
        TextView titulo;
        CardView cardView;

        RadioGroup rgTipoCasa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txt_vivienda);

            cardView = itemView.findViewById(R.id.cardview_vivienda);

            rgTipoCasa = (RadioGroup)itemView.findViewById(R.id.radiog_vivienda);
        }
    }

    private RadioButton crearRadioButtonTipoVivienda(String tipoCasa) {
        RadioButton nuevoRadio = new RadioButton(context.getApplicationContext());
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(tipoCasa);
        nuevoRadio.setTag(tipoCasa);
        return nuevoRadio;
    }

}
