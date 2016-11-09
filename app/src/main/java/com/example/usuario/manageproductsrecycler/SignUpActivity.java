package com.example.usuario.manageproductsrecycler;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

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
    private void loadSpinnerCounty() {
        spinnerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (view.getId()) {
                    case R.id.spnProvincia:
                        loadSpinnerCity();
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

    private void loadSpinnerCity() {
        // Inicializa el Spinner Localidades
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SignUpActivity.this,
                R.array.array_provincia_a_localidades, android.R.layout.simple_spinner_item);

        spCounty.setAdapter(adapter);
    }

}
