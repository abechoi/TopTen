// Associated with activity_main.xml
// the search bar

package com.example.sushiko.topten;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import java.io.IOException;

import com.ticketmaster.api.discovery.DiscoveryApi;
import com.ticketmaster.api.discovery.operation.SearchEventsOperation;
import com.ticketmaster.api.discovery.response.PagedResponse;
import com.ticketmaster.discovery.model.Event;
import com.ticketmaster.discovery.model.Events;

public class MainActivity extends AppCompatActivity{

    EditText search_et;
    TextView title,info,date,venue;
    Event event;
    public String apikey = "KLEDbDrUK3YCMbgO1eQQHPIRhoVhkxBA";
    public DiscoveryApi api = new DiscoveryApi(apikey);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_et = findViewById(R.id.search_bar);
    }

    public void onClick(View view) {

        Intent showIntent = SearchResults.BuildIntent(this.event, view.getContext());
        view.getContext().startActivity(showIntent);
        new Search(event).execute(search_et.getText().toString());
    }

    public class Search extends AsyncTask<String,String,String> {

        Event event;

        Search(Event event){
            this.event = event;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                PagedResponse<Events> page = null;
                page = api.searchEvents(new SearchEventsOperation().keyword(""));
                List<Event> events = page.getContent().getEvents();

                for(int i=0; i<10; ++i){
                    event = events.get(i);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Get Title
            title.setText(event.getName());
            // Get Dates
            date.setText(event.getDates().getStart().getLocalDate());
            // Get Location
            //where = event.getPlace().getCity().getName();
            //venue.setText(where);
            // Get Info
            if(event.getInfo()!=null){info.setText(event.getInfo());}
            else{info.setText(R.string.no_info);}
        }
    }
}
