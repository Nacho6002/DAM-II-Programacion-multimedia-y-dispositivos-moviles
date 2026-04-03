package com.example.proyectoopenweatherapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Esta es la tabla donde guardo las ciudades que voy añadiendo
// Pilas que el nombre tiene que ser unico para no repetir
@Entity(tableName = "tabla_ciudades")
public class Ciudad {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String temperatura;
    public String descripcion; // Ej: "Cielo claro"
    public String iconoUrl; // La url del icono o gif

    // Constructor vacio por si acaso Room se queja
    public Ciudad() {
    }

    // Constructor pa usar yo rapido
    public Ciudad(String nombre, String temperatura, String descripcion, String iconoUrl) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.iconoUrl = iconoUrl;
    }
}

