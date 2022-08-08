package com.mahmoud_bashir.cawithroom_n_retrofit.ui.main.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_bashir.cawithroom_n_retrofit.databinding.ViewArticleItemBinding
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.model.ArticleModel

class ArticleAdapter : RecyclerView.Adapter<ArticleViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<ArticleModel>(){
        override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder
    = ArticleViewHolder(ViewArticleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        Log.d("???","dataList = ${differ.currentList.size}")
    }

    override fun getItemCount(): Int= differ.currentList.size
}