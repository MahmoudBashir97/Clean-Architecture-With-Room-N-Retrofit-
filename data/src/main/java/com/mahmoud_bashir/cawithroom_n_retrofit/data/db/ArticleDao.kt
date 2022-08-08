package com.mahmoud_bashir.cawithroom_n_retrofit.data.db

import androidx.room.*
import retrofit2.http.DELETE

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articles:ArticleLocalModel)

    @Query("SELECT * FROM ArticleLocalModel order by id ASC")
    fun getAllArticles():MutableList<ArticleLocalModel>

    @Delete
    fun removeArticle(article: ArticleLocalModel)

    @Query("DELETE FROM ArticleLocalModel")
    fun removeAllFromDb()

}