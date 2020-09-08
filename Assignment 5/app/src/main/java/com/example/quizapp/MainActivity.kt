package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.adapters.QuestionAdapter
import com.example.quizapp.data.Question
import com.example.quizapp.data.QuestionType
import com.example.quizapp.repository.ListExamDatasource
import com.example.quizapp.util.CustomLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.question_layout.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choice = ArrayList<String>()
        choice.add("To instantiate an object")
        choice.add("To create a Singleton object")
        choice.add("To create a Static object")

        ListExamDatasource.save(
            Question(
                "What is the use of the 'object' keyword in Kotlin?",
                choice,
                arrayListOf(2),
                QuestionType.SINGLE_SELECT
            )
        )

        val choice2 = ArrayList<String>()
        choice2.add("Object-Oriented Programming")
        choice2.add("Functional Programming")
        choice2.add("Scripting Programming")

        ListExamDatasource.save(
            Question(
                "Which of the following programming types does Kotlin support?",
                choice2,
                arrayListOf(1,2,3),
                QuestionType.MULTI_SELECT
            ))


        ListExamDatasource.save(
            Question(
                "What is the difference between List<*> and List<Any>",
                arrayListOf("Prior accepts any object of the same type while the latter accepts any objects of multiple types",
                "Prior accepts any object of multiple types while the latter accepts any objects of the same type",
                "They are the same"),
                arrayListOf(1),
                QuestionType.SINGLE_SELECT
            )
        )
        val questionSheet = sheet
        var customLayoutManager = CustomLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        questionSheet?.layoutManager = customLayoutManager
        val adapter = QuestionAdapter(ListExamDatasource.findAll())
        questionSheet.adapter = adapter

    }

}