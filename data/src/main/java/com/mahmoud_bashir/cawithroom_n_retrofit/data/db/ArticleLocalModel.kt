package com.mahmoud_bashir.cawithroom_n_retrofit.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleLocalModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val sourceName: String?,
    val url: String?,
    val urlToImage: String?
)
