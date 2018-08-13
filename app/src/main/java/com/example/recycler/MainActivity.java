package com.example.recycler;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

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

        final List<String> list = new ArrayList<>();
        list.add("大娃");
        list.add("二娃");
        list.add("三娃");
        list.add("四娃");
        list.add("五娃");
        list.add("六娃");
        list.add("七娃");
        list.add("八娃");
        list.add("九娃");
        list.add("十娃");

        adapter.setDataList(list);

        adapter.setOnItemLongClickListener(new RecyclerViewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(final int position) {
//                Toast.makeText(MainActivity.this, "long click " + itemList.get(position), Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String[] options = {"update", "add", "delete"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                                View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.dia_add_update, null);
                                builder1.setView(view2);
                                final EditText editText2 = view2.findViewById(R.id.editText);
                                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        list.set(position, editText2.getText().toString());
                                        adapter.setDataList(list);
                                    }
                                });
                                builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                builder1.show();
                                break;
                            case 1:
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.dia_add_update, null);
                                builder2.setView(view1);
                                final EditText editText = view1.findViewById(R.id.editText);
                                builder2.setPositiveButton("向后添加", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        list.add(position + 1, editText.getText().toString());
                                        adapter.setDataList(list);
                                    }
                                });
                                builder2.setNegativeButton("向前添加", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        list.add(position, editText.getText().toString());
                                        adapter.setDataList(list);
                                    }
                                });
                                builder2.show();
                                break;
                            case 2:
                                list.remove(position);
                                adapter.setDataList(list);
                                break;
                            default:
                                break;
                        }
                    }
                });
                builder.show();
            }
        });


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}