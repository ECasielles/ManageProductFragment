package com.example.usuario.manageproductsfragment.interfaces;

public interface IProduct {

    String PRODUCT_KEY = "product";
    interface View {
        void setMessageError(String messageError, int viewId);
        interface IValidateProduct {
            void startActivity();
        }
    }
    interface Presenter {
        void validateProduct(String name, String description, String dosage, String brand,
                                String price, String stock);
    }

}
