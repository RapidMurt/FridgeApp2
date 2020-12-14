package com.example.fridgeapp.Party;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fridgeapp.R;

import java.text.DecimalFormat;

public class Leeg extends Fragment {

    double bilTotal , finalBill;
    Button splitBtn;
    int numOfPeople;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_leeg, container, false);

        final EditText bill = (EditText)view.findViewById(R.id.billAmount);
        final EditText Persons = (EditText)view.findViewById(R.id.AmountOffPersons);

        splitBtn =(Button)view.findViewById(R.id.splitBtn);
        splitBtn.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)view.findViewById(R.id.textViewResult));
            public void onClick(View v) {
                numOfPeople = Integer.parseInt(Persons.getText().toString());
                bilTotal  = Double.parseDouble((bill.getText().toString()));

                finalBill = bilTotal / numOfPeople;

                DecimalFormat currency = new DecimalFormat("€###,###.00");

                result.setText("Totaal bedrag: " + currency.format(bilTotal) + "\nBedrag per persoon: " + currency.format(finalBill));

            }
        });

        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}