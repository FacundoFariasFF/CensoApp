package com.example.censoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PersonaAgregadaAdapter extends RecyclerView.Adapter<PersonaAgregadaAdapter.ViewHolder>{

    Context context;
    List<PersonaAgregada> personaAgregadaList;



    public PersonaAgregadaAdapter(Context context, List<PersonaAgregada>personaAgregadaList){
        setHasStableIds(true);
        this.context = context;
        this.personaAgregadaList = personaAgregadaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona_agregada,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonaAgregada personaAgregada = personaAgregadaList.get(position);

        holder.nombre.setText("Nombre: " +personaAgregada.getNombre());
        holder.apellido.setText("Apellido: " +personaAgregada.getApellido());
        holder.dni.setText("DNI: " +  personaAgregada.getNroDni());
        holder.sexo.setText("Sexo: " + personaAgregada.getSexo());
        holder.fechaNacimiento.setText("Fecha de nacimiento: " + personaAgregada.getFechaNacimiento());


    }

    @Override
    public int getItemCount() {
        return personaAgregadaList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,apellido,dni,sexo,fechaNacimiento;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt_nombre_persona_agregada);
            apellido = itemView.findViewById(R.id.txt_apellido_persona_agregada);
            dni = itemView.findViewById(R.id.txt_dni_persona_agregada);
            sexo = itemView.findViewById(R.id.txt_sexo_persona_agregada);
            fechaNacimiento = itemView.findViewById(R.id.txt_fech_nac_persona_agregada);
            cardView = itemView.findViewById(R.id.cardview_persona_agregada);
        }
    }

}
