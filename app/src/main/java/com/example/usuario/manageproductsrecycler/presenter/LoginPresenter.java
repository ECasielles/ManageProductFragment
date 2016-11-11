package com.example.usuario.manageproductsrecycler.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.example.usuario.manageproductsrecycler.ProductsActivity;
import com.example.usuario.manageproductsrecycler.interfaces.IValidateUserMvp;
import com.example.usuario.manageproductsrecycler.R;

public class LoginPresenter implements IValidateUserMvp.Presenter {
    private IValidateUserMvp.View view;

    public LoginPresenter(IValidateUserMvp.View loginView){
        this.view = loginView;
    }

    public void validateCredentialsLogin(String user, String password) {
        if (validateCredentialsUser(user) && validateCredentialsPassword(password)) {
            Intent intent = new Intent((Context) view, ProductsActivity.class);
            ((Context) view).startActivity(intent);
        }
    }

    @Override
    public boolean validateCredentialsUser(String user) {
        boolean validate = true;

        if (TextUtils.isEmpty(user)) {
            view.setMessageError(((Context)view).getResources().getString(R.string.data_empty),R.id.edtUsername);
            validate = false;
        }
        return validate;
    }

    @Override
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
