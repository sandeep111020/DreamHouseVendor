package com.example.dreamhousevendor.Adapters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
//import com.ceylonlabs.imageviewpopup.ImagePopup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Models.ImageuploadModel;

import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;


public class PhotoAdapter extends FirebaseRecyclerAdapter<ImageuploadModel, PhotoAdapter.myviewholder> {

    String date,taskid,empid;

    Context context;
    DatabaseReference databaseRef;
    String checj;

    public PhotoAdapter(@NonNull FirebaseRecyclerOptions<ImageuploadModel> options, Context context) {
        super(options);
        this.context = context;

    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull ImageuploadModel model) {

        String chek;
//        final ImagePopup imagePopup = new ImagePopup(this);
//        imagePopup.setWindowHeight(800); // Optional
//        imagePopup.setWindowWidth(800); // Optional
//        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
//        imagePopup.setFullScreen(true); // Optional
//        imagePopup.setHideCloseIcon(true);  // Optional
//        imagePopup.setImageOnClickClose(true);
        holder.txt.setText(""+model.getAlbum());
        // holder.total.setText(model.getTotal());
        Picasso.get().load(model.getUrl()).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photolayout, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;




        public myviewholder(@NonNull View itemView) {
            super(itemView);



            img=itemView.findViewById(R.id.imgg);
            txt=itemView.findViewById(R.id.txt);







        }
    }



}