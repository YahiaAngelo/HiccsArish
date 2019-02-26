package com.hiccs.arish.rest;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */

import com.hiccs.arish.models.news.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * this is the interface that holds all the networks call being used
 * through the entire application
 * using the Type-Safe HTTP Client "Retrofit"
 */
public interface HiccsAPI {

    @GET("news/endpoint")
    Call<List<News>> getHICCSNews();
}
