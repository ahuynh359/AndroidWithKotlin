package com.example.wordsapp.adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.DetailScreen
import com.example.wordsapp.R
import kotlinx.android.synthetic.main.words_layout.view.*

class WordsAdapter(private val context: Context): RecyclerView.Adapter<WordsAdapter.ItemViewHolder>() {


    private val items = 'A'.rangeTo('Z').toList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.words_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.button.text = items[position].toString()
        //val context = holder.button.context
        holder.button.setOnClickListener{
             val intent = Intent(context, DetailScreen::class.java)
            intent.putExtra(
                DetailScreen.LETTER,holder.button.text.toString()
            )
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val button:Button = view.buttonPanel
    }
}