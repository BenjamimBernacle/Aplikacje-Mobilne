package com.example.grawkostki
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var resetButton: Button
    private lateinit var rollResultTextView: TextView
    private lateinit var gameResultTextView: TextView
    private lateinit var diceImages: Array<ImageView>

    private var gameScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja elementów UI
        rollButton = findViewById(R.id.rollButton)
        resetButton = findViewById(R.id.resetButton)
        rollResultTextView = findViewById(R.id.rollResultTextView)
        gameResultTextView = findViewById(R.id.gameResultTextView)

        diceImages = arrayOf(
            findViewById(R.id.diceImage1),
            findViewById(R.id.diceImage2),
            findViewById(R.id.diceImage3),
            findViewById(R.id.diceImage4),
            findViewById(R.id.diceImage5)
        )

        // Ustawienie listenerów
        rollButton.setOnClickListener {
            rollDice()
        }

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    private fun rollDice() {
        val diceValues = IntArray(5)
        var rollSum = 0

        for (i in 0..4) {
            diceValues[i] = Random.nextInt(1, 7)
            rollSum += diceValues[i]
            setDiceImage(diceImages[i], diceValues[i])
        }

        // Zakładam, że algorytm to prosta suma, jeśli jest inny, dostosuj tutaj
        rollResultTextView.text = "Wynik tego losowania: $rollSum"
        gameScore += rollSum
        gameResultTextView.text = "Wynik gry: $gameScore"
    }

    private fun setDiceImage(imageView: ImageView, value: Int) {
        val drawableResource = when (value) {
            1 -> R.drawable.k1  // Załóż, że masz drawable dice1.jpg itp.
            2 -> R.drawable.k2
            3 -> R.drawable.k3
            4 -> R.drawable.k4
            5 -> R.drawable.k5
            6 -> R.drawable.k6
            else -> R.drawable.question
        }
        imageView.setImageResource(drawableResource)
    }

    private fun resetGame() {
        for (imageView in diceImages) {
            imageView.setImageResource(R.drawable.question)
        }
        gameScore = 0
        rollResultTextView.text = "Wynik tego losowania: 0"
        gameResultTextView.text = "Wynik gry: 0"
    }
}