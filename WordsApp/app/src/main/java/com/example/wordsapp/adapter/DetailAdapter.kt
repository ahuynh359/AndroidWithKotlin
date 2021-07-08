package com.example.wordsapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.DetailScreen
import com.example.wordsapp.R
import kotlinx.android.synthetic.main.button.view.*
import kotlinx.android.synthetic.main.words_layout.view.*

class DetailAdapter(private val context:Context,private val letterID:String):RecyclerView.Adapter<DetailAdapter.ItemViewHolder>() {

    private val stringId = context.resources.getStringArray(R.array.words).filter {
        it.startsWith(letterID,ignoreCase = true)
    }.shuffled().take(5).sorted()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.button,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = stringId[position]
        holder.button.text = item
        holder.button.setOnClickListener {
            val queryUrl : Uri = Uri.parse("${DetailScreen.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW,queryUrl)
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return stringId.size
    }

    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val button: Button = view.button

    }

}