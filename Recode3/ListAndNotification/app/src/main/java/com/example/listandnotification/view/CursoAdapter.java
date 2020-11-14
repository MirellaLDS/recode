package com.example.listandnotification.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listandnotification.model.Curso;
import com.example.listandnotification.model.Professor;
import com.example.listandnotification.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CursoAdapter extends ArrayAdapter<Curso> {

    private Context context;
    private ArrayList<Curso> listaCursos;
    private int layout;


    public CursoAdapter(@NonNull Context context, int layout, ArrayList<Curso> listaCursos) {
        super(context, layout, listaCursos);

        this.context = context;
        this.listaCursos = listaCursos;
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Criar referencia de layout na memoria
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(layout, parent,false);
        }

        // Pegar item da colecao
        Curso curso = listaCursos.get(position);

        TextView tvNomeProfessor = itemView.findViewById(R.id.tv_professor_name);
        tvNomeProfessor.setText(curso.getName());

        return itemView;
    }
}
