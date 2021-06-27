package com.example.alphabetwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.alphabetwords.adapter.RecyclerViewAdapter
import com.example.alphabetwords.model.Model

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initial data
        val model=  Model(this).loadItem()

        //set Adapter
        val recyclerView = recyclerView
        recyclerView.adapter = RecyclerViewAdapter(this,model,)

        val layout = GridLayoutManager(this,2)
        recyclerView.layoutManager= layout


        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)





    }


}