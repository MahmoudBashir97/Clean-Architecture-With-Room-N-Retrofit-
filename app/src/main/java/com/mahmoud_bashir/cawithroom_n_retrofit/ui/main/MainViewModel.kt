package com.mahmoud_bashir.cawithroom_n_retrofit.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.AddArticleUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.GetAllLocalArticlesUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.RemoveAllArticlesUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.remote.ServerUseCaseGetArticle
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (app:Application,private val useCase: ServerUseCaseGetArticle,
               private val addArticleUseCase: AddArticleUseCase,
               private val getArticles: GetAllLocalArticlesUseCase,
               private val removeAll: RemoveAllArticlesUseCase
               ):AndroidViewModel(app){


    val responseData:MutableLiveData<Resource<MutableList<ArticleModel>?>> = MutableLiveData()
    val articlesLocalList:MutableLiveData<MutableList<ArticleModel>> = MutableLiveData()


    init {
        getDataFromServer()
    }

    private fun getDataFromServer()=viewModelScope.launch{
        responseData.postValue(useCase.invoke())
        insertArticles(useCase.invoke().data!!)
    }

    private fun insertArticles(articles:MutableList<ArticleModel>)=viewModelScope.launch{
        val check = removeAllFromDb().isActive
       if (check) {
           addArticleUseCase.invoke(articles)
           getAllArticles()
       }
    }

    private fun getAllArticles() = viewModelScope.launch{
        withContext(Dispatchers.IO){
            articlesLocalList.postValue(getArticles.invoke())
        }
    }

    private fun removeAllFromDb()=viewModelScope.launch{
        withContext(Dispatchers.IO){
            removeAll.invoke()
        }
    }
}