package com.example.usuario.manageproductsrecycler.interfaces;

import android.content.Context;
import android.text.TextUtils;

import com.example.usuario.manageproductsrecycler.R;

public interface IValidateUserMvp {

    /*
    int PASSWORD_OK = 0;
    int PASSWORD_DIGIT = 1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGHT = 3;
    int DATA_EMPTY = 4;
    */

    interface View {
        void setMessageError(String error, int viewId);
    }

    interface Presenter {
        //boolean validateCredentialsUser(String user);
        //boolean validateCredentialsPassword(String password);

        // Lo implementamos en la interfaz gracias a Java 8
        // aunque mezclamos código con interfaces y no parece buena idea

        public boolean validateCredentialsUser(String user) {
            boolean validate = true;

            if (TextUtils.isEmpty(user)) {
                view.setMessageError(((Context)view).getResources().getString(R.string.data_empty),R.id.edtUsername);
                validate = false;
            }
            return validate;
        }

        public boolean validateCredentialsPassword(String password) {
            boolean validate = true;
            int idMessage = 0;

            if (TextUtils.isEmpty(password)) {
                idMessage = R.string.data_empty;
            } else if (!password.matches(".*[0-9].*")) {
                idMessage = R.string.password_digit;
            } else if (!password.matches(".*[a-zA-Z].*")) {
                idMessage = R.string.password_case;
            } else if (password.length() < 8) {
                idMessage = R.string.password_length;
            }

            if (!validate) {
                view.setMessageError(((Context) view).getResources().getString(idMessage), R.id.tilUserPassword);
                validate = false;
            }

            return validate;
        }
    }
}
