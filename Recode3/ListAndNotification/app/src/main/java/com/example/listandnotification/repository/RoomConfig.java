package com.example.listandnotification.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.listandnotification.dao.CourseDAO;
import com.example.listandnotification.model.Curso;
import com.example.listandnotification.model.Professor;

@Database(entities = {Curso.class}, version = 1)
public abstract class RoomConfig extends RoomDatabase {

    private static RoomConfig instance = null;

    public abstract CourseDAO cursoDao();

    public static  RoomConfig getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, RoomConfig.class, "NameDataBase")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}
