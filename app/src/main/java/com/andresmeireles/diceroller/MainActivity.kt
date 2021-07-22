package com.andresmeireles.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice = Dice(6)

        val rollButton = findViewById<Button>(R.id.diceButtonRoll)
        val diceImage = findViewById<ImageView>(R.id.dice)
        val diceImage2 = findViewById<ImageView>(R.id.dice2)
        rollButton.setOnClickListener {
            rollDice(diceImage, dice)
            rollDice(diceImage2, dice)
        }
    }

    private fun rollDice(diceWidget: ImageView, dice: Dice) {
        Toast.makeText(this, "dice roll!", Toast.LENGTH_SHORT).show()
        val diceNewImage = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceWidget.setImageResource(diceNewImage)
        diceWidget.contentDescription = diceNewImage.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}