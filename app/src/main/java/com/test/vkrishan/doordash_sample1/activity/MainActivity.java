package com.test.vkrishan.doordash_sample1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.test.vkrishan.doordash_sample1.R;
import com.test.vkrishan.doordash_sample1.adapter.CustomAdapter;
import com.test.vkrishan.doordash_sample1.model.RestaurantList;
import com.test.vkrishan.doordash_sample1.network.DataService;
import com.test.vkrishan.doordash_sample1.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        // Retrofit client handle
        DataService service = RetrofitClient.getRetrofitInstance().create(DataService.class);

        Call<List<RestaurantList>> call = service.getAllRestaurants();
        call.enqueue(new Callback<List<RestaurantList>>() {
            @Override
            public void onResponse(Call<List<RestaurantList>> call, Response<List<RestaurantList>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RestaurantList>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Error. Please try later", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<RestaurantList> restList){
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, restList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
