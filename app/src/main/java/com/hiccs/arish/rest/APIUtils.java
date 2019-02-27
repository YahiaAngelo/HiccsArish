package com.hiccs.arish.rest;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */
public class APIUtils {
    private static final String BASE_URL = "http://localhost/hicss.php/include/";

    public static HiccsAPI getHiccsAPI() {
        return HiccsClient.getsRetrofit(BASE_URL).create(HiccsAPI.class);
    }
}
