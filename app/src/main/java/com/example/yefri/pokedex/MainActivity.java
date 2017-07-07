package com.example.yefri.pokedex;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    final ApiClient apiClient = new ApiClient();
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.search);
        listTodo();




        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText.getText().toString().equals("")){
                    listTodo();
                }
                apiClient.getApiClient().getTodoById(editText.getText().toString()).enqueue(new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {
                        if(response.isSuccessful()) {
                            Todo ListPokemons =  response.body();
                            Log.d("todo",ListPokemons.getCompleted()+ " "+ListPokemons.getTitle());
                            ArrayList<Todo> s = new ArrayList<Todo>();
                            s.add(0,ListPokemons);
                            Adapter adapter = new Adapter(MainActivity.this,s);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable t) {

                    }
                });
            }
        });





    }

    public void listTodo(){


        apiClient.getApiClient().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                if(response.isSuccessful()){
                    ArrayList<Todo> ListPokemons =  response.body();

                    Adapter adapter = new Adapter(MainActivity.this,ListPokemons);
                    listView.setAdapter(adapter);


                    for(Todo pokemon: ListPokemons){
                        Log.d("users", pokemon.getCompleted() + " - " +pokemon.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });
    }
}
