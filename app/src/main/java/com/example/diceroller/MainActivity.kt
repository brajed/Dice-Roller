package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

//This code allows the user to roll a dice and view it on the screen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button)

        rollButton.setOnClickListener {rollDice()}
    }

    //roll the dice and update the result to the screen
    private fun rollDice() {

        //create new dice object with side 6 and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)

        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        //find the ImageView in the layout
        val diceImage : ImageView = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource1 = when (diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

//the dice class
class Dice(private val numberSides: Int){
    //the roll function that generates the random values
    fun roll() : Int
    {
        //returns the result of random numbers starting from 1 to the number of sides
        return (1..numberSides).random()
    }
}