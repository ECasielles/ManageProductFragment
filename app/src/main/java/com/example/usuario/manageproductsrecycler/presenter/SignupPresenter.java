package com.example.usuario.manageproductsrecycler.presenter;

import com.example.usuario.manageproductsrecycler.interfaces.IValidateUser;
import com.example.usuario.manageproductsrecycler.model.User;

public class SignupPresenter implements IValidateUser.Presenter, IValidateUser.PresenterUser {

    public boolean validateCredentials(User user) {
        return true;
    }
}
