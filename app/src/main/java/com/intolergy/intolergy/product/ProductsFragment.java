package com.intolergy.intolergy.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intolergy.intolergy.R;

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

        RVAdapter adapter = new RVAdapter(getProducts());
        rv.setAdapter(adapter);
    }
    private ArrayList<Product> getProducts(){
        ArrayList<Product> posts= new ArrayList<>();
        posts.add(
                new Product("Patatas de bolsa Paquita",123123,"brapifra",new String[]{"gluten", "milk"},
                "https://m.media-amazon.com/images/S/aplus-seller-content-images-us-east-1/ATVPDKIKX0DER/A2PYQNR0ZB5U8X/B074J6XBNX/x4nNci0qSbeT._UX300_TTW__.jpg",
        5, 10));
        posts.add(
                new Product("Hola",123123,"brapifra",new String[]{"gluten", "milk"},
                        "https://s-media-cache-ak0.pinimg.com/originals/47/1e/88/471e884a07506acb72bef98b787aef1e.jpg",
                        5, 10));
        return posts;
    }
}
