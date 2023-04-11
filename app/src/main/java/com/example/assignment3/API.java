package com.example.assignment3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("all")
    Call<Model> getData();
}
