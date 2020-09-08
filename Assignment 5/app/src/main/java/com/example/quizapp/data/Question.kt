package com.example.quizapp.data

data class Question (var questionText : String, var choices : ArrayList<String>, var answer : ArrayList<Int>, var qType : QuestionType){
}