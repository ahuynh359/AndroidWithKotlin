package com.example.alphabetwords.model

import android.content.Context
import com.example.alphabetwords.R
import com.example.alphabetwords.data.Item

class Model( val context:Context) {
    private val imagesString = listOf(
        R.drawable.h1,
        R.drawable.h2,
        R.drawable.h3,
        R.drawable.h4,
        R.drawable.h5,
        R.drawable.h6,
        R.drawable.h7
        ,
        R.drawable.h8,
        R.drawable.h9,
        R.drawable.h10,
        R.drawable.h11,
        R.drawable.h12,
        R.drawable.h13,
        R.drawable.h14,
        R.drawable.h15
        ,
        R.drawable.h16,
        R.drawable.h17,
        R.drawable.h18,
        R.drawable.h19,
        R.drawable.h20,
        R.drawable.h21
        ,
        R.drawable.h22,
        R.drawable.h23,
        R.drawable.h24,
        R.drawable.h25,
        R.drawable.h26)

    private val alphabetString = context.resources.getStringArray(R.array.alphabet_names)

    fun loadItem():List<Item>{
       val list = mutableListOf<Item>()
        for(i in 0..25){
            list.add(Item(alphabetString[i].toString(),imagesString[i]))
        }
        return list
    }
}