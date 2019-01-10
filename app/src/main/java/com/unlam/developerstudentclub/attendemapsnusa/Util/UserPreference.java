package com.unlam.developerstudentclub.attendemapsnusa.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {

    private String KEY_NAMA = "name";
    private String KEY_CODE = "code";
    private SharedPreferences preferences;

    public UserPreference(Context context) {
        String PREFS_NAME = "UserPreference";
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setPreference(String nama, int code){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_CODE, code);
        editor.putString(KEY_NAMA, nama);
        editor.apply();
    }

    public void clearePreference(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_CODE, 0);
        editor.putString(KEY_NAMA, null);
        editor.apply();
    }

    public int getCode(){
        return preferences.getInt(KEY_CODE, 0);
    }
    public String getNama(){
        return preferences.getString(KEY_NAMA,"");
    }

}
