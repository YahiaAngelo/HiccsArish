package com.hiccs.arish.rest;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */

import android.util.Log;

import com.hiccs.arish.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * by leveraging the singleton approach
 * this is the class that's responsible for creating
 * the HICCS retrofit client
 */
public class HiccsClient {

    private static Retrofit sRetrofit;

    public static Retrofit getsRetrofit(String baseURL) {
        if (sRetrofit == null) {
            Log.v("server_data", "Started to get Retrofit");
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    // using GsonConverterFactory to convert
                    // JSON response automatically to POGOs "models"
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        Log.v(Constants.NETWORK_TAG, "Done getting Retrofit");
        return sRetrofit;
    }
}
