package com.example.newsapp.domain

import java.util.Date

data class NewsItem(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String,
    val publishedAt: Date
)
