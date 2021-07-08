package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wordsapp.adapter.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail_screen.*

class DetailScreen() : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
        const val LETTER = "letter"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("Ahihi")




        val letterId = intent?.extras?.getString(LETTER).toString()
        Toast.makeText(this,letterId,Toast.LENGTH_SHORT).show()

        val recyclerView = recyclerViewDetailScreen

        recyclerView.adapter = DetailAdapter(this,letterId)
        recyclerView.setHasFixedSize(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}