package com.example.usuario.manageproductsrecycler;

import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.usuario.manageproductsrecycler.R.id.edtEmail;

public class SignUpActivity extends AppCompatActivity {

    private Spinner spCounty;
    private Spinner spCity;
    private Button btnSignup;
    private RadioGroup typeClient;
    private TextInputLayout tilNameCompany;
    private AdapterView.OnItemSelectedListener spinnerListener; //Atributo delegado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spCounty = (Spinner) findViewById(R.id.spnProvincia);
        spCity = (Spinner) findViewById(R.id.spnLocalidad);

        tilNameCompany = (TextInputLayout) findViewById(R.id.tilCompany);

        typeClient = (RadioGroup) findViewById(R.id.rgpIsCompany);
        typeClient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtClient:
                        showCompany(false);
                        break;
                    case R.id.rbtCompany:
                        showCompany(true);
                        break;
                }
            }
        });

        loadSpinnerCounty();
    }

    private void showCompany(boolean b) {
        tilNameCompany.setVisibility(b ? View.VISIBLE : View.GONE);
    }
    public void signup(View view) {

    }
    // Loads both spinners, starting with the counties/provinces drop down list
    private void loadSpinnerCounty() {
        spinnerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (adapterView.getId()) {
                    case R.id.spnProvincia:

                        adapterView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                loadSpinnerCity(position);
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {
                            }
                        });
                        break;
                    case R.id.spnLocalidad:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        // Inicializa el Spinner Provincias
        // Le pasamos CharSequence para poder manejar StringBuilder, etc.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SignUpActivity.this,
                R.array.array_provincia_a_localidades, android.R.layout.simple_spinner_item);

        spCounty.setAdapter(adapter);
    }

    private void loadSpinnerCity(int position) {
        // Inicializa el Spinner Localidades
        TypedArray typedCity = getResources().obtainTypedArray(position);
        CharSequence[] arrayCities = typedCity.getTextArray(position);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,arrayCities);

        spCounty.setAdapter(adapter);
    }


    public boolean validate(){

        boolean isValid = true;

        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        EditText edtUsername = (EditText) findViewById(R.id.edtUsername);
        EditText edtPwd = (EditText) findViewById(R.id.edtUserPassword);

        String email = edtEmail.getText().toString();
        String username = edtUsername.getText().toString();
        String pwd = edtPwd.getText().toString();

        if (email.matches(String.valueOf(Patterns.EMAIL_ADDRESS))) {
            isValid
        }

        //if ()
        //isValid = false;

        return isValid;
    }
}
