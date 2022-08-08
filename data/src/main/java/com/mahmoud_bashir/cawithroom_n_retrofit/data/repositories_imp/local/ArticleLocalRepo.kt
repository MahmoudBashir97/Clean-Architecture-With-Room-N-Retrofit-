package com.mahmoud_bashir.cawithroom_n_retrofit.data.repositories_imp.local

import com.mahmoud_bashir.cawithroom_n_retrofit.data.db.ArticleLocalDatabase
import com.mahmoud_bashir.cawithroom_n_retrofit.data.db.ArticleLocalModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.local.ArticleLocalRepoI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ArticleLocalRepo(private val db:ArticleLocalDatabase):ArticleLocalRepoI {
    override suspend fun addArticle(articles: MutableList<ArticleModel>) {
       for (elem in articles){

           val oneArticle= ArticleLocalModel(
              author = elem.author,
              content = elem.content,
              description = elem.description,
              publishedAt = elem.publishedAt,
              title = elem.title,
              sourceName = elem.sourceName,
              url = elem.url,
              urlToImage = elem.urlToImage
          )
           CoroutineScope(Dispatchers.IO).launch {
               db.getDao().insertArticle(oneArticle)
           }

       }
    }

    override suspend fun getAllArticles(): MutableList<ArticleModel> {
        val result = db.getDao().getAllArticles().map { ArticleModel(
            id = it.id.toString(),
            author = it.author,
            content = it.content,
            description = it.description,
            publishedAt = it.publishedAt,
            title = it.title,
            sourceName = it.sourceName,
            url = it.url,
            urlToImage = it.urlToImage
        )}.toMutableList()

        return result
    }

    override suspend fun removeArticle(article: ArticleModel) {
        db.getDao().removeArticle(
            ArticleLocalModel(
                id = article.id.toInt(),
                author = article.author,
                content = article.content,
                description = article.description,
                publishedAt = article.publishedAt,
                title = article.title,
                sourceName = article.sourceName,
                url = article.url,
                urlToImage = article.urlToImage
            )
        )
    }

    override suspend fun removeAllFromDb() =
        db.getDao().removeAllFromDb()
}