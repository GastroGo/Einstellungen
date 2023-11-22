package com.example.gastrogo_einstellungen_v1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    TextView darkmodeOut;
    TextView benachrichtigungenOut;
    TextView languageOut;
    Button Einstellungen;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Einstellungen = findViewById(R.id.Einstellungen);
        darkmodeOut = findViewById(R.id.darkmodeOut);
        benachrichtigungenOut = findViewById(R.id.benachrichtigungenOut);
        languageOut = findViewById(R.id.languageOut);
        Model model = Model.getInstance();
        model.load(this);
        int darkmode = model.getDarkmode();
        int benachrichtigungen = model.getBenachrichtigungen();
        int language = model.getLanguage();
        darkmodeOut.setText("Darkmode: " + darkmode);
        benachrichtigungenOut.setText("Benachrichtigungen: " + benachrichtigungen);
        languageOut.setText("Sprache: " + language);


        Einstellungen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}