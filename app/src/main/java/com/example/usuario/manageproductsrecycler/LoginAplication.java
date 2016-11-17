package com.example.usuario.manageproductsrecycler;

import android.app.Application;

import com.example.usuario.manageproductsrecycler.model.User;

//Al crear la clase que hereda de 'Android.App.Aplication' hay que ir a 'Manifest' y especificarlos.
//En 'Manifest' escribí 'android:name=".LoginAplication"'.
public class LoginAplication extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
