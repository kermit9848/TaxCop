package com.driko.dtrytomergemarkone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(Context context, ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels = mainModels;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set Card Images to ImagesView
        holder.imageView.setImageResource(mainModels.get(position).getCardLogo());
        //set Text Images to TextView
        holder.textView.setText(mainModels.get(position).getCardName());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initalize Variable
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign Variable
            imageView = itemView.findViewById(R.id.dimagesview);
            textView = itemView.findViewById(R.id.dtextview);

        }
    }
}
