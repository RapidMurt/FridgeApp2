package com.example.fridgeapp.Freezer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridgeapp.Fridge.Card;
import com.example.fridgeapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewCardActivityFreezer extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextExpireDate;
    private EditText editTextType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcardfreezer);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Product");
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextExpireDate = findViewById(R.id.edit_text_expireDate);
        editTextType = findViewById(R.id.edit_text_type);
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Freezer()).commit();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String expireDate= editTextExpireDate.getText().toString();
        String type = editTextType.getText().toString();
        if (title.trim().isEmpty() || expireDate.trim().isEmpty() || type.trim().isEmpty()) {
            Toast.makeText(this, "Gelieve alles in te vullen!", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("Freezer");
        notebookRef.add(new Card(title, expireDate, type));
        Toast.makeText(this, "card added", Toast.LENGTH_SHORT).show();
        finish();
    }
}