package com.example.weterynarz

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.SeekBar
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val items=mutableListOf(getString(R.string.kot),getString(R.string.pies),getString(R.string.swinia))
        val seek=findViewById<SeekBar>(R.id.seekBar)
        val text=findViewById<TextView>(R.id.textView3)
        val lista=findViewById<ListView>(R.id.Lista)
        val imie=findViewById<EditText>(R.id.editTextText)
        val button=findViewById<Button>(R.id.button)
        val cel=findViewById<EditText>(R.id.editTextText2)
        val czas=findViewById<EditText>(R.id.editTextText3)
        val wizyta=findViewById<TextView>(R.id.textView4)
        var element: String? = null
        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text.text = "$progress lat"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        lista.adapter = adapter
        lista.setOnItemClickListener { parent, _, position, _ ->
            element = parent.getItemAtPosition(position) as String
            if(element=="kot")
            {
                seek.max=20
            }
            else if(element=="pies")
            {
                seek.max=18
            }
            else
            {
                seek.max=9
            }
        }

        button.setOnClickListener {
            val wartoscSuwaka=seek.progress
            val imietext=imie.text.toString()
            val celtext=cel.text.toString()
            val czastext=czas.text.toString()
            wizyta.text="Wizyta: $imietext, $element, $celtext, $czastext $wartoscSuwaka"

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}