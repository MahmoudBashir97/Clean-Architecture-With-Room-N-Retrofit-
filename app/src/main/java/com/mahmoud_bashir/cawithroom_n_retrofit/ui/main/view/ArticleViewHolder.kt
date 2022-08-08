package com.mahmoud_bashir.cawithroom_n_retrofit.ui.main.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_bashir.cawithroom_n_retrofit.databinding.ViewArticleItemBinding
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel

class ArticleViewHolder(itemView: ViewArticleItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    lateinit var bd :ViewArticleItemBinding
    fun bind(articleModel: ArticleModel) {
        bd = ViewArticleItemBinding.bind(itemView)

        bd.txtTitle.text = articleModel.title
    }
}