package com.example.dreamhousevendor.Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Models.MaterialModel;

import com.example.dreamhousevendor.Models.TaskModel;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;


public class TaskAdapter extends FirebaseRecyclerAdapter<TaskModel, TaskAdapter.myviewholder> {

    String date,taskid,empid;

    Context context;
    DatabaseReference databaseRef;
    String checj;

    public TaskAdapter(@NonNull FirebaseRecyclerOptions<TaskModel> options, Context context) {
        super(options);
        this.context = context;

    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull TaskModel model) {

        String chek;

        holder.start.setText(model.getStart());
        holder.name.setText(model.getTaskname());
        holder.end.setText(model.getEnd());
        holder.progress.setText(model.getProgress()+"%");

//        holder.taskdetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, ProjectUpdate.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//            }
//        });







    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView start,end,name,progress;




        public myviewholder(@NonNull View itemView) {
            super(itemView);



            start = (TextView) itemView.findViewById(R.id.start);
            end = (TextView) itemView.findViewById(R.id.end);
            name = (TextView) itemView.findViewById(R.id.name);
            progress = (TextView) itemView.findViewById(R.id.progress);







        }
    }





}