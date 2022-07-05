package com.pdp.securekey.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pdp.securekey.activity.MainActivity
import com.pdp.securekey.R
import com.pdp.securekey.model.Post

class PostAdapter(var activity: MainActivity, var items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_poster_list, parent, false)
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: Post = items[position]
        if (holder is PosterViewHolder) {
            val tv_title = holder.tv_title
            val tv_body = holder.tv_body
            tv_title.setText(post.title.toUpperCase())
            tv_body.setText(post.body)
        }
    }

    inner class PosterViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tv_title: TextView
        var tv_body: TextView

        init {
            tv_title = view.findViewById(R.id.tv_title)
            tv_body = view.findViewById(R.id.tv_body)
        }
    }
}