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
public class UpcomingEventsFragment extends Fragment {


    public UpcomingEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Guide> items = new ArrayList<Guide>();
        items.add(new Guide(getString(R.string.eventsTitle1), getString(R.string.eventsDetails1), getString(R.string.eventsLoc1)));
        items.add(new Guide(getString(R.string.eventsTitle2), getString(R.string.eventsDetails2), getString(R.string.eventsLoc2)));
        items.add(new Guide(getString(R.string.eventsTitle3), getString(R.string.eventsDetails3), getString(R.string.eventsLoc3)));
        items.add(new Guide(getString(R.string.eventsTitle4), getString(R.string.eventsDetails4), getString(R.string.eventsLoc4)));
        items.add(new Guide(getString(R.string.eventsTitle5), getString(R.string.eventsDetails5), getString(R.string.eventsLoc5)));
        items.add(new Guide(getString(R.string.eventsTitle6), getString(R.string.eventsDetails6), getString(R.string.eventsLoc6)));
        items.add(new Guide(getString(R.string.eventsTitle7), getString(R.string.eventsDetails7), getString(R.string.eventsLoc7)));

        GuideAdapter adapter = new GuideAdapter(getActivity(), items, R.color.events_colorId);
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
