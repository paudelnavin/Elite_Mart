package com.example.quizapp.util

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class CustomLayoutManager(context: Context, orientation: Int, reverseLayout: Boolean) :
    LinearLayoutManager(context, orientation, reverseLayout) {
    override fun canScrollVertically(): Boolean {
        return false
    }

}