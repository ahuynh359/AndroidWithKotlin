package com.example.calculatethetip

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener {
            calculateTip()
        }

        cost_of_service_edit_text.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode)
        }


    }

    private fun calculateTip() {
        val cost = cost_of_service_edit_text.text.toString().toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }
        val percent = when (radioGroup.checkedRadioButtonId) {
            R.id.twentyPercent -> 0.20
            R.id.eighteenPercent -> 0.18
            else
            -> 0.15
        }

        var tip = cost * percent
        if (switchButton.isChecked) {
            tip = ceil(tip)
        }
        displayTip(tip)

    }

    private fun displayTip(d: Double) {
        val total = NumberFormat.getCurrencyInstance().format(d)
        tipAmountTextView.text = getString(R.string.tip_amount_20_00, total)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}