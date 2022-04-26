package com.example.dreamhousevendor.Fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Adapters.MaterialAdapter;
import com.example.dreamhousevendor.Adapters.TaskAdapter;
import com.example.dreamhousevendor.AddMaterial;
import com.example.dreamhousevendor.AddTask;
import com.example.dreamhousevendor.Models.MaterialModel;
import com.example.dreamhousevendor.Models.TaskModel;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class TaskFragment extends Fragment {


    private Button add;
    RecyclerView recyclerView;
    private TaskAdapter adapter1;

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_task, container, false);
        add= root.findViewById(R.id.add);
        recyclerView=root.findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseRecyclerOptions<TaskModel> options =
                new FirebaseRecyclerOptions.Builder<TaskModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Projectsvendor").child(currentuser).child(currentuser+"My Project").child("Task"), TaskModel.class)
                        .build();

        // .child("24052021130648")
        adapter1 = new TaskAdapter(options,getActivity());
        recyclerView.setAdapter(adapter1);
        adapter1.startListening();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddTask.class);
                startActivity(i);
            }
        });
        return root;
    }

}
