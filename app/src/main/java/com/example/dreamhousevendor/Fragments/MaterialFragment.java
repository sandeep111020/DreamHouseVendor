package com.example.dreamhousevendor.Fragments;

import android.appwidget.AppWidgetHost;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamhousevendor.Adapters.MaterialAdapter;
import com.example.dreamhousevendor.Adapters.ProjectAdapter;
import com.example.dreamhousevendor.AddMaterial;
import com.example.dreamhousevendor.Models.MaterialModel;
import com.example.dreamhousevendor.Models.Newprojectmodel;
import com.example.dreamhousevendor.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MaterialFragment extends Fragment {

    static String[][] spaceProbes={
            {"1","Pioneer","Chemical","Jupiter"},
            {"2","Voyager","Plasma","Andromeda"},
            {"3","Casini","Solar","Saturn"},
            {"4","Spitzer","Anti-Matter","Andromeda"},
            {"5","Apollo","Chemical","Moon"},
            {"6","Curiosity","Solar","Mars"},

    };
    TableLayout tableView;
    Button add;
    static String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};
    private MaterialFragment materialViewModel;
    private RecyclerView recyclerView;
    private MaterialAdapter adapter1;

    public MaterialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_material, container, false);
         tableView= (TableLayout) root.findViewById(R.id.tableView);
         add= root.findViewById(R.id.addmaterial);
        recyclerView=root.findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseRecyclerOptions<MaterialModel> options =
                new FirebaseRecyclerOptions.Builder<MaterialModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Projectsvendor").child(currentuser).child(currentuser+"My Project").child("Material"), MaterialModel.class)
                        .build();

        // .child("24052021130648")
        adapter1 = new MaterialAdapter(options,getActivity());
        recyclerView.setAdapter(adapter1);
        adapter1.startListening();
         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getActivity(), AddMaterial.class);
                 startActivity(i);
             }
         });

        showTableLayout();

        //SET PROP
//        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
//        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(),spaceProbeHeaders));
//        tableView.setColumnCount(4);
//        tableView.setDataAdapter(new SimpleTableDataAdapter(getActivity(), spaceProbes));
//        tableView.addDataClickListener(new TableDataClickListener() {
//            @Override
//            public void onDataClicked(int rowIndex, Object clickedData) {
//                Toast.makeText(getActivity(), ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
//            }
//        });
        return root;
    }
    public  void showTableLayout() {
        //  Date date = new Date();
        int rows = 8;
        int colums = 3;


        for (int i = 0; i < rows; i++) {

            TableRow tr = new TableRow(getActivity());
            TableLayout.LayoutParams tableRowParams=
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setBackgroundColor(Color.GRAY);
            int leftMargin=10;
            int topMargin=2;
            int rightMargin=10;
            int bottomMargin=2;

            tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

            tr.setLayoutParams(tableRowParams);
            tableView.setStretchAllColumns(true);
            tableView.bringToFront();
            for (int j = 0; j < colums; j++) {
                if(j==0) {
                    TextView txtGeneric = new TextView(getActivity());
                    txtGeneric.setTextSize(18);
                    txtGeneric.setText("Cement" + "\t\t\t\t");
                    tr.addView(txtGeneric);
                }
                else if(j==1){
                    TextView txtGeneric = new TextView(getActivity());
                    txtGeneric.setTextSize(24);
                    txtGeneric.setText("1000" + "\t\t\t\t");
                    tr.addView(txtGeneric);
                }else{
                    TextView txtGeneric = new TextView(getActivity());
                    txtGeneric.setTextSize(24);
                    txtGeneric.setText("250" + "\t\t\t\t");
                    tr.addView(txtGeneric);
                }
                /*txtGeneric.setHeight(30); txtGeneric.setWidth(50);   txtGeneric.setTextColor(Color.BLUE);*/
            }
            tableView.addView(tr);
        }

    }
    @Override
    public void onStop() {
        super.onStop();
        adapter1.startListening();
    }
}
