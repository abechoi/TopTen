package com.example.sushiko.topten;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public ArrayList<ShowModel> list = new ArrayList<ShowModel>();
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter adapter;
    ShowModel show;
    String [] showArr;
    String [] infoArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showArr = getResources().getStringArray(R.array.showArr);
        infoArr = getResources().getStringArray(R.array.infoArr);

        for(int i = 0; i < 10; i++){
            show = new ShowModel(i,showArr[i],infoArr[i]);
            list.add(show);
        }

        rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        adapter = new MainAdapter(list);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ShowTouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);
    }
}
