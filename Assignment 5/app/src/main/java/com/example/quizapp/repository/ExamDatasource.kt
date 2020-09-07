package com.example.quizapp.repository

import com.example.quizapp.data.Question

interface ExamDatasource {
    fun save(q: Question) : String?
    fun find(index: Int) : Question?
    fun edit(q: Question) : String
    fun delete(index : Int) : String
    fun findAll() : List<Question>
}