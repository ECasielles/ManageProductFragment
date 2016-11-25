package com.example.usuario.manageproductsrecycler.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.interfaces.IProduct;
import com.example.usuario.manageproductsrecycler.model.Error;
import com.example.usuario.manageproductsrecycler.utils.ErrorMapUtils;

public class ProductPresenter implements IProduct.Presenter, IProduct.ErrorResource {

    private final IProduct.View view;
    private Context context;
    private int validateName;
    private int validateDescription;
    private int validateDosage;
    private int validateBrand;
    private int validatePrice;
    private int validateStock;

    public ProductPresenter(IProduct.View view) {
        this.view = view;
        this.context = (Context) view;
    }

    @Override
    public IProduct.ErrorResource validateProduct(String name, String description, String dosage, String brand, String price, String stock) {
        validateName = validateString(name);
        validateDescription = validateString(description);
        validateDosage = validateString(dosage);
        validateBrand = validateString(brand);
        validatePrice = validateDouble(price);
        validateStock = validateInteger(stock);

        if (validateName == Error.OK) {
            if (validateDescription == Error.OK) {
                if (validateDosage == Error.OK) {
                    if (validateBrand == Error.OK) {
                        if(validatePrice == Error.OK) {
                            if (validateStock == Error.OK)
                                //TODO: Arreglar
                                return new IProduct.ErrorResource("",0);
                            else {
                                String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateStock));
                                return new IProduct.ErrorResource(resourceName, R.id.tilManageStock);
                            }
                        } else {
                            String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validatePrice));
                            return new IProduct.ErrorResource(resourceName, R.id.tilManagePrice);
                        }
                    } else {
                            String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateBrand));
                        return new IProduct.ErrorResource(resourceName, R.id.tilManageBrand);
                    }
                } else {
                    String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateDosage));
                    return new IProduct.ErrorResource(resourceName, R.id.tilManageDose);
                }
            } else {
                String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateDescription));
                return new IProduct.ErrorResource(resourceName, R.id.tilManageDetails);
            }
        } else {
            String resourceName = ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateName));
            return new IProduct.ErrorResource(resourceName, R.id.tilManageName);
        }

    }

    private int validateString(String string) {
        if (TextUtils.isEmpty(string))
            return Error.DATA_EMPTY;
        return Error.OK;
    }
    private int validateInteger(String string) {
        try{
            if (TextUtils.isEmpty(string))
                return Error.DATA_EMPTY;
            int value = Integer.parseInt(string);
            return Error.OK;
        }catch (Exception e) {
            return Error.INTEGER_INVALID;
        }
    }
    private int validateDouble(String string) {
        try{
            if (TextUtils.isEmpty(string))
                return Error.DATA_EMPTY;
            double value = Double.parseDouble(string);
            return Error.OK;
        }catch (Exception e) {
            return Error.DOUBLE_INVALID;
        }
    }

}
