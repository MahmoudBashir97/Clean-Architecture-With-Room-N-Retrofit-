package com.mahmoud_bashir.cawithroom_n_retrofit.domain.use_cases.local

import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.repository.local.ArticleLocalRepoI

class RemoveAllArticlesUseCase(private val repo:ArticleLocalRepoI){
    suspend operator fun invoke() = repo.removeAllFromDb()
}