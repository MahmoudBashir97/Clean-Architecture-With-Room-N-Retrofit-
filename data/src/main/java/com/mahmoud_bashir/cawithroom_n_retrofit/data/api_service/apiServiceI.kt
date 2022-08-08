package com.mahmoud_bashir.cawithroom_n_retrofit.data.api_service

import com.mahmoud_bashir.cawithroom_n_retrofit.data.models.NewsOrgResp
import com.mahmoud_bashir.cawithroom_n_retrofit.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiServiceI {
    @GET("v2/everything")
    suspend fun getLatestNews(
        @Query("q")
        company: String = "apple",
        @Query("sortBy")
        sortedBy: String = "popularity",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<NewsOrgResp>
}