package com.example.proyectoopenweatherapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Configuración de Room
@Database(entities = {Ciudad.class}, version = 1, exportSchema = false)
public abstract class BaseDatosClima extends RoomDatabase {

    public abstract CiudadDao ciudadDao();

    private static volatile BaseDatosClima INSTANCIA;

    // Hilo fijo de 4 para escribir en la BD, asi no se traba la app
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static BaseDatosClima getDatabase(final Context context) {
        if (INSTANCIA == null) {
            synchronized (BaseDatosClima.class) {
                if (INSTANCIA == null) {
                    // Creo la base de datos
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                                    BaseDatosClima.class, "clima_db")
                            .addCallback(sRoomDatabaseCallback) // <--- ESTO LLAMA A LOS DATOS POR DEFECTO
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    // Callback para meter datos cuando se crea la base por primera vez
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Lanzo un hilo y meto datos quemados pa que no salga vacio
            databaseWriteExecutor.execute(() -> {
                CiudadDao dao = INSTANCIA.ciudadDao();
            });
        }
    };
}