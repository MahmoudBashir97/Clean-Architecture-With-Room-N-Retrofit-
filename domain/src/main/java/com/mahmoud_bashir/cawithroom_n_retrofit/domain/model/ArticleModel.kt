package com.mahmoud_bashir.cawithroom_n_retrofit.domain.model

import java.io.Serializable

data class ArticleModel(
    val id: String,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val sourceName: String?,
    val url: String?,
    val urlToImage: String?
):Serializable