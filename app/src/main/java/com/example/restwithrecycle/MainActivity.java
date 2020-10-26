package com.example.restwithrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleID);
        getImage();
    }

    private void getImage() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<imageList>> call =api.getImage();
        call.enqueue(new Callback<List<imageList>>() {
            @Override
            public void onResponse(Call<List<imageList>> call, Response<List<imageList>> response) {
                List<imageList> imgList =response.body();
                recycleAdapter recycleAdapter = new recycleAdapter(imgList,MainActivity.this);
                recyclerView.setAdapter(recycleAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<imageList>> call, Throwable t) {

            }
        });
    }
}
