package com.example.dreamhousevendor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dreamhousevendor.Models.TestModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestScreen extends AppCompatActivity {

    EditText name, zone;
    Button btn;
    private FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);
        name=findViewById(R.id.textView);
        zone = findViewById(R.id.textView2);
        btn=findViewById(R.id.button);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Sespiczones");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TestModel mode= new TestModel(zone.getText().toString(),name.getText().toString());
//                reference.child(name.getText().toString().toUpperCase()).setValue(mode);
            }
        });

    }
}