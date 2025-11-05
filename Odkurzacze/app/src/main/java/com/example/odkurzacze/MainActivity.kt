package com.example.odkurzacze

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val pralka = findViewById<EditText>(R.id.numerpraniaedit)
        val button = findViewById<Button>(R.id.buttonPralka)
        val wynikTextView = findViewById<TextView>(R.id.numerpraniawynik) // make sure this exists in your layout
        val button2 = findViewById<Button>(R.id.button1)
        var wlaczona=true
        val textview = findViewById<TextView>(R.id.textView6)

        button.setOnClickListener {
            val wynik = pralka.text.toString().toIntOrNull() ?: 0
            if(wynik <= 12){
            wynikTextView.text = getString(R.string.score_text, wynik)
        }
            else{
                wynikTextView.text= getString(R.string.blad)
            }
        }
        button2.setOnClickListener {
            if(wlaczona)
            {
                textview.text=(getString(R.string.wylaczony))
                button2.text=(getString(R.string.wlaczonybutton))
                wlaczona=false
            }
            else{
                textview.text=(getString(R.string.wlaczony))
                button2.text=(getString(R.string.stulej))
                wlaczona=true
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}