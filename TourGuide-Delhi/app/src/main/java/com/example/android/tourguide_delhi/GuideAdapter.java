package com.example.android.tourguide_delhi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SahilKapoor on 04-11-2017.
 */

public class GuideAdapter extends ArrayAdapter<Guide> {

    private int mColorResourceId;

    public GuideAdapter(Activity context, ArrayList<Guide> guide, int colorResourceId) {
        super(context, 0, guide);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Guide currentItem = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentItem.getTitle());

        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details_text_view);
        detailsTextView.setText(currentItem.getDetail());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        //checking whether the image exits of not
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
