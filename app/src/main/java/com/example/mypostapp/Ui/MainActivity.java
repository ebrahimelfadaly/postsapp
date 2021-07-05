package com.example.mypostapp.Ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypostapp.Pojo.PostModel;
import com.example.mypostapp.R;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewModelposts viewModelposts;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
       final PostAdapter adapter=new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModelposts= new ViewModelProvider(this).get(ViewModelposts.class);
        viewModelposts.getPosts();
        viewModelposts.listMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList((ArrayList<PostModel>) postModels);
            }
        });


    }
}