package com.example.android.tourguide_delhi;

/**
 * Created by SahilKapoor on 04-11-2017.
 */

public class Guide {

    private String mTitle;
    private String mDetail;
    private String mLocation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Guide(String title, String detail, String location) {
        mTitle = title;
        mDetail = detail;
        mLocation = location;
    }

    public Guide(String title, String detail, String location, int imageId) {
        mTitle = title;
        mDetail = detail;
        mLocation = location;
        mImageResourceId = imageId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDetail() {
        return mDetail;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
