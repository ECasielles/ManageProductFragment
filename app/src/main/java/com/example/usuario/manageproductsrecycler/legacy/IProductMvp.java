package com.example.usuario.manageproductsrecycler.legacy;

public interface IProductMvp {
    interface View {
        void setMessageError(String error, int viewId);
    }
    interface Presenter {
        boolean validateCredentials(String name, String description, String dosage, String brand,
                                    String price, String stock);
    }
}
