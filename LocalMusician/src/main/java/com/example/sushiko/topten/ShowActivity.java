// Associated with activity_info.xml
// the event profile

package com.example.sushiko.topten;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ticketmaster.discovery.model.Event;

public class ShowActivity extends AppCompatActivity{

    TextView titleTV, locationTV, dateTv;
    ImageView imageIG;
    static String title, location, date;
    static Image image;

    public static Intent BuildIntent(Event event, Context ctx) {
        Intent i = new Intent(ctx, ShowActivity.class);
        title = event.getName();
        //location = event.getLocation();
        date = event.getDates().getStart().getLocalDate();
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle extras = getIntent().getExtras();

        titleTV = findViewById(R.id.profile_event_tv);
        titleTV.setText(title);

        locationTV = findViewById(R.id.profile_location_tv);
        locationTV.setText(location);

        dateTv = findViewById(R.id.profile_date_tv);
        dateTv.setText(date);

    }
}
