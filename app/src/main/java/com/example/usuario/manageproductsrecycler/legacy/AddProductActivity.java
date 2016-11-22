package com.example.usuario.manageproductsrecycler.legacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProductMvp;
import com.example.usuario.manageproductsrecycler.legacy.ProductsActivityRecycler;
import com.example.usuario.manageproductsrecycler.presenter.ProductPresenter;

public class AddProductActivity extends AppCompatActivity implements IProductMvp.View{
    IProductMvp.Presenter presenter;
    EditText edtName;
    EditText edtDescription;
    EditText edtDosage;
    EditText edtBrand;
    EditText edtPrice;
    EditText edtStock;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        initialize();
    }

    private void initialize (){
        presenter = new ProductPresenter(this);
        edtName = (EditText) findViewById(R.id.edtProductName);
        edtDescription = (EditText) findViewById(R.id.edtProductDescription);
        edtDosage = (EditText) findViewById(R.id.edtProductDosage);
        edtBrand = (EditText) findViewById(R.id.edtProductBrand);
        edtPrice = (EditText) findViewById(R.id.edtProductPrice);
        edtStock = (EditText) findViewById(R.id.edtProductStock);

        btnAdd = (Button) findViewById(R.id.btnProductAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.validateCredentials(
                        edtName.getText().toString(),
                        edtDescription.getText().toString(),
                        edtDosage.getText().toString(),
                        edtBrand.getText().toString(),
                        edtPrice.getText().toString(),
                        edtStock.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), ProductsActivityRecycler.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void clearFields(){
        edtName.setText("");
        edtDescription.setText("");
        edtDosage.setText("");
        edtBrand.setText("");
        edtPrice.setText("");
        edtStock.setText("");
    }

    @Override
    public void setMessageError(String error, int viewId) {
        switch (viewId){
            case R.id.edtProductName:
                edtName.setError(error);
                break;
            case R.id.edtProductDescription:
                edtDescription.setError(error);
                break;
            case R.id.edtProductDosage:
                edtDosage.setError(error);
                break;
            case R.id.edtProductBrand:
                edtBrand.setError(error);
                break;
            case R.id.edtProductPrice:
                edtPrice.setError(error);
                break;
            case R.id.edtProductStock:
                edtStock.setError(error);
                break;
        }
    }
}
