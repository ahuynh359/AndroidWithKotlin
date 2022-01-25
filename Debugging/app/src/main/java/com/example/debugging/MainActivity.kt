package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button.setOnClickListener{
            Toast.makeText(this,"Ahihi",Toast.LENGTH_LONG).show()
        }
        setContentView(R.layout.activity_main)




    }



}