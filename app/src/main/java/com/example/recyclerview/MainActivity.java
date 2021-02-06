package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdaptar.OnItemListener{

    ArrayList<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DummyData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdaptar myAdaptar = new MyAdaptar(this,data, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdaptar);

    }

    private void DummyData(){
        data = new ArrayList<>();
        data.add("Mohsin");
        data.add("Saleem");
        data.add("Qaisar");
        data.add("Ijaz");
        data.add("Ahsan");
        data.add("Saleem");
        data.add("Sheikh");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DayWeather.class);
        startActivity(intent);

    }
}