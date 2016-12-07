package com.example.usuario.manageproductsrecycler.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Error;
import com.example.usuario.manageproductsrecycler.utils.ErrorMapUtils;

public class ProductPresenter implements IProduct.Presenter {

    private final IProduct.View view;
    private Context context;

    public ProductPresenter(IProduct.View view) {
        this.view = view;
        this.context = (Context) view;
    }

    @Override
    public void validateProduct(String name, String description, String dosage, String brand, String price, String stock) {
    }

}
