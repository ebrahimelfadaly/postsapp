package com.example.mypostapp.data;

import com.example.mypostapp.Pojo.PostModel;
import com.example.mypostapp.data.PostClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASEURL="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface=retrofit.create(PostInterface.class);

    }

    public static PostClient getINSTANCE() {
        if (null== INSTANCE)
        {
            INSTANCE =new PostClient();

        }
        return INSTANCE;
    }
    public Call<List<PostModel>>getposts()
    {
        return postInterface.getposts();
    }
}
