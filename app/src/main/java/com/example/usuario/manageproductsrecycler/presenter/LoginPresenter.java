package com.example.usuario.manageproductsrecycler.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.usuario.manageproductsrecycler.ProductsActivity;
import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IValidateAccount;
import com.example.usuario.manageproductsrecycler.interfaces.IValidateAccount.Presenter;
import com.example.usuario.manageproductsrecycler.utils.ErrorMapUtils;
import com.example.usuario.manageproductsrecycler.model.Error;


public class LoginPresenter implements Presenter {
    private IValidateAccount.View view;
    private int validateUser;
    private int validatePassword;
    private Context context;

    public LoginPresenter(IValidateAccount.View loginView){
        this.view = loginView;
        this.context = (Context) loginView;
    }

    public void validateCredentialsLogin(String user, String password) {

        validateUser = Presenter.validateCredentialsUser(user);
        validatePassword = Presenter.validateCredentialsPassword(password);

        if (validateUser == Error.OK) {
            if (validatePassword == Error.OK) {
                Intent intent = new Intent((Context) view, ProductsActivity.class);
                view.startActivity(intent);
            }else {
                String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validatePassword));
                view.setMessageError(resourceName, R.id.tilUsername);
            }
        }else {
            // Extracts error name from a given error code
            String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateUser));
            view.setMessageError(resourceName, R.id.tilUsername);
        }
    }
}
