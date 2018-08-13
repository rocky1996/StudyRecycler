package com.example.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter();

        final List<String> itemList = new ArrayList<>();
        itemList.add("大娃");
        itemList.add("二娃");
        itemList.add("三娃");
        itemList.add("四娃");
        itemList.add("五娃");
        itemList.add("六娃");
        itemList.add("七娃");
        itemList.add("八娃");
        itemList.add("九娃");
        itemList.add("十娃");


        adapter.setDataList(itemList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}