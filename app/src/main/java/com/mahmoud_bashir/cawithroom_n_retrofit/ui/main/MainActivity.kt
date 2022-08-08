package com.mahmoud_bashir.cawithroom_n_retrofit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahmoud_bashir.cawithroom_n_retrofit.R
import com.mahmoud_bashir.cawithroom_n_retrofit.databinding.ActivityMainBinding
import com.mahmoud_bashir.cawithroom_n_retrofit.domain.utils.Resource
import com.mahmoud_bashir.cawithroom_n_retrofit.ui.main.view.ArticleAdapter
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    lateinit var bd:ActivityMainBinding
    private val viewModel:MainViewModel by inject()
    private lateinit var article_adpt:ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bd.root)

        //initialize views
        initializeViews()
        //getDataFromServer
        fetchDataFromServer()
        //observing on local data from db
        observingLocalData()


    }

    private fun observingLocalData() {
        bd.proBar.visibility = View.VISIBLE
        viewModel.articlesLocalList.observe(this){
                list->
            if (list != null){
                viewModel.articlesLocalList.removeObservers(this)
                bd.proBar.visibility = View.GONE
                bd.recArticles.visibility = View.VISIBLE
                article_adpt.differ.submitList(list)
                bd.recArticles.adapter = article_adpt
            }

        }
    }

    private fun fetchDataFromServer() {
        viewModel.responseData.observe(this, Observer {result->
            if (result.data != null){
                Toast.makeText(this,"received : ${result.data!![0].author}",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initializeViews() {
        article_adpt = ArticleAdapter()
        bd.recArticles.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = article_adpt
        }
    }
}