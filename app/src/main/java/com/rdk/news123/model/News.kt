package com.rdk.news123.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)