package com.example.login
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button1=findViewById<Button>(R.id.polubienia)
        val textView1 = findViewById<TextView>(R.id.liczbapolubien)
        val button2 = findViewById<Button>(R.id.usun)
        var licznik=0
        button1.setOnClickListener {
            licznik++
            textView1.text = getString(R.string.likes_text, licznik)
        }


        button2.setOnClickListener{
           licznik--
            textView1.text=getString(R.string.likes_text, licznik)
        }
    }
}