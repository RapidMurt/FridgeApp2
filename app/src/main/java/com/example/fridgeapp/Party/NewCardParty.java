package com.example.fridgeapp.Party;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fridgeapp.Freezer.Freezer;
import com.example.fridgeapp.Fridge.Card;
import com.example.fridgeapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewCardParty extends AppCompatActivity {

    private EditText editTextPrice;
    private EditText editTextTitle;
    private NumberPicker editTextQuantity;
    private Spinner editTextType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_party);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Drink");
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextType = findViewById(R.id.edit_text_type);
        editTextPrice = findViewById(R.id.edit_text_Price);



        editTextQuantity = findViewById(R.id.edit_text_Quantity);
        editTextQuantity.setMinValue(1);
        editTextQuantity.setMaxValue(100);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                saveNote();
                return true;
            case R.id.close:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Party()).commit();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void saveNote() {
        String title = editTextTitle.getText().toString();
        int Quantity = editTextQuantity.getValue();
        String type = editTextType.getSelectedItem().toString();
        double Price = Double.parseDouble((editTextPrice.getText().toString()));

        if (title.trim().isEmpty() ||  type.trim().isEmpty()) {
            Toast.makeText(this, "Gelieve alles in te vullen!", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("PartyMode");
        notebookRef.add(new CardParty(title , Quantity , type , Price));
        Toast.makeText(this, "card added", Toast.LENGTH_SHORT).show();
        finish();
    }
}