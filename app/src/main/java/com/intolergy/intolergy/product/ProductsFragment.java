package com.intolergy.intolergy.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intolergy.intolergy.ApiClient;
import com.intolergy.intolergy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ProductsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView rv = (RecyclerView)getView().findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(llm);

        RVAdapter adapter = null;
        try {
            adapter = new RVAdapter(getProducts());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rv.setAdapter(adapter);
    }
    private ArrayList<Product> getProducts() throws IOException, JSONException {
        JSONObject res=ApiClient.getProducts(new JSONObject());
        if(res.getBoolean("error")){
            return new ArrayList<>();
        }
        JSONArray data=res.getJSONArray("data");
        ArrayList<Product> posts= new ArrayList<>();
        posts.add(
                new Product("Zumos Pepiño",123123,"prodriguez",new String[]{"gluten", "milk"},
                        "https://s-media-cache-ak0.pinimg.com/originals/47/1e/88/471e884a07506acb72bef98b787aef1e.jpg",
                        12340, 300));
        for(int i=0;i<data.length();i++){
            JSONObject p=data.getJSONObject(i);
            if(p.getInt("id")==1){
                continue;
            }
            posts.add(new Product(p.getString("name"),p.getInt("gtin"),p.getString("fk_user"),p.getString("intolerances").split(","),p.getString("image")
            ,13992,33));
        }
        posts.add(
                new Product("Patatas de bolsa Paquita",123123,"jlugo",new String[]{"gluten", "milk"},null,20133, 143));
        JSONObject query=new JSONObject();
        query.put("q","nutella");
        data=ApiClient.getProductsCarrefour(query).getJSONArray("data");
        for(int i=0;i<data.length();i++){
            JSONObject p=data.getJSONObject(i);
            posts.add(new Product(p.getString("name"),1234567,"nouteiral",new String[]{"gluten", "lactose"},null,14852,102));
        }
        return posts;
    }
}
