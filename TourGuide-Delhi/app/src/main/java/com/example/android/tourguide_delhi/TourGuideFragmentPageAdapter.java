package com.example.android.tourguide_delhi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SahilKapoor on 04-11-2017.
 */

public class TourGuideFragmentPageAdapter extends FragmentPagerAdapter {

    Context mContext;

    public TourGuideFragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopSightsFragment();
        } else if (position == 1) {
            return new FamousRestaurantsFragment();
        } else if (position == 2) {
            return new HistoricalMonumentsFragment();
        } else {
            return new UpcomingEventsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.top_sights);
        } else if (position == 1) {
            return mContext.getString(R.string.famous_restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.historical_monuments);
        } else {
            return mContext.getString(R.string.upcoming_events);
        }
    }
}
