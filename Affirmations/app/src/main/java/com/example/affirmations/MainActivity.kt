package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.affirmations.adapter.RecyclerViewAdapter
import com.example.affirmations.data.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recyclerView
        val data = DataSource().loadAffirmations()

        recyclerView.adapter= RecyclerViewAdapter(this,data)


        recyclerView.setHasFixedSize(true)
    }
}