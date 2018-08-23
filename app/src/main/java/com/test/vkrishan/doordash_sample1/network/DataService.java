package com.test.vkrishan.doordash_sample1.network;

import com.test.vkrishan.doordash_sample1.model.RestaurantList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService{

    @GET("/v2/restaurant/?lat=37.422740&lng=-122.139956&offset=0&limit=50")
    Call<List<RestaurantList>> getAllRestaurants();

}