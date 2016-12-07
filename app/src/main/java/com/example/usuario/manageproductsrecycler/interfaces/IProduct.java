package com.example.usuario.manageproductsrecycler.interfaces;

public interface IProduct {

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
