package com.example.quizapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.Question
import java.util.zip.Inflater

class QuestionAdapter (var questions : ArrayList<Question>): RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.question_layout, parent, false)
        return QuestionHolder(v)
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder?.number?.text = "Question ${position + 1}"
        holder?.questionText?.text = questions[position].questionText
        holder?.choice1?.text = questions[position].choices[0]
        holder?.choice2?.text = questions[position].choices[1]
        holder?.choice3?.text = questions[position].choices[2]
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    class QuestionHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val number: TextView =itemView.findViewById<TextView>(R.id.number)
        val questionText: TextView = itemView.findViewById<TextView>(R.id.question)
        val choice1 : RadioButton = itemView.findViewById<RadioButton>(R.id.choice1)
        val choice2 : RadioButton = itemView.findViewById<RadioButton>(R.id.choice2)
        val choice3 : RadioButton = itemView.findViewById<RadioButton>(R.id.choice3)
    }

}