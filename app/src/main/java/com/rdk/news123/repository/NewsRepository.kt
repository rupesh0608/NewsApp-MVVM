package com.rdk.news123.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rdk.news123.api.NewsService
import com.rdk.news123.constants.AppConstants
import com.rdk.news123.model.News

class NewsRepository (private val newsService: NewsService){

    private val newsLiveData=MutableLiveData<News>()

    val news:LiveData<News>
    get() = newsLiveData
    suspend fun getNews(){
       val result=newsService.getNews(apiKey = AppConstants.API_KEY)
        if(result.body() != null){
           newsLiveData.postValue(result.body())
        }
    }
}