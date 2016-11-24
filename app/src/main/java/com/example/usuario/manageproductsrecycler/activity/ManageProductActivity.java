package com.example.usuario.manageproductsrecycler.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Product;
import com.example.usuario.manageproductsrecycler.presenter.ProductPresenter;

import static com.example.usuario.manageproductsrecycler.interfaces.IProduct.PRODUCT_KEY;

public class ManageProductActivity extends AppCompatActivity implements IProduct.View{

    private IProduct.Presenter presenter;
    private EditText edtName;
    private EditText edtDescription;
    private EditText edtDosage;
    private EditText edtBrand;
    private EditText edtPrice;
    private EditText edtStock;
    private Button btnAction;
    private Product product;
    private ViewGroup parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        initialize();
    }

    private void initialize (){
        presenter = new ProductPresenter(this);
        parentLayout = (ViewGroup) findViewById(R.id.activity_manage_product);

        edtName = (EditText) findViewById(R.id.edtManageName);
        edtDescription = (EditText) findViewById(R.id.edtManageDetails);
        edtDosage = (EditText) findViewById(R.id.edtManageDose);
        edtBrand = (EditText) findViewById(R.id.edtManageBrand);
        edtPrice = (EditText) findViewById(R.id.edtManagePrice);
        edtStock = (EditText) findViewById(R.id.edtManageStock);
        btnAction = (Button) findViewById(R.id.btnManageProductOk);

        product = (Product) getIntent().getExtras().getSerializable(PRODUCT_KEY);

        if(product != null) {

            presenter.validateProduct(
                    edtName.getText().toString(),
                    edtDescription.getText().toString(),
                    edtDosage.getText().toString(),
                    edtBrand.getText().toString(),
                    edtPrice.getText().toString(),
                    edtStock.getText().toString()
            );

            if (true){
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveProduct();
                    }
                });
            } else {
            }
        }

    }

    private void saveProduct() {

    }

    @Override
    public void setMessageError(String nameResource, int viewId) {
        String errorMessage = getResources().getString(getResources().
                getIdentifier(nameResource, "string", getPackageName()));
        Snackbar.make(parentLayout, errorMessage, Snackbar.LENGTH_LONG).show();
    }

}
