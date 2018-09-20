package ibmassignment.me.com.ibmassignment.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ibmassignment.me.com.ibm_assignment.R;
import ibmassignment.me.com.ibmassignment.model.Item;

public class ItemViewModel extends ViewModel {

    private List<Item> productList;

    public List<Item> getProductList(Context ctx) {
        if (productList == null) {
            productList = loadProducts(ctx);
        }
        return productList;
    }

    private List<Item> loadProducts(Context ctx) {
        List<Item> products = new ArrayList();
        try {
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(ctx.getResources().openRawResource(R.raw.response)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            JSONArray jsonArray = new JSONArray(tokener);

            for (int index = 0; index < jsonArray.length(); index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                products.add(new Item(jsonObject.getString("title"), jsonObject.getString("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
