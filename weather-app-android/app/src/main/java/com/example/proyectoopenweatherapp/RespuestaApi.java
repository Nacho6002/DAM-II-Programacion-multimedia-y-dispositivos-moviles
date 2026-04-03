package com.example.proyectoopenweatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

// Clases auxiliares para que GSON convierta el JSON de la web a objetos Java sin hacerme bolas
public class RespuestaApi {

    @SerializedName("name")
    public String nombreCiudad;

    @SerializedName("main")
    public MainData main;

    @SerializedName("weather")
    public List<Weather> weather;

    // Clase interna pa sacar la temperatura
    public class MainData {
        @SerializedName("temp")
        public float temp;
    }

    // Clase interna pa la descripción y el nombre del icono
    public class Weather {
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
    }
}