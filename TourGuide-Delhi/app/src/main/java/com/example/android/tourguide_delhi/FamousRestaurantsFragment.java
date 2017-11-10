package com.example.android.tourguide_delhi;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamousRestaurantsFragment extends Fragment {


    public FamousRestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Guide> items = new ArrayList<Guide>();
        items.add(new Guide(getString(R.string.famousRestaurantsTitle1), getString(R.string.famousRestaurantsDetails1), getString(R.string.famousRestaurantsLoc1)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle2), getString(R.string.famousRestaurantsDetails2), getString(R.string.famousRestaurantsLoc2)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle3), getString(R.string.famousRestaurantsDetails3), getString(R.string.famousRestaurantsLoc3)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle4), getString(R.string.famousRestaurantsDetails4), getString(R.string.famousRestaurantsLoc4)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle5), getString(R.string.famousRestaurantsDetails5), getString(R.string.famousRestaurantsLoc5)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle6), getString(R.string.famousRestaurantsDetails6), getString(R.string.famousRestaurantsLoc6)));
        items.add(new Guide(getString(R.string.famousRestaurantsTitle7), getString(R.string.famousRestaurantsDetails7), getString(R.string.famousRestaurantsLoc7)));

        GuideAdapter adapter = new GuideAdapter(getActivity(), items, R.color.restaurants_colorId);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Guide word = items.get(i);
                String url = word.getLocation();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
