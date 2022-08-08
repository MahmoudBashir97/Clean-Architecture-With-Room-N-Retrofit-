package com.mahmoud_bashir.cawithroom_n_retrofit.di

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.AddArticleUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.GetAllLocalArticlesUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.RemoveAllArticlesUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local.RemoveArticleUseCase
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.remote.ServerUseCaseGetArticle
import com.mahmoud_bashir.cawithroom_n_retrofit.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule= module {

    single { ServerUseCaseGetArticle(get()) }
    single { AddArticleUseCase(get()) }
    single { RemoveArticleUseCase(get()) }
    single { GetAllLocalArticlesUseCase(get()) }
    single { RemoveAllArticlesUseCase(get()) }


    viewModel{
        MainViewModel(androidApplication(),get(),get(),get(),get())
    }
}