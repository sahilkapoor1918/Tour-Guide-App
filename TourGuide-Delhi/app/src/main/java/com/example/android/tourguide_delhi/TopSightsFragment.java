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
public class TopSightsFragment extends Fragment {


    public TopSightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Guide> items = new ArrayList<Guide>();
        items.add(new Guide(getString(R.string.topSightsTitle1), getString(R.string.topSightsDetails1), getString(R.string.topSightsLoc1), R.drawable.red_fort));
        items.add(new Guide(getString(R.string.topSightsTitle2), getString(R.string.topSightsDetails2), getString(R.string.topSightsLoc2), R.drawable.lotus_temple));
        items.add(new Guide(getString(R.string.topSightsTitle3), getString(R.string.topSightsDetails3), getString(R.string.topSightsLoc3), R.drawable.purana_qila));
        items.add(new Guide(getString(R.string.topSightsTitle4), getString(R.string.topSightsDetails4), getString(R.string.topSightsLoc4), R.drawable.gurudwara_bangla_sahib));
        items.add(new Guide(getString(R.string.topSightsTitle5), getString(R.string.topSightsDetails5), getString(R.string.topSightsLoc5), R.drawable.rashtrapati_bhavan));
        items.add(new Guide(getString(R.string.topSightsTitle6), getString(R.string.topSightsDetails6), getString(R.string.topSightsLoc6), R.drawable.laxminarayan_temple));
        items.add(new Guide(getString(R.string.topSightsTitle7), getString(R.string.topSightsDetails7), getString(R.string.topSightsLoc7), R.drawable.parliament_house));


        GuideAdapter adapter = new GuideAdapter(getActivity(), items, R.color.top_sights_colorId);
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
