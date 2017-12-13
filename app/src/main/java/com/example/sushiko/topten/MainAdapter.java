package com.example.sushiko.topten;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Collections;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    ArrayList<ShowModel> list;

    public MainAdapter(ArrayList<ShowModel> list) {
        this.list = list;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShowModel show = list.get(position);
        // Setup the ViewHolder
        holder.setup(show);
    }


    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition) {
        Collections.swap(list, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{



        private ShowModel show;
        private TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.show_title);
            itemView.setOnClickListener(this);
        }

        public void setup(ShowModel show)
        {
            this.show = show;
            this.titleTextView.setText(show.getTitle());
        }

        @Override
        public void onClick(View view)
        {
            Intent showIntent = ShowActivity.BuildIntent(this.show, view.getContext());
            view.getContext().startActivity(showIntent);
        }
    }
}
