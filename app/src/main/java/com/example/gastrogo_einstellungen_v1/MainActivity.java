package com.example.gastrogo_einstellungen_v1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

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

        Spinner spinner_languages = findViewById(R.id.spinner_languages);
        benachrichtigungen = findViewById(R.id.benachrichtigungen);
        darkmode = findViewById(R.id.darkmode);
        schluesselEingabe = findViewById(R.id.schluesselEingabe);
        mitarbeiterLogin = findViewById(R.id.mitarbeiterLogin);
        zurueck = findViewById(R.id.zurueck);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_languages.setAdapter(adapter);
        spinner_languages.setOnItemSelectedListener(this);

        mitarbeiterLogin.setEnabled(false);
        schluesselEingabe.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mitarbeiterLogin.setEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    mitarbeiterLogin.setEnabled(false);
                    String schluesseleingabe = schluesselEingabe.getText().toString();
                    Model model = Model.getInstance();
                    model.setSchluessel(schluesseleingabe);
                    model.save(view.getContext());
                } 
            }
        });

        Model model = Model.getInstance();
        model.load(this);
        if (model.getBenachrichtigungen() == 1) {
            benachrichtigungen.setChecked(true);
        } else {
            benachrichtigungen.setChecked(false);
        }

        if (model.getDarkmode() == 1) {
            darkmode.setChecked(true);
        } else {
            darkmode.setChecked(false);
        }

        if (model.getLanguage() == 1) {
            spinner_languages.setSelection(1);
        } else {
            spinner_languages.setSelection(0);
        }

        schluesselEingabe.setText(model.getSchluessel());

        mitarbeiterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String schluesseleingabe = schluesselEingabe.getText().toString();
                Model model = Model.getInstance();
                model.setSchluessel(schluesseleingabe);
                model.save(view.getContext());
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
                Model model = Model.getInstance();
                if (isChecked) {
                    model.setDarkmode(1);
                } else {
                    model.setDarkmode(0);
                }
                model.save(buttonView.getContext());
            }
        });


        benachrichtigungen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Model model = Model.getInstance();
                if (isChecked) {
                    model.setBenachrichtigungen(1);
                } else {
                    model.setBenachrichtigungen(0);
                }
                model.save(buttonView.getContext());
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Model model = Model.getInstance();
        model.setLanguage(adapterView.getSelectedItemPosition());
        model.save(view.getContext());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}