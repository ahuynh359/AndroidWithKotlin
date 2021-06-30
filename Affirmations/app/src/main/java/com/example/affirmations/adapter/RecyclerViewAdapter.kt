package com.example.affirmations.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmations
import kotlinx.android.synthetic.main.item.view.*

class RecyclerViewAdapter(val context: Context, private val itemData: List<Affirmations>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =    LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemData[position]
        holder.textView.text = context.resources.getString(item.names)
        holder.imageView.setImageResource(item.images)
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    inner class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
            val textView : TextView = view.textView
            val imageView: ImageView = view.imageView
    }
}