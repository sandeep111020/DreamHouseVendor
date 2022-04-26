package com.example.dreamhousevendor.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dreamhousevendor.Models.PaymentModel;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;


public class PaymentAdapter extends FirebaseRecyclerAdapter<PaymentModel, PaymentAdapter.myviewholder> {

    String date,taskid,empid;

    Context context;
    DatabaseReference databaseRef;
    String checj;

    public PaymentAdapter(@NonNull FirebaseRecyclerOptions<PaymentModel> options, Context context) {
        super(options);
        this.context = context;

    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull PaymentModel model) {

        String chek;

        holder.taskdetails.setText(model.getPaymentname());
        // holder.total.setText(model.getTotal());
        holder.total.setText(model.getPaymentcost());

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView taskdetails,total;




        public myviewholder(@NonNull View itemView) {
            super(itemView);



            taskdetails = (TextView) itemView.findViewById(R.id.name);
            total = (TextView) itemView.findViewById(R.id.cost);








        }
    }



}