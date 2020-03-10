package com.example.tictactoe

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    val currSymbol = { if (count % 2 == 0) "X" else "O" }
    var setStatusText = { statustext.text = "Spieler ${currSymbol()} ist dran" }
    var originalColor: Drawable? = null
    //so spart man sich die null checks
    //lateinit var  mp: MediaPlayer
    var mp: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        originalColor = field0.background

        val allFields = arrayListOf<Button>(
            field0,
            field1,
            field3,
            field2,
            field4,
            field5,
            field6,
            field7,
            field8
        )

        allFields.forEach { field ->
            field.setOnClickListener {
                clickOnField(field, allFields)
            }
        }

        reset(allFields)

    }

    fun clickOnField(field: Button, allFields: ArrayList<Button>) {
        if (field.text.isEmpty()) {
            field.text = currSymbol().capitalize()
            if (field.text == "X")
                field.setBackgroundResource(R.drawable.pusheen_knots)
            else
                field.setBackgroundResource(R.drawable.pusheen_crosses)

            if (hasWon()) {
                Toast.makeText(
                    this,
                    "winner is player ${currSymbol()} after ${count + 1} rounds",
                    Toast.LENGTH_LONG
                ).show()
                allFields.forEach { field -> field.isClickable = false }
                mp = MediaPlayer.create(this, R.raw.firework_finish )
                mp?.start()
            } else if (allFields.all { field.text != "" })
                Toast.makeText(this, "Unentschieden", Toast.LENGTH_LONG)
            count++
            setStatusText()
        }
    }

    fun reset(allFields: ArrayList<Button>) {
        reset.setOnClickListener {
            allFields.forEach { field -> field.text = "" }
            count = 0
            setStatusText()
            for (field in allFields) {
                field.isClickable = true
                field.background = originalColor
            }
            mp?.reset()

        }

    }

    fun checkIfThreeSame(f0: Button, f1: Button, f2: Button): Boolean {
        var currSymbol = currSymbol()
        return (f0.text == currSymbol && f1.text == currSymbol && f2.text == currSymbol)
    }

    fun hasWon(): Boolean {
        //horiz
        return (checkIfThreeSame(field0, field1, field2) ||
                checkIfThreeSame(field3, field4, field5) ||
                checkIfThreeSame(field6, field7, field8) ||
                //vert
                checkIfThreeSame(field0, field3, field6) ||
                checkIfThreeSame(field1, field4, field7) ||
                checkIfThreeSame(field2, field5, field8) ||
                //diag
                checkIfThreeSame(field0, field4, field8) ||
                checkIfThreeSame(field2, field4, field6))


    }


}
