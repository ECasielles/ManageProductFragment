package com.example.usuario.manageproductsrecycler.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IValidateAccount;
import com.example.usuario.manageproductsrecycler.legacy.ProductsActivityRecycler;
import com.example.usuario.manageproductsrecycler.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IValidateAccount.View {

    private IValidateAccount.Presenter presenter;
    private EditText edtPassword;
    private EditText edtUser;
    private Button btnOk;
    private Button btnSignUp;
    private final String TAG = "loginrelative";
    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private ViewGroup parentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        // Generalized programming
        parentLayout = (ViewGroup) findViewById(R.id.activity_login_relative);

        presenter = new LoginPresenter(this);
        edtUser = (EditText) findViewById(R.id.edtUserLogin);
        edtPassword = (EditText) findViewById(R.id.edtUserPasswordLogin);

        btnOk = (Button) findViewById(R.id.btnLoginOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginPresenter) presenter).validateCredentialsLogin(
                        edtUser.getText().toString(),
                        edtPassword.getText().toString())
                ;
            }
        });

        btnSignUp = (Button) findViewById(R.id.btnSignupLogin);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void resetValues() {
        edtUser.setText("");
        edtPassword.setText("");
    }

    @Override
    public void setMessageError(String resourceName, int idView) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
        // We have to pick the resource whose name is that given as a parameter
        String errorMessage = getResources().getString(getResources().getIdentifier(resourceName, "string", getPackageName()));
        switch (idView){
            case R.id.tilSignupUsername:
                //tilUser.setError(errorMessage);
                Snackbar.make(parentLayout, errorMessage, Snackbar.LENGTH_LONG).show();
                break;
            case R.id.tilSignupUserPassword:
                //tilPassword.setError(errorMessage);
                Snackbar.make(parentLayout, errorMessage, Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    public void startActivity() {
        Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
        startActivity(intent);
    }

}
