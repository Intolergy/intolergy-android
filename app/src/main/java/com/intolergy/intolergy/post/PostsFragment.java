package com.intolergy.intolergy.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intolergy.intolergy.R;

import java.util.ArrayList;

public class PostsFragment extends Fragment {

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

        RVAdapter adapter = new RVAdapter(getPosts());
        rv.setAdapter(adapter);
    }
    private ArrayList<Post> getPosts(){
        ArrayList<Post> posts= new ArrayList<>();
        posts.add(new Post(0,"La cocina de maría tiene nuevos platos para celíacos","","brapifra",
                "https://m.media-amazon.com/images/S/aplus-seller-content-images-us-east-1/ATVPDKIKX0DER/A2PYQNR0ZB5U8X/B074J6XBNX/x4nNci0qSbeT._UX300_TTW__.jpg"));
        posts.add(new Post(1,"Actualizados los productos de Supermercados Mariloli","","mlousada",
                "https://s-media-cache-ak0.pinimg.com/originals/47/1e/88/471e884a07506acb72bef98b787aef1e.jpg"));
        return posts;
    }
}
