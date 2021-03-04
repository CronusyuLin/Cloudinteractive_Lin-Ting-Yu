package com.example.cloudinteractive.Network;

import com.example.cloudinteractive.Second.Bean.SecondBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<SecondBean>> getSecondBean();
}
