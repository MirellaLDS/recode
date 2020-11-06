package com.example.retrofitconnection.repository;

public interface ResultEventInterface {
    <T> void onResult(T result);
    void onFail(String message);
}
