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
public class HistoricalMonumentsFragment extends Fragment {


    public HistoricalMonumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Guide> items = new ArrayList<Guide>();
        items.add(new Guide(getString(R.string.monumentsTitle1), getString(R.string.monumentsDetails1), getString(R.string.monumentsLoc1), R.drawable.qutb_minar));
        items.add(new Guide(getString(R.string.monumentsTitle2), getString(R.string.monumentsDetails2), getString(R.string.monumentsLoc2), R.drawable.india_gate));
        items.add(new Guide(getString(R.string.monumentsTitle3), getString(R.string.monumentsDetails3), getString(R.string.monumentsLoc3), R.drawable.tomb_of_safdar_jang));
        items.add(new Guide(getString(R.string.monumentsTitle4), getString(R.string.monumentsDetails4), getString(R.string.monumentsLoc4), R.drawable.humayuns_tomb));
        items.add(new Guide(getString(R.string.monumentsTitle5), getString(R.string.monumentsDetails5), getString(R.string.monumentsLoc5), R.drawable.tughlaqabad_fort));
        items.add(new Guide(getString(R.string.monumentsTitle6), getString(R.string.monumentsDetails6), getString(R.string.monumentsLoc6), R.drawable.tomb_of_sikandar_lodi));
        items.add(new Guide(getString(R.string.monumentsTitle7), getString(R.string.monumentsDetails7), getString(R.string.monumentsLoc7), R.drawable.raj_ghat));


        GuideAdapter adapter = new GuideAdapter(getActivity(), items, R.color.monuments_colorId);
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

    @Override
    public void onStop() {
        super.onStop();
    }
}
