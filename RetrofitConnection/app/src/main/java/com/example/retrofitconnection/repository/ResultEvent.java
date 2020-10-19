package com.example.retrofitconnection.repository;

import com.example.retrofitconnection.model.Professor;

import java.util.List;

public interface ResultEvent {
    void onResult(String[] professors);
    void onFail(String message);
}
