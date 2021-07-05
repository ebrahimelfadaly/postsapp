package com.example.mypostapp.data;



import com.example.mypostapp.Pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Call<List<PostModel>> getposts();
}
