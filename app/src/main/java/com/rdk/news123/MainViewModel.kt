package com.rdk.news123

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rdk.news123.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.rdk.news123.repository.NewsRepository

class MainViewModel(private val newsRepository: NewsRepository) : ViewModel() {
      init {
          viewModelScope.launch(Dispatchers.IO) {
              newsRepository.getNews()
          }
      }
    val news:LiveData<News>
        get() =newsRepository.news
}