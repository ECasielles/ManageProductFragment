package com.example.usuario.manageproductsrecycler.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.activity.AccountSettingsActivity;
import com.example.usuario.manageproductsrecycler.activity.GeneralSettingsActivity;
import com.example.usuario.manageproductsrecycler.adapter.ProductAdapter;
import com.example.usuario.manageproductsrecycler.dialog.ConfirmDialog;
import com.example.usuario.manageproductsrecycler.model.Product;

import static android.app.Activity.RESULT_OK;

public class ListProductFragment extends Fragment implements ConfirmDialog.OnDeleteProductListener {

    private static final int ADD_PRODUCT = 0;
    private static final int EDIT_PRODUCT = 1;
    public static String PRODUCT_KEY = "product";
    private ProductAdapter adapter;
    private ListProductListener mCallBack;

    //No permitimos que un Fragment llame a otro
    //Lo va a gestionar la actividad
    interface ListProductListener {
        //En vez de devolver un objeto habla con el presentador
        //que habla con el repositorio según se le diga
        void showManageProduct(Bundle bundle);
    }

    private ListView listProducts;
    private boolean click = false;
    private TextView txvEmptyProduct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (ListProductListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getContext().toString() +
                    " ListProductListener must be implemented");
        }
    }
    @Override
    public void onDetach() {
        //Para evitar fugas de memoria desvinculo los objetos persistentes
        super.onDetach();
        //Lo que se instancia, se elimina
        mCallBack = null;
    }
    //Lo que era onCreate ahora es onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_list_products);
        listProducts = (ListView) findViewById(R.id.listActivityProducts);

        adapter = new ProductAdapter(this);
        listProducts.setAdapter(adapter);
        listProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // parent es el AdapterView del que cuelgan Spinner, Gallery, etc.
                // view es la vista presionada dentro del AdapterView desplegado
                // position es la posición seleccionada empezando en 0.
                // id depende del tipo de Adapter que use

                Bundle bundle = new Bundle();

                //Cambiamos de putSerializable a putParcelable    <-----
                bundle.putParcelable(PRODUCT_KEY, (Product)parent.getItemAtPosition(position));
                Intent intent = new Intent(ListProductFragment.this, ManageProductFragment.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, EDIT_PRODUCT);
            }
        });


        //Cuando se crea un Fragment la siguiente línea es el paso de argumentos
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_add_product:
                intent = new Intent(this, ManageProductFragment.class);
                startActivityForResult(intent, ADD_PRODUCT);
                break;
            case R.id.action_sort_alphabetically:
                adapter.sortAlphabetically();
                break;
            case R.id.action_settings_general:
                intent = new Intent(ListProductFragment.this, GeneralSettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings_account:
                intent = new Intent(ListProductFragment.this, AccountSettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ADD_PRODUCT:
                if (resultCode == RESULT_OK){
                    //Product product = (Product)data.getExtras().getParcelable(PRODUCT_KEY);
                    Product product = data.getParcelableExtra(PRODUCT_KEY);
                    ((ProductAdapter)listProducts.getAdapter()).addProduct(product);
                }
                break;
            case EDIT_PRODUCT:
                if (resultCode == RESULT_OK){
                    //Product product = (Product)data.getExtras().getParcelable(PRODUCT_KEY);
                    Product product = data.getParcelableExtra(PRODUCT_KEY);
                    ((ProductAdapter)listProducts.getAdapter()).editProduct(product);
                }
                break;
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()) {

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
        switch () {

        }
    }

    @Override
    public void deleteObject(Object object) {
        adapter.remove();
    }
}
