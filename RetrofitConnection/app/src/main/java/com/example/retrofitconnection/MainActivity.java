package com.example.retrofitconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitconnection.model.Departamento;
import com.example.retrofitconnection.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] nameProfessorArray = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        nameProfessorArray = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
                "Honeycomb", "Ice Cream Sandwich", "Jelly Bean",
                "KitKat", "Lollipop", "Marshmallow", "Nougat" };

        getAllProfessors();

//        createProfessor();
    }

    private void createProfessor() {
        Departamento departamento = new Departamento(271, "");
        Professor p1 = new Professor("Rafael Duarte", "12345678910", departamento);

        Call<Professor> call = new RetrofitConfig().getProfessorService().create(p1);

        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {

                if (response.isSuccessful()) {
                    Professor professor = response.body();
                    Toast.makeText(MainActivity.this, "Sucesso ao criar o professor!!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Erro no sucesso", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha ao criar o Professsor!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllProfessors() {
        Call<List<Professor>> call = new RetrofitConfig().getProfessorService().getAllProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professoresList = response.body();

                nameProfessorArray = new String[professoresList.size()];
                for (int i = 0; i < nameProfessorArray.length; i++) {
                    nameProfessorArray[i] = professoresList.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, nameProfessorArray);
                listView.setAdapter(adapter);

//                Toast.makeText(MainActivity.this, professores.get(0).getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na requisição!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}