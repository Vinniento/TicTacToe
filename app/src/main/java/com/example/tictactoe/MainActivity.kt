package com.example.tictactoe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        val allFields = arrayListOf<TextView>(field0, field1, field2, field3, field4, field5, field6, field7, field8)
        var whoseTurn = {count%2}
        fun wt() = whoseTurn ? 0 "x"
        allFields.forEach{
                field -> field.setOnClickListener {
                    field.text = "x"
                    count++

                }
        }

    }


fun setSymbol(symbol: String, position: TextView) {

    if (position.text.isBlank()) position.text = symbol
}

}
