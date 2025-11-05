package com.example.egzaminapp2

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        val suwak = findViewById<SeekBar>(R.id.suwak)
        val indicator = findViewById<TextView>(R.id.indicator)
        val hello = findViewById<TextView>(R.id.hello)
        val button = findViewById<Button>(R.id.button)

        indicator.text = getString(R.string.rozmiar_label, suwak.progress)
        hello.textSize = suwak.progress.toFloat()

        suwak.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                indicator.text = getString(R.string.rozmiar_label, progress)
                hello.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        suwak.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                indicator.text = getString(R.string.rozmiar_label, progress)
                hello.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        var counter = 1
        button.setOnClickListener {
            counter++
            when (counter) {
                1 -> hello.text = getString(R.string.hello_pl)
                2 -> hello.text = getString(R.string.hello_en)
                3 -> hello.text = getString(R.string.hello_es)
                else -> {
                    counter = 1
                    hello.text = getString(R.string.hello_pl)
                }
            }
        }
    }
}
