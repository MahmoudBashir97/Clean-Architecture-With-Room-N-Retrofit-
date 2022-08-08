package com.mahmoud_bashir.cawithroom_n_retrofit.data.models

data class NewsOrgResp(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)