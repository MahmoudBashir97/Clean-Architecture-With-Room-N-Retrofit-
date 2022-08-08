package com.mahmoud_bashir.cawithroom_n_retrofit.data.di

import androidx.room.Room
import com.mahmoud_bashir.cawithroom_n_retrofit.data.api_service.apiServiceI
import com.mahmoud_bashir.cawithroom_n_retrofit.data.db.ArticleDao
import com.mahmoud_bashir.cawithroom_n_retrofit.data.db.ArticleLocalDatabase
import com.mahmoud_bashir.cawithroom_n_retrofit.data.repositories_imp.NewsRepoImp
import com.mahmoud_bashir.cawithroom_n_retrofit.data.repositories_imp.local.ArticleLocalRepo
import com.mahmoud_bashir.cawithroom_n_retrofit.data.utils.Constants
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.remote.ArticleRepoI
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.local.ArticleLocalRepoI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule= module {
    single { getRetrofitInstance() }
    single { getApiInterface(get()) }

    single<ArticleRepoI>{
        NewsRepoImp(get())
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            ArticleLocalDatabase::class.java,
            "db_article"
        ).build()
    }
    single<ArticleDao>{
        val db=get<ArticleLocalDatabase>()
        db.getDao()
    }

    single<ArticleLocalRepoI>{ ArticleLocalRepo(get()) }

}

fun getRetrofitInstance(): Retrofit {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun getApiInterface(retrofit: Retrofit):apiServiceI = retrofit.create(apiServiceI::class.java)