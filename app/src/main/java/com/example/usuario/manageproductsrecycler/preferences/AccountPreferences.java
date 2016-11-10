package com.example.usuario.manageproductsrecycler.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.usuario.manageproductsrecycler.interfaces.IPreferences;

/**
 * Created by usuario on 11/10/16.
 */

public class AccountPreferences implements IPreferences {

    private static IPreferences accountPreferences;
    public static final String FILE = "com.example.usuario.manageproductsrecycler_preferences";
    public static final String USER = "";
    public static final String PASSWORD = "";
    private static Context myContext;

    private AccountPreferences() {

    }

    // Singleton de la clase
    public static IPreferences getInstance(Context context) {
        if(accountPreferences == null)
            accountPreferences = new AccountPreferences();
            myContext = context;
        return accountPreferences;
    }

    public static void putName(String user) {
        getEditor().putString(USER, user).apply();
    }

    private SharedPreferences.Editor getEditor() {
        //SharedPreferences sharedPreferences = new SharedPreferences(FILE);
    }

}
