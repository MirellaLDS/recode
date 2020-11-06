package com.example.retrofitconnection.service;

import com.example.retrofitconnection.model.Allocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllocationService {

    @GET("allocation")
    Call<List<Allocation>> getAllAllocations();

}
