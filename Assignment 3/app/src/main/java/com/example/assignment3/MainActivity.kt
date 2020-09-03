package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        val text1 = editText1.text.toString()
        val text2 = editText2.text.toString()

        if(text1 != "" && text2 != "") {
            val textView = TextView(this)
            val textView2 = TextView(this)
            textView.background = ContextCompat.getDrawable(this, R.drawable.border)
            textView2.background = ContextCompat.getDrawable(this, R.drawable.border)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                textView.setTextAppearance(R.style.textStyle)
                textView2.setTextAppearance(R.style.textStyle)
            }
            textView.text = text1
            textView2.text = text2

            val tableRow = TableRow(this)

            tableRow.addView(textView,TableRow.LayoutParams.FILL_PARENT)
            tableRow.addView(textView2,TableRow.LayoutParams.FILL_PARENT)
            table.layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.FILL_PARENT)
            table.addView(tableRow)
        }
    }
}