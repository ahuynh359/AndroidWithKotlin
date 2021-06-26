package com.example.alphabetwords.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetwords.R
import com.example.alphabetwords.data.Item
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(private val context:Context,private val items:List<Item>):RecyclerView.Adapter
 <RecyclerViewAdapter.ItemHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
         val view = LayoutInflater.from(parent.context).
         inflate(R.layout.item_layout,parent,false)
         return ItemHolder(view)
     }

     override fun onBindViewHolder(holder: ItemHolder, position: Int) {
         holder.textView.text = items[position].alphabetName.toString()
         holder.image.setImageResource(items[position].images)


     }

     override fun getItemCount(): Int {
         return items.size
     }

     class ItemHolder(private val view: View):RecyclerView.ViewHolder(view){
        val textView: TextView = view.textView
         val image:ImageView = view.imageView
     }

 }