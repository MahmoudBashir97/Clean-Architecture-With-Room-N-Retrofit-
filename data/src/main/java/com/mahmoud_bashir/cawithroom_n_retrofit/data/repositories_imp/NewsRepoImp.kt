package com.mahmoud_bashir.cawithroom_n_retrofit.data.repositories_imp

import com.mahmoud_bashir.cawithroom_n_retrofit.data.api_service.apiServiceI
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.remote.ArticleRepoI

class NewsRepoImp(private val apiServ: apiServiceI): ArticleRepoI {
    override suspend fun getArticlesList(): MutableList<ArticleModel>? {
        return apiServ.getLatestNews(pageNumber = 1).body()?.articles
            ?.map {
               it.map(it)
            }?.toMutableList()
    }
}