package com.example.zmianakolorkow

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button



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
        val kolorek=findViewById<Button>(R.id.kolorek)
        val labelkolorek=findViewById<TextView>(R.id.zmiana_kolorku)
        val rozmiar=findViewById<Button>(R.id.rozmiar)
        val labelrozmiar=findViewById<TextView>(R.id.zmiana_rozmiaru)
        var liczbazmiankolorku=0
        var liczbazmianrozmiaru=0
        var licznikkoloru=0

        kolorek.setOnClickListener {
            liczbazmiankolorku++
            licznikkoloru++
//            licznikKolorku.Text="@string/licznikkolorkow"+licznikkoloru
            when(licznikkoloru) {
                1 -> {labelkolorek.setTextColor(getColor(R.color.red))
                    labelkolorek.setBackgroundColor(getColor(R.color.black))
                }
                2 -> {labelkolorek.setTextColor(getColor(R.color.black))
                    labelkolorek.setBackgroundColor(getColor(R.color.green))
                }
                3 -> {labelkolorek.setTextColor(getColor(R.color.green))
                    labelkolorek.setBackgroundColor(getColor(R.color.red))}
                else -> {
                    licznikkoloru = 0
                    labelkolorek.setTextColor(getColor(R.color.red))
                    labelkolorek.setBackgroundColor(getColor(R.color.black))
                }


        }
    }
        rozmiar.setOnClickListener {
            liczbazmianrozmiaru++
            when(liczbazmianrozmiaru) {
                1 -> labelrozmiar.setTextSize(10f)
                2 ->labelrozmiar.setTextSize(20f)
                3 -> labelrozmiar.setTextSize(30f)
            else -> {
                    liczbazmianrozmiaru = 0
                labelrozmiar.setTextSize(10f)

                }


            }

        }
}}