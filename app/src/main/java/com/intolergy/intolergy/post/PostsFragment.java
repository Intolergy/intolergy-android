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
    private final String IMAGE_TEST="shorturl.at/jqrIX";
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
        
        RVAdapter adapter = new RVAdapter(fakeData());
        rv.setAdapter(adapter);
    }
    private ArrayList<Post> fakeData(){
        ArrayList<Post> posts= new ArrayList<Post>();
        posts.add(new Post(0,"La cocina de maría tiene nuevos platos para celíacos!","","brapifra",IMAGE_TEST));
        posts.add(new Post(0,"La cocina de maría tiene nuevos platos para celíacos!","","brapifra",IMAGE_TEST));
        return posts;
    }
}
