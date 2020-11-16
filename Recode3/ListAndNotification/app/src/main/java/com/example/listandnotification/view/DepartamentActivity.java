package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.listandnotification.R;
import com.example.listandnotification.model.Professor;

import java.util.ArrayList;
import java.util.Arrays;

public class DepartamentActivity extends AppCompatActivity {

    ArrayList<Professor> lista = new ArrayList(Arrays.asList(
            new Professor()
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departament);
    }
}