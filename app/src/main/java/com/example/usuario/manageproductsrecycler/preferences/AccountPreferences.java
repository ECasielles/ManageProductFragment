package com.example.usuario.manageproductsrecycler.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.usuario.manageproductsrecycler.interfaces.IPreferences;

public class AccountPreferences implements IPreferences {

    private static IPreferences accountPreferences;
    // Id de la app (en Project Structure)
    //public static final String FILE = "com.example.usuario.manageproductsrecycler_preferences";

    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    private SharedPreferences sharedPreferences;

    private AccountPreferences(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    // Singleton de la clase
    public static IPreferences getInstance(Context context) {
        if(accountPreferences == null)
            accountPreferences = new AccountPreferences(context);
        return accountPreferences;
    }

    // Recuerda que apply no notifica los fallos
    // Android nos permite no preocuparnos por el ciclo de vida de la aplicación
    public void putUser(String user) {
        getEditor().putString(USER, user).apply();
    }
    public void putPassword(String password) {
        getEditor().putString(PASSWORD, password).apply();
    }
    public void putEmail(String email) {
        getEditor().putString(EMAIL, email).apply();
    }

    private SharedPreferences.Editor getEditor() {
        //SharedPreferences sharedPreferences = new SharedPreferences(FILE);

        // Con el editor pongo los diferentes campos
        return sharedPreferences.edit();
    }

}
