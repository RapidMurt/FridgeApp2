package com.example.fridgeapp.Fridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridgeapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ClassAdapter extends FirestoreRecyclerAdapter<Card, ClassAdapter.ClassHolder> {

    public ClassAdapter(@NonNull FirestoreRecyclerOptions<Card> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ClassHolder holder, int position, @NonNull Card model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewExpireDate.setText(String.valueOf(model.getExpireDate()));
        holder.textViewType.setText(model.getType());
        holder.textViewQuantity.setText(model.getQuantity());
    }

    @Override
    public ClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);



        ImageView addBtn = v.findViewById(R.id.ic_add_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageView minBtn = v.findViewById(R.id.ic_min_button);
        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new ClassHolder(v);
    }

    public void deleteItem(int position)
    {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class ClassHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewExpireDate;
        TextView textViewType;
        TextView textViewQuantity;
        ImageView addImage;

        public ClassHolder(View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_title);
            textViewExpireDate = itemView.findViewById(R.id.textview_expireDate);
            textViewType = itemView.findViewById(R.id.textview_type);
            textViewQuantity = itemView.findViewById(R.id.textview_quantity_fridge);
            addImage = itemView.findViewById(R.id.ic_add_button);


        }
    }

}
