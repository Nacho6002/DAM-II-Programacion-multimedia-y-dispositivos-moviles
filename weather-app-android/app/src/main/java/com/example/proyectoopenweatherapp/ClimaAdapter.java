package com.example.proyectoopenweatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ClimaHolder> {

    private List<Ciudad> ciudades = new ArrayList<>();

    @NonNull
    @Override
    public ClimaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // aqui reciclo el mismo diseño de lista del deber anterior
        // para mantener el estilo de la app
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ciudad, parent, false);
        return new ClimaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaHolder holder, int position) {
        Ciudad actual = ciudades.get(position);

        holder.tvCiudad.setText(actual.nombre);
        holder.tvTemp.setText(actual.temperatura);
        holder.tvDesc.setText(actual.descripcion);

        // profe vi en un tutorial por ahi que se ponen estas lineas
        // del placeholder y error para que no quede feo si falla,
        // asi que copie y pegue y le puse mi icono de nieve porque no tenia otro del proyecto anterior
        //
        Glide.with(holder.itemView.getContext())
                .load(actual.iconoUrl)
                .placeholder(R.drawable.ic_icono_clima)
                .error(R.drawable.ic_icono_clima)
                .into(holder.imgClima);
    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
        notifyDataSetChanged();
    }

    class ClimaHolder extends RecyclerView.ViewHolder {
        TextView tvCiudad, tvTemp, tvDesc;
        ImageView imgClima;

        public ClimaHolder(@NonNull View itemView) {
            super(itemView);
            tvCiudad = itemView.findViewById(R.id.tvCiudadLista);
            tvTemp = itemView.findViewById(R.id.tvTempLista);
            tvDesc = itemView.findViewById(R.id.tvDescLista);
            imgClima = itemView.findViewById(R.id.imgIconoLista);
        }
    }
}