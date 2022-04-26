package com.example.dreamhousevendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dreamhousevendor.Models.MaterialModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMaterial extends AppCompatActivity {

    EditText name,total, balance;
    Button submit;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

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
        reference = rootNode.getReference("Projectsvendor").child(currentuser);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialModel addnewUser = new MaterialModel(name.getText().toString(),total.getText().toString(),balance.getText().toString());
                reference.child(currentuser+"My Project").child("Material").child(name.getText().toString()).setValue(addnewUser);

            }
        });
    }
}