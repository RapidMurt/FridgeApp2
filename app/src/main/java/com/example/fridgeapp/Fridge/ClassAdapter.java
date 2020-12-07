package com.example.fridgeapp.Fridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgeapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ClassAdapter extends FirestoreRecyclerAdapter<Card, ClassAdapter.ClassHolder> {

    class ClassHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewExpireDate;
        TextView textViewType;

        public ClassHolder(View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_title);
            textViewExpireDate = itemView.findViewById(R.id.textview_expireDate);
            textViewType = itemView.findViewById(R.id.textview_type);
        }
    }
    public ClassAdapter(@NonNull FirestoreRecyclerOptions<Card> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ClassHolder holder, int position, @NonNull Card model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewExpireDate.setText(model.getExpireDate());
        holder.textViewType.setText(model.getType());
    }

    @NonNull
    @Override
    public ClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ClassHolder(v);
    }



}
