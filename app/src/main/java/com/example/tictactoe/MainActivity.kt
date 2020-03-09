package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    val currSymbol = { if (count % 2 == 0) "X" else "O" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun setStatusText() {
            statustext.text = "Spieler ${currSymbol()} ist dran"
        }

        val originalColor = field0.background
        val allFields = arrayListOf<TextView>(
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
                if (field.text.isEmpty()) {
                    field.text = currSymbol().capitalize()
                    if (field.text == "X")
                        field.setBackgroundColor(Color.GREEN)
                    else
                        field.setBackgroundColor(Color.BLUE)


                    if (hasWon()) {
                        Toast.makeText(
                            this,
                            "winner is player ${currSymbol()} after ${count + 1} rounds",
                            Toast.LENGTH_LONG
                        ).show()
                        allFields.forEach { field -> field.isClickable = false }
                    }
                    count++
                    setStatusText()

                }
            }
        }

        reset.setOnClickListener {
            allFields.forEach { field -> field.text = "" }
            count = 0
            setStatusText()
            for (field in allFields) {
                field.isClickable = true
                field.background = originalColor
            }

        }

    }

    fun checkIfThreeSame(f0: Button, f1: Button, f2: Button): Boolean {
        var currSymbol = currSymbol()
        return (f0.text == currSymbol && f1.text == currSymbol && f2.text == currSymbol)
    }

    fun hasWon(): Boolean {
        //horiz
        return (checkIfThreeSame(field0, field1, field3) ||
                checkIfThreeSame(field2, field4, field5) ||
                checkIfThreeSame(field6, field7, field8) ||
                //vert
                checkIfThreeSame(field0, field2, field6) ||
                checkIfThreeSame(field1, field4, field7) ||
                checkIfThreeSame(field3, field5, field8) ||
                //diag
                checkIfThreeSame(field0, field4, field8) ||
                checkIfThreeSame(field2, field4, field6))


    }


}
