package com.example.intent2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            val text = intent.getStringExtra("text") ?: "No Text"
            val textSize = intent.getFloatExtra("textSize", 14f)

            val textView = findViewById<TextView>(R.id.textToDisplay)
            textView.text = text
            textView.textSize = textSize

            insets
        }

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            finish()
        }

    }
}