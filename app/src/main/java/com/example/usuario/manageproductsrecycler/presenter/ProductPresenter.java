package com.example.usuario.manageproductsrecycler.presenter;

import com.example.usuario.manageproductsrecycler.interfaces.IProductMvp;
import com.example.usuario.manageproductsrecycler.model.Product;

public class ProductPresenter implements IProductMvp.Presenter{

    private final IProductMvp.View view;

    public ProductPresenter(IProductMvp.View view) {
        this.view = view;
    }

    @Override
    public boolean validateCredentials(String name, String description, String dosage, String brand, String price, String stock) {
        //Fields validation
        return false;
    }

}
