package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.api.databinding.ActivityMainBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String TAG= MainActivity.class.getName();
    ActivityMainBinding binding;
    List<Coffee> coffeeList=new ArrayList<>();
    CoffeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyc.setLayoutManager(layoutManager);

        AppApi.getAppService().getCoffee().enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(Call<List<Coffee>> call, Response<List<Coffee>> response) {
                Log.d(TAG, "onResponse");
                coffeeList=response.body();
                adapter=new CoffeeAdapter(coffeeList);
                binding.recyc.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Coffee>> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}