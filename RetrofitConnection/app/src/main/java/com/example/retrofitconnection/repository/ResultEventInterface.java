package com.example.retrofitconnection.repository;

public interface ResultEventInterface {
    <T> void onResult(T professors);
    void onFail(String message);
}
