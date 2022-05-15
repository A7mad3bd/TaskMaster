package com.example.taskmaster.Recyclerview;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmaster.R;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    Context context;
    List<Task> Taskslist;


    public ViewAdapter(Context context, List<Task> Taskslist) {
        this.context = context;
        this.Taskslist = Taskslist;
    }

    public ViewAdapter(List<Task> tasklist) {
        this.Taskslist = tasklist;
    }
    @NonNull
    @Override
    public ViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v= layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }


    public void onBindViewHolder(@NonNull ViewAdapter.MyViewHolder holder, int position) {
        Log.d("position", "onBindViewHolder: ..."+Taskslist.get(position));
        holder.Title.setText(Taskslist.get(position).getTitle());
        holder.Body.setText(Taskslist.get(position).getBody());
        holder.State.setText(Taskslist.get(position).getState());
    }

    @Override
    public int getItemCount() {
        return Taskslist.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
                TextView Title, Body, State;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            Body = itemView.findViewById(R.id.Body);
            State = itemView.findViewById(R.id.State);
        }
    }

}
