package com.example.sushiko.topten;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ticketmaster.discovery.model.Event;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity{
    public ArrayList<Event> list = new ArrayList<Event>();
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter adapter;
    Event event;
    String [] showArr;
    String [] infoArr;

    TextView eventName, dateTime, location;
    static String name, date, place;

    public static Intent BuildIntent(Event event, Context context) {
        Intent i = new Intent(context, SearchResults.class);
        name = event.getName();
        date = event.getDates().getStart().getLocalDate();
        //place = event.getPlace().getCity().getName();
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        Bundle extras = getIntent().getExtras();
        eventName = findViewById(R.id.event_title_tv);
        dateTime = findViewById(R.id.date_time_tv);
        //location = findViewById(R.id.location_tv);

        eventName.setText(name);
        dateTime.setText(date);
        //location.setText(place);

        this.event = event;
        list.add(event);

        rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        adapter = new MainAdapter(list);
        rv.setLayoutManager(lm);

    }
}
