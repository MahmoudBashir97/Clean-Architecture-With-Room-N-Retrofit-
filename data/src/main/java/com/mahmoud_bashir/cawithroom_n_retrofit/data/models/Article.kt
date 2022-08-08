package com.mahmoud_bashir.cawithroom_n_retrofit.data.models

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.mapper.Mapper
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import java.util.*

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
):Mapper<Article,ArticleModel>{
    override fun map(from: Article): ArticleModel =
        ArticleModel(
            id = UUID.randomUUID().toString(),
            author=author,
            content=content,
            description = description,
            publishedAt=publishedAt,
            title=title,
            url=url,
            urlToImage = urlToImage,
            sourceName = source?.name
        )
}
