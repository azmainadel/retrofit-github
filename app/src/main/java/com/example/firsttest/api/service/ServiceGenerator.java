package com.example.firsttest.api.service;

import com.example.firsttest.api.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();


    public static <S> S createService(Class<S> serviceClass){

        return retrofit.create(serviceClass);
    }

}
