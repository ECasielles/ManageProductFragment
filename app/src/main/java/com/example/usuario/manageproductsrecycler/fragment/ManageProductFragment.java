package com.example.usuario.manageproductsrecycler.fragment;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Product;
import com.example.usuario.manageproductsrecycler.presenter.ProductPresenter;

import static com.example.usuario.manageproductsrecycler.fragment.ListProductFragment.PRODUCT_KEY;

public class ManageProductFragment extends Fragment implements IProduct.View{

    private Product product;
    private ImageView imageView;
    private TextInputLayout tilName;
    private TextInputLayout tilBrand;
    private TextInputLayout tilDescription;
    private TextInputLayout tilPrice;
    private TextInputLayout tilStock;
    private Button btnAction;
    private boolean aBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        initialize();
    }

    private void initialize (){
        presenter = new ProductPresenter(this);
        parentLayout = (ViewGroup) findViewById(R.id.activity_manage_product);

        tilName = (TextInputLayout) findViewById(R.id.tilManageName);
        tilDescription = (TextInputLayout) findViewById(R.id.tilManageDetails);
        tilDosage = (TextInputLayout) findViewById(R.id.tilManageDose);
        tilBrand = (TextInputLayout) findViewById(R.id.tilManageBrand);
        tilPrice = (TextInputLayout) findViewById(R.id.tilManagePrice);
        tilStock = (TextInputLayout) findViewById(R.id.tilManageStock);
        btnAction = (Button) findViewById(R.id.btnManageProductOk);

        product = (Product) getIntent().getExtras().getSerializable(PRODUCT_KEY);

        //TODO
        Bundle bundle = getIntent().putExtras();

        if(product != null) {

            //TODO: Arreglar presentador
            presenter.validateProduct(
                    tilName.getEditText().getText().toString(),
                    tilDescription.getEditText().getText().toString(),
                    tilDosage.getEditText().getText().toString(),
                    tilBrand.getEditText().getText().toString(),
                    tilPrice.getEditText().getText().toString(),
                    tilStock.getEditText().getText().toString()
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

    //TODO
    private void saveProduct() {
        Product productNew;
        String name = tilName.getEditText().getText().toString();

        if(addAction)
            productNew = new Product(tilName.getEditText().getText().toString(), tilDescription);
        else


        finish();
    }

    @Override
    public void setMessageError(String nameResource, int viewId) {
        String errorMessage = getResources().getString(getResources().
                getIdentifier(nameResource, "string", getPackageName()));
        Snackbar.make(parentLayout, errorMessage, Snackbar.LENGTH_LONG).show();
    }

}
