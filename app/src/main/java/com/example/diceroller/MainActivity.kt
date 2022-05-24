package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        val diceRoll = dice.roll()

        //update the screen with the dice roll
        val resultView : TextView = findViewById(R.id.textView)

        resultView.text = diceRoll.toString()

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