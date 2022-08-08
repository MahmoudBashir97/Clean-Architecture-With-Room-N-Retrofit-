package com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.remote

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.remote.ArticleRepoI
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.utils.Resource
import java.lang.Exception

class ServerUseCaseGetArticle(private val articleRepoI: ArticleRepoI){
    suspend operator fun invoke():Resource<MutableList<ArticleModel>?>{
        return try{
            val data = articleRepoI.getArticlesList()
            return Resource.Success(data)
        }catch (e:Exception){
            Resource.Error(e.message.toString(),null)
        }
    }
}