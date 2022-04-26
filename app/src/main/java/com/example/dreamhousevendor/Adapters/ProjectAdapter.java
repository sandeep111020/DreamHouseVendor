package com.example.dreamhousevendor.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Models.Newprojectmodel;
import com.example.dreamhousevendor.ProjectUpdate;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;


public class ProjectAdapter extends FirebaseRecyclerAdapter<Newprojectmodel, ProjectAdapter.myviewholder> {

    String date,taskid,empid;

    Context context;
    DatabaseReference databaseRef;
    String checj;

    public ProjectAdapter(@NonNull FirebaseRecyclerOptions<Newprojectmodel> options, Context context) {
        super(options);
        this.context = context;

    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Newprojectmodel model) {

        String chek;

        holder.taskdetails.setText("Task Details: "+model.getName());
        holder.taskdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProjectUpdate.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });







    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_titlelayout, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView taskdetails;




        public myviewholder(@NonNull View itemView) {
            super(itemView);



            taskdetails = (TextView) itemView.findViewById(R.id.demoproj);







        }
    }



}