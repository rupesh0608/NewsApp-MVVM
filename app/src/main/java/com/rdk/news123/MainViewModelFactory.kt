package com.rdk.news123

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rdk.news123.repository.NewsRepository

class MainViewModelFactory(private val newsRepository: NewsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(newsRepository) as T
    }
}