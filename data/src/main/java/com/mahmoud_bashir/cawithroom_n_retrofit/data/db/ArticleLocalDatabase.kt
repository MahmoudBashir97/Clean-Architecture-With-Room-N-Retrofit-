package com.mahmoud_bashir.cawithroom_n_retrofit.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleLocalModel::class], version = 1, exportSchema = false)
abstract class ArticleLocalDatabase :RoomDatabase(){
    abstract fun getDao():ArticleDao
}