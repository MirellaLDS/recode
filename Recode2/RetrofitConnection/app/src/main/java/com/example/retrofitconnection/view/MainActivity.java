package com.example.retrofitconnection.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitconnection.R;
import com.example.retrofitconnection.adapter.ProfessorAdapter;
import com.example.retrofitconnection.config.RetrofitConfig;
import com.example.retrofitconnection.config.RoomConfig;
import com.example.retrofitconnection.model.Departamento;
import com.example.retrofitconnection.model.Professor;
import com.example.retrofitconnection.repository.ResultEventInterface;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private ProfessorAdapter professorAdapter;
    private ArrayAdapter adapter;
    private RoomConfig dbInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        dbInstance = RoomConfig.getInstance(this);

//        recyclerView = findViewById(R.id.recyclerView);
//        professorAdapter = new ProfessorAdapter(this, new ArrayList<Professor>());

        final ListView listView = findViewById(R.id.listView);


//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        Caso vc queira um Grid user o GridLayoutManager
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setAdapter(professorAdapter);

                createProfessor();

        getAllProfessors(new ResultEventInterface() {

            @Override
            public <T> void onResult(T result) {
//                List<Professor> teacher = (List<Professor>) professors;

                  List<Professor> pList = dbInstance.professorDAO().getAll();

//                professorAdapter = new ProfessorAdapter(MainActivity.this, pList);
                adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, pList);
                listView.setAdapter(adapter);
//                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFail(String message) {
                // Quando houver falha, Exiba uma mensagem de erro!
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void createSpnnerData() {
//        adapter = new SpinAdapter(Main.this,
//                android.R.layout.simple_spinner_item,
//                users);
//        mySpinner = (Spinner) findViewById(R.id.miSpinner);
//        mySpinner.setAdapter(adapter); // Set the custom adapter to the spinner
//        // You can create an anonymous listener to handle the event when is selected an spinner item
//        mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view,
//                                       int position, long id) {
//                // Here you get the current item (a User object) that is selected by its position
//                User user = adapter.getItem(position);
//                // Here you can do the action you want to...
//                Toast.makeText(Main.this, "ID: " + user.getId() + "\nName: " + user.getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapter) {  }
//        });
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

    private void getAllProfessors(final ResultEventInterface resultEventInterface) {
        Call<List<Professor>> call = new RetrofitConfig().getProfessorService().getAllProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professoresList = response.body();

                dbInstance.professorDAO().insertALl(professoresList);

                resultEventInterface.onResult(professoresList);

            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {

                resultEventInterface.onFail("Falha na requisição!!!");
            }
        });
    }
}