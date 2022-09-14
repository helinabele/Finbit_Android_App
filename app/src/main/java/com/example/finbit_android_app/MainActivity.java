package com.example.finbit_android_app;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import Models.Employee;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onStart() {

        super.onStart();

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bikerental.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<Response> call = retrofitAPI.getEmployees();

        call.enqueue(new Callback<Response>() {

            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    // after extracting all the data we are setting that data to all our views.
                    Response model = response.body();

                    EmployeeAdapter adapter = new EmployeeAdapter(model.getData());

                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                // displaying an error message in toast
                Toast.makeText(MainActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }



        });
    }
}