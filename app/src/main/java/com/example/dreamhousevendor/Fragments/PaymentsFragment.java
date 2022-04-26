package com.example.dreamhousevendor.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Adapters.MaterialAdapter;
import com.example.dreamhousevendor.Adapters.PaymentAdapter;
import com.example.dreamhousevendor.AddMaterial;
import com.example.dreamhousevendor.Models.MaterialModel;
import com.example.dreamhousevendor.Models.PaymentModel;
import com.example.dreamhousevendor.NewPayment;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class PaymentsFragment extends Fragment {


    private RecyclerView recyclerView;
    private PaymentAdapter adapter1;
    private Button add;

    public PaymentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_payments, container, false);
        recyclerView=root.findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        add= root.findViewById(R.id.addpayment);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NewPayment.class);
                startActivity(i);
            }
        });
        FirebaseRecyclerOptions<PaymentModel> options =
                new FirebaseRecyclerOptions.Builder<PaymentModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Projectsvendor").child(currentuser).child(currentuser+"My Project").child("Payment"), PaymentModel.class)
                        .build();

        // .child("24052021130648")
        adapter1 = new PaymentAdapter(options,getActivity());
        recyclerView.setAdapter(adapter1);
        adapter1.startListening();
        return root;
    }

}