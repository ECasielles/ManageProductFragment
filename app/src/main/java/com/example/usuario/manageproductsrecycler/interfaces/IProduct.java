package com.example.usuario.manageproductsrecycler.interfaces;

public interface IProduct {
    interface View {
        void setMessageError(String error, int viewId);
    }
    interface Presenter {
        boolean validateCredentials(String name, String description, String dosage, String brand,
                                    String price, String stock);
    }
}
