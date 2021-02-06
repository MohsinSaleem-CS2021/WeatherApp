package com.example.recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptar extends RecyclerView.Adapter<MyAdaptar.MyViewHolder> {

    private ArrayList<String> data;
    private Context context;
    private OnItemListener onItemListener;

    public MyAdaptar(Context context, ArrayList<String> data, OnItemListener onItemListener){
        this.context = context;
        this.data = data;
        this.onItemListener = onItemListener;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.person_layout, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view, onItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = data.get(position);
        holder.day.setText(name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView day, weather, min, max;
        ImageView imageView;
        OnItemListener onItemListener;

        public MyViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            weather = itemView.findViewById(R.id.weather);
            min = itemView.findViewById(R.id.min);
            max = itemView.findViewById(R.id.max);
            imageView = itemView.findViewById(R.id.imageView);

            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }
}
