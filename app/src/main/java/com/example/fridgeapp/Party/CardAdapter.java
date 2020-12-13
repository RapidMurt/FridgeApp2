package com.example.fridgeapp.Party;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgeapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CardAdapter extends FirestoreRecyclerAdapter<CardParty , CardAdapter.CardHolder> {


    public CardAdapter(@NonNull FirestoreRecyclerOptions<CardParty> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardHolder holder, int position, @NonNull CardParty model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewType.setText(model.getType());
        holder.textViewQuantity.setText(String.valueOf(model.getQuantity()));
        holder.textViewPrice.setText(String.valueOf(model.getPrice()));
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardparty , parent, false);
        return new CardHolder(v);
    }

    class CardHolder extends RecyclerView.ViewHolder
    {
        TextView textViewTitle;
        TextView textViewType;
        TextView textViewPrice;
        TextView textViewQuantity;


        public CardHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_titleParty);
            textViewPrice = itemView.findViewById(R.id.textview_price);
            textViewQuantity = itemView.findViewById(R.id.textview_quantity);
            textViewType = itemView.findViewById(R.id.textview_type);

        }
    }


}
