package com.example.calculatethetip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener{
            calculateTip()
        }




    }

    private fun calculateTip() {
        val cost = cost_of_service.text.toString().toDoubleOrNull()
        if(cost == null || cost == 0.0){
            displayTip(0.0)
            return
        }
        val percent = when(radioGroup.checkedRadioButtonId){
            R.id.twentyPercent -> 0.20
            R.id.eighteenPercent -> 0.18 else
                ->0.15
        }

        var tip = cost*percent
        if(switchButton.isChecked){
           tip =  ceil(tip)
        }
        displayTip(tip)

    }

    private fun displayTip(d: Double) {
        val total = NumberFormat.getCurrencyInstance().format(d)
        tipAmountTextView.text = getString(R.string.tip_amount_20_00,total)
    }
}