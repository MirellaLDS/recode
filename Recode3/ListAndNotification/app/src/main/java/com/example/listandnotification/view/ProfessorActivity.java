package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listandnotification.R;
import com.example.listandnotification.model.Professor;
import com.example.listandnotification.repository.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorActivity extends AppCompatActivity {

    private ArrayList<Professor> professorsList;
    private ArrayAdapter<Professor> adapterProf;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        Button bt = findViewById(R.id.bt_send_prof);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMissilesDialogFragment dialog = new FireMissilesDialogFragment();
                dialog.show(getSupportFragmentManager(), "missiles");
            }
        });


        ListView listView = findViewById(R.id.lv_prof);
        textView = findViewById(R.id.test);

        professorsList = new ArrayList<>();
        adapterProf = new ArrayAdapter(ProfessorActivity.this, android.R.layout.simple_list_item_1, professorsList);
        listView.setAdapter(adapterProf);

        request();
    }

    private void request() {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Professor>> getRequestCall = retrofitConfig.getProfessorService().getAllProfessors();

        getRequestCall.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> list = response.body();
                formatFields(list);
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                Toast.makeText(ProfessorActivity.this, "Sua request falhou", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void formatFields(List<Professor> list) {
        textView.setText(list.get(0).toString());
        professorsList.addAll(list);
        adapterProf.notifyDataSetChanged();
    }
}