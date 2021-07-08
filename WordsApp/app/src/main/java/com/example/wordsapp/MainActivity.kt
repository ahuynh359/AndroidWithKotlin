package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.adapter.WordsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isLinearLayoutManager = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recyclerView
        chooseLayout()


    }

    private fun chooseLayout() {
        if (isLinearLayoutManager)
            recyclerView.layoutManager = LinearLayoutManager(this)
        else
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = WordsAdapter(this)
    }

    private fun setIcon(menuItem: MenuItem) {
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_grid_on_24)
            else
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_linear_scale_24)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        if (layoutButton != null) {
            setIcon(layoutButton)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true

            }
            else -> super.onOptionsItemSelected(item)


        }
    }


}

