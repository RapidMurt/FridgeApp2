package com.example.fridgeapp.Freezer;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridgeapp.Fridge.Card;
import com.example.fridgeapp.Fridge.NewCardActivity;
import com.example.fridgeapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class NewCardActivityFreezer extends AppCompatActivity {

    private EditText editTextTitle;
    private TextView editTextExpireDate;
    private Spinner editTextType;
    private EditText editTextQuantity;

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcardfreezer);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Product");
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextQuantity = findViewById(R.id.edit_text_QuantityFridge);

        editTextExpireDate = findViewById(R.id.edit_text_expireDate);
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        editTextExpireDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(NewCardActivityFreezer.this , R.style.Theme_AppCompat_DayNight_Dialog_MinWidth,
                        onDateSetListener , year , month , day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                editTextExpireDate.setText(date);
            }
        };
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
        String type = editTextType.getSelectedItem().toString();
        String quantity = editTextQuantity.getText().toString();
        if (title.trim().isEmpty() || expireDate.trim().isEmpty() || type.trim().isEmpty() || quantity.isEmpty()) {
            Toast.makeText(this, "Gelieve alles in te vullen!", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("Freezer");
        notebookRef.add(new Card(title, expireDate, type, quantity));
        Toast.makeText(this, "card added", Toast.LENGTH_SHORT).show();
        finish();
    }
}