package com.example.firsttest.api.service;

import com.example.firsttest.api.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubClient {

    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> repos(@Path("user") String user);
}
