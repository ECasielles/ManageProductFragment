package com.example.usuario.manageproductsrecycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.manageproductsrecycler.ProductApplication;
import com.example.usuario.manageproductsrecycler.R;
import com.example.usuario.manageproductsrecycler.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Recordar que no es necesario llamar a notifyDataSetChanged después de add, insert, etc.
 * porque los métodos propios lo llaman automáticamente porque setNotifyOnChange=true
 * y se utiliza la copia local.
 */
public class ProductAdapter extends ArrayAdapter<Product> {

    private static boolean SORTED_ASC = false;

    /**
     * Se pasa como tercer parámetro en la llamada super un ArrayList
     * con los elementos del Repositorio. Se tiene una copia local
     * diferente a la del repositorio origen.
     *
     * @param context
     */
    public ProductAdapter(Context context) {
        // El ArrayList interno es igual al que se obtiene con getProducts
        super(context, R.layout.item_product,
                new ArrayList<Product>(((ProductApplication)context.getApplicationContext()).getProducts()));
    }

    // Ejemplo de método de filtrado que debe ir en el constructor
    // Con estos métodos ya empezamos a jugar con los datos del adapter
    public void addAllProducts(List<Product> origin){
        addAll();
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ProductHolder productHolder;

        if (view == null) {
            //LayoutInflater layoutInflater = (LayoutInflater.from(context));
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Se inflan tantos elementos view como tengamos
            view = layoutInflater.inflate(R.layout.item_product, null);

            productHolder = new ProductHolder();
            // Error típico de examen no igualar el imageView de la vista
            productHolder.productImage = (ImageView)view.findViewById(R.id.imageView);
            productHolder.txvName=(TextView)view.findViewById(R.id.txvItemName);
            productHolder.txvStock=(TextView)view.findViewById(R.id.txvItemStock);
            productHolder.txvPrice=(TextView)view.findViewById(R.id.txvItemPrice);

            //Aquí Lourdes nos puede poner cualquier tipo de comprobación en el examen
            //Y siempre cae en el examen

            //Si hay que hacer un filtrado de los elementos, se hará con un método propio
            //en el constructor

            view.setTag(productHolder);
        } else {
            productHolder = (ProductHolder)view.getTag();
            productHolder.productImage.setBackgroundResource(getItem(position).getmImage());
            productHolder.txvName.setText(getItem(position).getmName());
            productHolder.txvStock.setText(getItem(position).getmStock());
            productHolder.txvPrice.setText(getItem(position).getFormatedPrice());
        }

        return view;
    }
    /**
     *  Siempre que se cambien los datos en el array del adapter
     *  hay que enviar una notificación de que ha cambiado con
     *  notifyDataSetChanged();
     *
     *  El método sort, juntos con otros métodos propios,
     *  ya lo hace de forma automática.
     *  Sin embargo, nuestros métodos personalizados deben implementarlo.
     */
    public void sortAlphabetically() {
        if(SORTED_ASC) {
            sort(Product.NAME_COMPARATOR);
        } else {
            sort(Collections.<Product>reverseOrder());
        }
        //notifyDataSetChanged();
    }

    public void addProduct(Product product) {
        add(product);
        //dao.add(product);
        //notifyDataSetChanged();
    }

    class ProductHolder {

        ImageView productImage;
        TextView txvName;
        TextView txvStock;
        TextView txvPrice;

    }

}
