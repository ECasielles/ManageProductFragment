package com.example.usuario.manageproductsrecycler.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Product;

public class ConfirmDialog extends DialogFragment {

    private OnDeleteProductListener onDeleteProductListener;
    private Product product;

    public interface OnDeleteProductListener {
        void deleteObject(Object object);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        product = (Product) getArguments().getParcelable(IProduct.PRODUCT_KEY);
        return onCreateConfirmDialog();
    }

    public Dialog onCreateConfirmDialog() {
        final Product p = this.product;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setMessage("This is the message")
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
}
