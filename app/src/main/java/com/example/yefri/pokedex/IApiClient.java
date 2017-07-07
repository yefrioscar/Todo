package com.example.yefri.pokedex;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yefri on 07/07/2017.
 */

public interface IApiClient {

    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("todos/{id}")
    Call<Todo> getTodoById(@Path("id") String id);

    @GET("todos/")
    Call<Todo> getTodoByUserId(@Query("userId") String user);

}
