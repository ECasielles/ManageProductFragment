package com.example.usuario.manageproductsrecycler.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProductMvp;
import com.example.usuario.manageproductsrecycler.legacy.ProductsActivityRecycler;
import com.example.usuario.manageproductsrecycler.model.Product;
import com.example.usuario.manageproductsrecycler.presenter.ProductPresenter;

import static com.example.usuario.manageproductsrecycler.interfaces.IProduct.PRODUCT_KEY;

public class ManageProductActivity extends AppCompatActivity {

    private IProductMvp.Presenter presenter;
    private EditText edtName;
    private EditText edtDescription;
    private EditText edtDosage;
    private EditText edtBrand;
    private EditText edtPrice;
    private EditText edtStock;
    private Button btnAction;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        initialize();
    }

    private void initialize (){
        //TODO Revisar esta línea. Refactorizar las interfaces.
        presenter = new ProductPresenter((IProductMvp.View) this);
        //

        edtName = (EditText) findViewById(R.id.edtProductName);
        edtDescription = (EditText) findViewById(R.id.edtProductDescription);
        edtDosage = (EditText) findViewById(R.id.edtProductDosage);
        edtBrand = (EditText) findViewById(R.id.edtProductBrand);
        edtPrice = (EditText) findViewById(R.id.edtProductPrice);
        edtStock = (EditText) findViewById(R.id.edtProductStock);

        btnAction = (Button) findViewById(R.id.btnProductAdd);
        product = (Product) getIntent().getExtras().getSerializable(PRODUCT_KEY);
        if(product != null) {
            if (presenter.validateCredentials(
                    edtName.getText().toString(),
                    edtDescription.getText().toString(),
                    edtDosage.getText().toString(),
                    edtBrand.getText().toString(),
                    edtPrice.getText().toString(),
                    edtStock.getText().toString())){
                Intent intent = new Intent(getApplicationContext(), ProductsActivityRecycler.class);
                startActivity(intent);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveProduct();
                    }
                });

            } else {
                saveProduct();
            }
        }
    }

    private void saveProduct() {

    }

}
