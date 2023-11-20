package com.example.gastrogo_einstellungen_v1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText schluesselEingabe;
        Switch benachrichtigungen;
        Switch darkmode;
        Button mitarbeiterLogin;
        Button zurueck;

        benachrichtigungen = findViewById(R.id.benachrichtigungen);
        darkmode = findViewById(R.id.darkmode);
        schluesselEingabe = findViewById(R.id.schluesselEingabe);
        mitarbeiterLogin = findViewById(R.id.mitarbeiterLogin);
        zurueck = findViewById(R.id.zurueck);

        mitarbeiterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String schluesseleingabe = schluesselEingabe.getText().toString();
                if (schluesseleingabe.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login erfolgreich", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login fehlgeschlagen", Toast.LENGTH_LONG).show();
                }
            }
        });

        zurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), OutputActivity.class);
                startActivity(intent);
            }
        });

        darkmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (darkmode.isChecked()) {
                    int darkmode = 1;
                } else {
                    int darkmode = 0;
                }
            }
        });

        benachrichtigungen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (benachrichtigungen.isChecked()) {
                    int benachrichtigungen = 1;
                } else {
                    int benachrichtigungen = 0;
                }
            }
        });

        Spinner spinner_languages = findViewById(R.id.spinner_languages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_languages.setAdapter(adapter);
        spinner_languages.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int language = adapterView.getSelectedItemPosition(); // 0 = Deutsch, 1 = Englisch,
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}