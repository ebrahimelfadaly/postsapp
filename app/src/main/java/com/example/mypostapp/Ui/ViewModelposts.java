package com.example.mypostapp.Ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mypostapp.Pojo.PostModel;
import com.example.mypostapp.data.PostClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelposts extends ViewModel {
 public  final MutableLiveData<List<PostModel>> listMutableLiveData=new MutableLiveData<>();

    public void getPosts(){
        PostClient.getINSTANCE().getposts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }
}
