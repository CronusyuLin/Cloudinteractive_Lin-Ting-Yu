package com.example.cloudinteractive.Second;

import android.util.Log;

import com.example.cloudinteractive.Network.ApiClient;
import com.example.cloudinteractive.Network.ApiInterface;
import com.example.cloudinteractive.Second.Bean.SecondBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondModel implements SecondContract.Model{

    final static String TAG = "SecondModel:";

    @Override
    public void getList(OnFinishedListener onFinishedListener) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getSecondBean().enqueue(new Callback<List<SecondBean>>() {
            @Override
            public void onResponse(Call<List<SecondBean>> call, Response<List<SecondBean>> response) {

                List<SecondBean> secondBeanList = response.body();

                //Log
                    for (SecondBean s : secondBeanList) {
                        Log.d(TAG, s.getId().toString());
                        Log.d(TAG, s.getTitle());
                        Log.d(TAG, s.getUrl());
                        Log.d(TAG, s.getThumbnailUrl());
                    }
                onFinishedListener.onFinished(secondBeanList);
            }

            @Override
            public void onFailure(Call<List<SecondBean>> call, Throwable t) {

                Log.d(TAG,t.getMessage());
                onFinishedListener.onFailure(t);

            }
        });
    }

}
