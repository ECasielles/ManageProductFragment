package com.example.usuario.manageproductsfragment.interfaces;


import com.example.usuario.manageproductsfragment.adapter.ProductAdapter;
import com.example.usuario.manageproductsfragment.model.Product;

import java.util.List;


public interface ProductPresenter {

    void loadProducts();
    Product getProduct(String id);
    void deleteProduct(Product product);

    //Hay gente que no pone el onDestroy
    void onDestroy();

    interface View {
        void showProducts(List<Product> products);
        void showEmptyText(boolean show);
        void showMessage(String message);

        //Sólo porque lo que hacemos es borrar el adaptador
        //en vez de leer otra vez de la BD
        ProductAdapter getAdapter();
    }

}
