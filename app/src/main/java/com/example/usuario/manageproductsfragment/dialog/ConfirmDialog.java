package com.example.usuario.manageproductsfragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.usuario.manageproductsfragment.R;
import com.example.usuario.manageproductsfragment.interfaces.IProduct;
import com.example.usuario.manageproductsfragment.interfaces.ProductPresenter;
import com.example.usuario.manageproductsfragment.model.Product;

public class ConfirmDialog extends DialogFragment {

    private OnDeleteProductListener onDeleteProductListener;
    private Product product;
    private ProductPresenter presenter;

    public interface OnDeleteProductListener {
        void deleteProduct(Product product);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        product = (Product) getArguments().getParcelable(IProduct.PRODUCT_KEY);
        return onCreateConfirmDialog();
    }

    public void setPresenter(ProductPresenter presenter) {
        this.presenter = presenter;
    }

    public Dialog onCreateConfirmDialog() {
        final Product p = this.product;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Eliminar elemento");
        builder
                .setMessage(String.format(getContext().getResources().getString(R.id.)))
                .setCancelable(false)
                .setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton(R.string.no,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        //TODO: Terminar
        return null;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
}
