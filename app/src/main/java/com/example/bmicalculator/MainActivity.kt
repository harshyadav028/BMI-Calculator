package com.example.bmicalculator

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val weightText=findViewById<EditText>(R.id.etWeight)
        val heightText=findViewById<EditText>(R.id.etHeight)
        val calcBtn=findViewById<Button>(R.id.btnCalculate)
        val bmiText=findViewById<TextView>(R.id.tvBmi)
        val descText=findViewById<TextView>(R.id.tvDesc)
        val rangeText=findViewById<TextView>(R.id.tvRange)
        calcBtn.setOnClickListener{
            val weight=weightText.text.toString()
            val height=heightText.text.toString()
            var desc=""
            var range=""
            var color=0
            var ans=((weight.toFloat())/((height.toFloat()/100)*(height.toFloat()/100)))
            var x=String.format("%.2f",ans).toFloat()
            bmiText.text=x.toString()
            if(x<18.50){
                desc="Underweight"
                range="(Below 18.5)"
                color=R.color.underweight
            }
            else if(x in 18.50..24.99){
                desc="Normal"
                range="(18.5 - 24.9)"
                color=R.color.normal
            }
            else if(x in 24.99..29.99){
                desc="Overweight"
                range="(24.9 - 29.9)"
                color=R.color.over
            }
            else if(x>29.99){
                desc="Obese"
                range="(Above 30)"
                color=R.color.obese
            }

            descText.setTextColor(ContextCompat.getColor(this,color))
            rangeText.setTextColor(ContextCompat.getColor(this,color))
            descText.text=desc
            rangeText.text=range
        }
    }
}

