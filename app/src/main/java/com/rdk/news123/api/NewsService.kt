package com.rdk.news123.api

import com.rdk.news123.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("everything?q=bitcoin")
    suspend fun getNews(
        @Query("apiKey") apiKey:String
    ): Response<News>
}