package com.rdk.news123

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rdk.news123.model.Article

class NewsAdapter(val list: List<Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text =list[position].title
        Glide.with(holder.view.context).load(list[position].urlToImage).into(holder.image)
        holder.view.setOnClickListener {
            val uri = Uri.parse(list[position].url)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.android.chrome")
            intent.data = uri
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val view = itemView
        val title = itemView.findViewById<TextView>(R.id.text)
        val image=itemView.findViewById<ImageView>(R.id.image)

        init {

        }
    }
}
