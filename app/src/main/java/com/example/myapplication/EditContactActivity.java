package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {
    private EditText editTextName, editTextPhone, editTextAddress, editTextDob;
    private Button saveButton;
    private int position;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextDob = findViewById(R.id.editTextDob);
        saveButton = findViewById(R.id.saveButton);

        // Get the contact details from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            editTextName.setText(bundle.getString("name"));
            editTextPhone.setText(bundle.getString("phoneNumber"));
            editTextAddress.setText(bundle.getString("address"));
            editTextDob.setText(bundle.getString("dob"));
            position = bundle.getInt("position");
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String address = editTextAddress.getText().toString();
                String dob = editTextDob.getText().toString();

                if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || dob.isEmpty()) {
                    Toast.makeText(EditContactActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact updatedContact = new Contact(name, phone, address, dob);
                MainActivity.contactArrayList.set(position, updatedContact);
                MainActivity.adapter.notifyDataSetChanged();
                finish();
            }
        });
    }
}
