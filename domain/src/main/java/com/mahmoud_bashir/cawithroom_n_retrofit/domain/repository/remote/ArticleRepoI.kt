package com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.remote

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel

interface ArticleRepoI {
    suspend fun getArticlesList():MutableList<ArticleModel>?
}