package com.example.quizapp.repository

import com.example.quizapp.data.Question
import java.lang.Exception

object ListExamDatasource : ExamDatasource {
    private var storage: MutableList<Question> = mutableListOf()

    override fun save(que: Question): String? {
        return try {
            if(!storage.contains(que)) {
                storage.add(que)
                "${storage.indexOf(que) + 1}"
            } else null
        } catch (e: Exception) {
            "Couldn't save Question"
        }
    }

    override fun find(index: Int): Question? {
        return storage[index-1]
    }

    override fun edit(que: Question): String {
        for ((index, aQuestion) in storage.withIndex()) {
            when (aQuestion.questionText) {
                que.questionText -> {
                    storage[index] = que
                    return "${index+1}"
                }
            }
        }
        return "Couldn't Edit Question"
    }

    override fun delete(index: Int): String {
        storage.removeAt(index)
        return "Couldn't Delete Question"
    }

    override fun findAll() : ArrayList<Question> { return storage as ArrayList<Question> }
}