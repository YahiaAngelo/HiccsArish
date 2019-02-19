package com.hiccs.arish.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AbdullahAtta on 2/19/2019.
 */
public class GalleryImages implements Parcelable {
    public static final Parcelable.Creator<GalleryImages> CREATOR = new Creator<GalleryImages>() {
        @Override
        public GalleryImages createFromParcel(Parcel in) {
            return new GalleryImages(in);
        }

        @Override
        public GalleryImages[] newArray(int size) {
            return new GalleryImages[size];
        }
    };
    private String imageName;
    private String imageUrl;

    public GalleryImages(String imageName, String imageUrl) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
    }

    protected GalleryImages(Parcel in) {
        imageName = in.readString();
        imageUrl = in.readString();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageName);
        dest.writeString(imageUrl);
    }
}
