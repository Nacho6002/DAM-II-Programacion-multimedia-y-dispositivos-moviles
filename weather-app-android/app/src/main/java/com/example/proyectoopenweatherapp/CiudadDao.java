package com.example.proyectoopenweatherapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

// Aquí están las consultas, tipo SQL pero en Java
@Dao
public interface CiudadDao {

    // Traeme todas las ciudades pa mostrar en el Recycler
    // Uso LiveData para que se actualice solito si cambio algo
    @Query("SELECT * FROM tabla_ciudades ORDER BY id DESC")
    LiveData<List<Ciudad>> obtenerTodas();

    // Guardar una ciudad nueva de una
    @Insert
    void insertar(Ciudad ciudad);
}

