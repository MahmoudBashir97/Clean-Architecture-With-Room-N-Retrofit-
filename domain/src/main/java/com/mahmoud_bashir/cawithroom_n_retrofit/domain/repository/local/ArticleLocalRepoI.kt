package com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.local

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel

interface ArticleLocalRepoI {
    suspend fun addArticle(articles:MutableList<ArticleModel>)
    suspend fun getAllArticles():MutableList<ArticleModel>
    suspend fun removeArticle(article:ArticleModel)
    suspend fun removeAllFromDb()
}