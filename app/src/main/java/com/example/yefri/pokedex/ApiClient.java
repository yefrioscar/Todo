package com.example.yefri.pokedex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yefri on 07/07/2017.
 */

public class ApiClient {

    private static IApiClient apiClient;

    public IApiClient getApiClient(){



        if(apiClient == null) {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiClient = retrofit.create(IApiClient.class);
        }

        return apiClient;
    }
}
