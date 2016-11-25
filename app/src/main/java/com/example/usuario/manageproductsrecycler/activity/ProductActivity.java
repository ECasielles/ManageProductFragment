package com.example.usuario.manageproductsrecycler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.adapter.ProductAdapter;
import com.example.usuario.manageproductsrecycler.model.Product;

import static com.example.usuario.manageproductsrecycler.interfaces.IProduct.PRODUCT_KEY;

public class ProductActivity extends AppCompatActivity {

    private ProductAdapter adapter;
    private ListView listProducts;
    private static final int ADD_PRODUCT = 0;
    private static final int EDIT_PRODUCT = 1;
    private static final int REMOVE_PRODUCT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
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
                Intent intent = new Intent(ProductActivity.this, ManageProductActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, EDIT_PRODUCT);
            }
        });

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
                intent = new Intent(this, ManageProductActivity.class);
                startActivityForResult(intent, ADD_PRODUCT);
                break;
            case R.id.action_sort_alphabetically:
                adapter.sortAlphabetically();
                break;
            case R.id.action_settings_general:
                intent = new Intent(ProductActivity.this, GeneralSettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings_account:
                intent = new Intent(ProductActivity.this, AccountSettingsActivity.class);
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

    //TODO
    public void deleteObject(){ adapter.remove();}


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

    //no es necesario un onLongClickListener
    //usamos registerForContextMenuInfo(miLista)

}
