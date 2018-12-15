package com.example.dong.odometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";

    RecyclerView recyclerView;
    StepAdapter adapter;
    List<StepRecord> records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initDate();
        initView();
    }

    private void initDate(){
        records = new ArrayList<>();
        Gson gson = new Gson();
        String json = SPUtils.getInstance(this).getString("StepRecord", null);
        records = gson.fromJson(json,new TypeToken<List<StepRecord>>(){}.getType());
    }

    private void initView(){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new StepAdapter(this,records);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
