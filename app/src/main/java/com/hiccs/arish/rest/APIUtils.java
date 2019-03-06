package com.hiccs.arish.rest;

import android.util.Log;

import com.hiccs.arish.utils.Constants;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */
public class APIUtils {
    public static final String BASE_URL = "http://192.168.1.5:8888/hicss.php/include/";

    public static HiccsAPI getHiccsAPI() {
        HiccsAPI hiccsAPI = HiccsClient.getsRetrofit(BASE_URL).create(HiccsAPI.class);
        Log.v(Constants.NETWORK_TAG, "started fetching api");
        return hiccsAPI;
    }
}
