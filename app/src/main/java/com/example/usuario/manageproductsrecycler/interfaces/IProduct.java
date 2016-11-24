package com.example.usuario.manageproductsrecycler.interfaces;

public interface IProduct {
    String PRODUCT_KEY = "product";
    //String EDIT_KEY = "product";


    interface View {
        void setMessageError(String messageError, int viewId);
        interface IValidateProduct {
            void startActivity();
        }
    }
    interface Presenter {
        ErrorResource validateProduct(String name, String description, String dosage, String brand,
                                String price, String stock);
    }

    //TODO: Arreglar y buscar una solucion mejor
    class ErrorResource {
        public String resourceErrorMessage;
        public int viewIdErrorMessage;
        public ErrorResource(String resourceErrorMessage, int viewIdErrorMessage) {
            this.resourceErrorMessage = resourceErrorMessage;
            this.viewIdErrorMessage = viewIdErrorMessage;
        }
    }
}
