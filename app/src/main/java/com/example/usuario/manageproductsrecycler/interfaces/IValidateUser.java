package com.example.usuario.manageproductsrecycler.interfaces;

import android.util.Patterns;

import com.example.usuario.manageproductsrecycler.model.Error;

public interface IValidateUser extends IValidateAccount {

    // Adds code to superclass' presenter interface
    interface Presenter {
        static int validateCredentialsEmail(String email) {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                return Error.EMAIL_INVALID;
            return Error.OK;
        }
    }

}
