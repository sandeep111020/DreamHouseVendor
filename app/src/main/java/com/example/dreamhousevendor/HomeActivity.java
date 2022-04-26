package com.example.dreamhousevendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dreamhousevendor.Adapters.ProjectAdapter;
import com.example.dreamhousevendor.Models.Newprojectmodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    LinearLayout demo;
    CircleImageView img;
    private RecyclerView recyclerView;
    private ProjectAdapter adapter1;
    private String currentuser;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        demo= findViewById(R.id.demoproj);
        img=findViewById(R.id.img);
        add=findViewById(R.id.add);

        currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        recyclerView=findViewById(R.id.recycler_menu);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,VendorItemUpload.class);
                startActivity(i);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Newprojectmodel> options =
                new FirebaseRecyclerOptions.Builder<Newprojectmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Projectsvendor").child(currentuser), Newprojectmodel.class)
                        .build();

        // .child("24052021130648")
        adapter1 = new ProjectAdapter(options,getApplicationContext());
        recyclerView.setAdapter(adapter1);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,Profile.class);
                startActivity(i);
            }
        });
        demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,ProjectUpdate.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}