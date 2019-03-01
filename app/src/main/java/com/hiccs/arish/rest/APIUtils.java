package com.hiccs.arish.rest;

import android.util.Log;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */
public class APIUtils {
    private static final String BASE_URL = "http://localhost/hicss.php/include/";

    public static HiccsAPI getHiccsAPI() {
        HiccsAPI hiccsAPI = HiccsClient.getsRetrofit(BASE_URL).create(HiccsAPI.class);
        Log.v("server_data", "started fetching api");
        return hiccsAPI;
    }
}
