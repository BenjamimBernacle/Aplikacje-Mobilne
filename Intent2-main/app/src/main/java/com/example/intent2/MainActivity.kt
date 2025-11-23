package com.example.intent2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button3)

        val editTextText = findViewById<EditText>(R.id.textToDisplayInOtherActivity)
        val editTextSize = findViewById<EditText>(R.id.textSizeToDisplayInOtherActivity)

        button.setOnClickListener {
            val intent1 = Intent(this, Activity2::class.java)
            intent1.putExtra("text", editTextText.text.toString())
            intent1.putExtra("textSize", editTextSize.text.toString().toFloatOrNull() ?: 14f)
            startActivity(intent1)
        }

        button2.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        }
    }

    //Automatycznie włącza się gdy poajawi się return z startActivityForResult
    //requestCode - kod złapanej akcji (ten sam co przy jej wywyołaniu) - np. 100
    //resultCode - czy activity się nie wysypało np. RESULT_OK
    //data - informacje które z tego activity przyszyły np. zdjęcie
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //Wywołanie funkcji nadrzędnej (wbudowana w system)
        super.onActivityResult(requestCode, resultCode, data)

        //Sprawdzenie czy wynik dotyczy aparatu(requestCode == CAMERA_REQUEST_CODE) i czy nie mam jekiegoś błędu(resultCode == RESULT_OK)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // ?. Sprawdza czy nie null jak nie to idzie dalej
            // wyciąga zdjęcie z data tego co zwróciła nam funkcja i zapisuje jako bitmape
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageBitmap(imageBitmap)
        }
    }
}