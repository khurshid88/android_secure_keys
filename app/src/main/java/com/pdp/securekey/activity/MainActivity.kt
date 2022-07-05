package com.pdp.securekey.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pdp.securekey.BuildConfig
import com.pdp.securekey.R
import com.pdp.securekey.adapter.PostAdapter
import com.pdp.securekey.model.Post
import com.pdp.securekey.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel

    var serverKey = BuildConfig.SERVER_KEY

    init {
        System.loadLibrary("keys")
    }
    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        viewModel.apiPostList()

        viewModel.allPosts.observe(this, Observer {
            refreshAdapter(it)
        })

        Log.d("MainActivity", serverKey)
        Log.d("MainActivity", getPublicKey().toString())
        Log.d("MainActivity", getPrivateKey().toString())
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }
}