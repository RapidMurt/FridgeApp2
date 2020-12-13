package com.example.fridgeapp.Party;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fridgeapp.Fridge.Card;
import com.example.fridgeapp.Fridge.ClassAdapter;
import com.example.fridgeapp.Fridge.NewCardActivity;
import com.example.fridgeapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Party extends Fragment {

    Button toevoegBtn , leegBtn;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("PartyMode");

    private CardAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_party, container, false);

        toevoegBtn = view.findViewById(R.id.toevoegBtn);
        leegBtn = view.findViewById(R.id.leegBtn);


        toevoegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , NewCardParty.class));
            }
        });

        leegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Leeg()).commit();
            }
        });

        setUpRecyclerView(view);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpRecyclerView(View view){

        Query query = notebookRef.orderBy("quantity" , Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<CardParty> options = new FirestoreRecyclerOptions.Builder<CardParty>()
                .setQuery(query , CardParty.class)
                .build();
        adapter = new CardAdapter(options);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true); //for preformins reaseons
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); //this
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}