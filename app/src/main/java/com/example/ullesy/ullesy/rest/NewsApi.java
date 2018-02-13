package com.example.ullesy.ullesy.rest;

import com.example.ullesy.ullesy.core.ApiResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kailash on 15/2/18.
 */

public interface NewsApi {

    @GET("news/everyday/{key}")
    Call<ApiResponse> getDailyNews(@Path("key") String key, @Query("date") String date);

    @GET("users/{user}/repos")
    Call<List<Map<String,Object>>> listRepos(@Path("user") String user);
}
