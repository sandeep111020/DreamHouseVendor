package com.example.dreamhousevendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dreamhousevendor.Adapters.ProjectAdapter;
import com.example.dreamhousevendor.Models.Newprojectmodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    LinearLayout demo;
    CircleImageView img;
    private RecyclerView recyclerView;
    private ProjectAdapter adapter1;
    private String currentuser;
    Button add;
    String ss="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        demo= findViewById(R.id.demoproj);
        img=findViewById(R.id.img);
        add=findViewById(R.id.add);

        currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //Toast.makeText(HomeActivity.this,currentuser,Toast.LENGTH_SHORT).show();
        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("mobilenumber", "823293629");

        myEdit.commit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_MULTI_PROCESS);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        ss = sh.getString("mobilenumber", "");

        recyclerView=findViewById(R.id.recycler_menu);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i= new Intent(HomeActivity.this,VendorItemUpload.class);
//                startActivity(i);
                Intent i= new Intent(HomeActivity.this,ProjectAddScreen.class);
                startActivity(i);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Newprojectmodel> options =
                new FirebaseRecyclerOptions.Builder<Newprojectmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Projectsvendor").child(ss), Newprojectmodel.class)
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