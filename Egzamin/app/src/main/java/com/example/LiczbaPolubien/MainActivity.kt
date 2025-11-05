package com.example.LiczbaPolubien

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import androidx.core.view.isInvisible


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
        val button1 = findViewById<Button>(R.id.button)
        val polubienia = findViewById<TextView>(R.id.polubienia)
        val button2 = findViewById<Button>(R.id.button2)
        var licznik=0

        // Ustaw listener kliknięcia
        button1.setOnClickListener {
            polubienia.isInvisible=false
            licznik++
            polubienia.text = "Polubienia: "+licznik
    }
        button2.setOnClickListener {
            licznik=0
            polubienia.text = "Polubienia: "+licznik
        }
}}