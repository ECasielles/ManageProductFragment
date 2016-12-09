package com.example.usuario.manageproductsfragment.repository;

import com.example.usuario.manageproductsfragment.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductRepository {
    private static ProductRepository repository;
    private ArrayList<Product> products = new ArrayList<>();

    private ProductRepository(ArrayList<Product> products) {
        this.products = products;
    }

    public static ProductRepository getInstance() {
        if (repository == null)
        return this();
    }

    public List<Product> getProducts() {
        Collections.sort(products, Product.PRICE_COMPARATOR);
        //Collections.sort(products, (p1, p2) -> Double.compare(p1.getmPrice(), p2.getmPrice()));
        return products;
    }
    public List<Product> getProducts(boolean ascendente){
        //El segundo argumento es cómo va a compararse, cambiar entre las dos constantes Comparator creados para ordenar de manera distinta.
        //Collections.sort(products, Product.PRICE_COMPARATOR);
        if (!ascendente)
            Collections.sort(products, Collections.reverseOrder());
        else
            Collections.sort(products);
        return products;
    }
    public void saveProduct (Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
    }
}
