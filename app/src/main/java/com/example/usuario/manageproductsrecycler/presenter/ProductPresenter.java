package com.example.usuario.manageproductsrecycler.presenter;

import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Product;

public class ProductPresenter implements IProduct.Presenter{

    private final IProduct.View view;
    private IProduct.Presenter presenter;
    Product product;

    public ProductPresenter(IProduct.View view) {
        this.view = view;
    }
    @Override
    public boolean validateCredentials(String name, String description, String dosage, String brand, String price, String stock) {

        //Fields validation
        return false;
    }

}
