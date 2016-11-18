package com.example.usuario.manageproductsrecycler.legacy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.activity.AccountSettingsActivity;
import com.example.usuario.manageproductsrecycler.activity.GeneralSettingsActivity;

public class ProductsActivityRecycler extends AppCompatActivity {

    private ProductAdapterRecycler adapter;
    private RecyclerView rcvProduct;
    private static final int ADD_PRODUCT = 0;
    private static final int EDIT_PRODUCT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        adapter = new ProductAdapterRecycler(this);
        rcvProduct = (RecyclerView) findViewById(R.id.rcv_product);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        rcvProduct.setHasFixedSize(true);
        rcvProduct.setAdapter(adapter);

        //Botón
    }

    /*
     * Método que infla el menú en la Activity
     */
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
                intent = new Intent(this, AddProductActivity.class);
                startActivityForResult(intent, ADD_PRODUCT);
                break;
            case R.id.action_sort_alphabetically:
                adapter.sortAlphabetically();
                break;
            case R.id.acction_settings_general:
                intent = new Intent(ProductsActivityRecycler.this,GeneralSettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.acction_settings_account:
                intent = new Intent(ProductsActivityRecycler.this,AccountSettingsActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case ADD_PRODUCT:
                if (resultCode == RESULT_OK){

                }
                break;
            case EDIT_PRODUCT:
                break;
        }
    }
}
