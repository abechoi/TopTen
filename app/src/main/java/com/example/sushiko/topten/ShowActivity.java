package com.example.sushiko.topten;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity{

    TextView titleTV, infoTV;
    static String title, info;

    public static Intent BuildIntent(ShowModel show, Context ctx) {
        Intent i = new Intent(ctx, ShowActivity.class);
        title = show.getTitle();
        info = show.getInfo();

        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle extras = getIntent().getExtras();
        titleTV = findViewById(R.id.tv_title);
        titleTV.setText(title);

        infoTV = findViewById(R.id.tv_info);
        infoTV.setText(info);

    }
}
