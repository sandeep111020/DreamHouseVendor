package com.example.dreamhousevendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dreamhousevendor.Models.MaterialModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMaterial extends AppCompatActivity {

    EditText name,total, balance;
    Button submit;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_material);
        name=findViewById(R.id.materialname);
        total=findViewById(R.id.totol);
        balance=findViewById(R.id.balance);
        submit=findViewById(R.id.submit);
        rootNode = FirebaseDatabase.getInstance();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        SharedPreferences sh1 = getSharedPreferences("MySharedPref", Context.MODE_MULTI_PROCESS);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        number = sh1.getString("mobilenumber", "");
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_MULTI_PROCESS);

        String s1 = sh.getString("projectid", "");
        Toast.makeText(this,s1+"hi",Toast.LENGTH_SHORT).show();
        reference = rootNode.getReference("Projectsvendor").child(number);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialModel addnewUser = new MaterialModel(name.getText().toString(),total.getText().toString(),balance.getText().toString());
                reference.child(s1).child("Material").child(name.getText().toString()).setValue(addnewUser);

            }
        });
    }
}