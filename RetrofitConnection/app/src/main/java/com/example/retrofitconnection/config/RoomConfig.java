package com.example.retrofitconnection.config;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.retrofitconnection.model.Departamento;
import com.example.retrofitconnection.model.Professor;
import com.example.retrofitconnection.Dao.ProfessorDAO;


@Database(entities = {Professor.class, Departamento.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class RoomConfig extends RoomDatabase {

    private static RoomConfig instance = null;

    public abstract ProfessorDAO professorDAO();

    public static RoomConfig getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    RoomConfig.class,
                    "databaseName")
                    .allowMainThreadQueries() // Permite que o room rode na main principal
                    .fallbackToDestructiveMigration()  // recreate the database if necessary
                    .build();
        }
        return instance;
    }
}