package com.example.retrofitconnection.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitconnection.R;
import com.example.retrofitconnection.adapter.AllocationAdapter;
import com.example.retrofitconnection.config.RetrofitConfig;
import com.example.retrofitconnection.model.Allocation;
import com.example.retrofitconnection.repository.ResultEventInterface;
import com.example.retrofitconnection.service.AllocationService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation);

        recyclerView = findViewById(R.id.rv_allocation);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requetGetAllAllocation(new ResultEventInterface() {
            @Override
            public <T> void onResult(T result) {
                List<Allocation> allocations = (List<Allocation>) result;

                AllocationAdapter adapter = new AllocationAdapter(AllocationActivity.this, allocations);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message) {
                Toast.makeText(AllocationActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void requetGetAllAllocation(final ResultEventInterface resultInterface) {

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Allocation>> call = retrofitConfig.getAllocationService().getAllAllocations();
        call.enqueue(new Callback<List<Allocation>>() {
            @Override
            public void onResponse(Call<List<Allocation>> call, Response<List<Allocation>> response) {
                List<Allocation> list = response.body();
                resultInterface.onResult(list);
            }

            @Override
            public void onFailure(Call<List<Allocation>> call, Throwable t) {
                resultInterface.onFail("Falha na requisição!!!!!!!!!!!!!!!");
            }
        });
    }
}