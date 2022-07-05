package com.rdk.news123

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rdk.news123.api.NewsService
import com.rdk.news123.api.RetrofitHelper
import com.rdk.news123.databinding.ActivityMainBinding
import com.rdk.news123.model.Article
import com.rdk.news123.repository.NewsRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val newsService=RetrofitHelper.getInstance().create(NewsService::class.java)
        val newsRepository = NewsRepository(newsService)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(newsRepository)).get(MainViewModel::class.java)

        mainViewModel.news.observe(this) {
            val adapter = NewsAdapter(it.articles)
            binding.recyclerview.layoutManager = LinearLayoutManager(this)
            binding.recyclerview.adapter = adapter
        }
    }
}