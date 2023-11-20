package com.example.gastrogo_einstellungen_v1;

import android.content.Context;
import android.content.SharedPreferences;

public class Model {
    private static Model instance;
    private int darkmode;
    private int benachrichtigungen;
    private int language;

    private static final String PREF_NAME = "UserData";
    private static final int KEY_DARKMODE = 0;
    private static final int KEY_BENACHRICHTIGUNGEN = 0;
    private static final int KEY_LANGUAGE = 0;

    private Model() {
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void save(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(String.valueOf(KEY_DARKMODE), darkmode);
        editor.putInt(String.valueOf(KEY_BENACHRICHTIGUNGEN), benachrichtigungen);
        editor.putInt(String.valueOf(KEY_LANGUAGE), language);
        editor.apply();
    }

    public void load(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        darkmode = sharedPref.getInt(String.valueOf(KEY_DARKMODE), 0);
        benachrichtigungen = sharedPref.getInt(String.valueOf(KEY_BENACHRICHTIGUNGEN), 0);
        language = sharedPref.getInt(String.valueOf(KEY_LANGUAGE), 0);
    }

    public void setDarkmode(int darkmode) {
        this.darkmode = darkmode;
    }

    public int getDarkmode() {
        return darkmode;
    }

    public void setBenachrichtigungen(int benachrichtigungen) {
        this.benachrichtigungen = benachrichtigungen;
    }

    public int getBenachrichtigungen() {
        return benachrichtigungen;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getLanguage() {
        return language;
    }

}
