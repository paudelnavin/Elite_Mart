package com.example.quizapp.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.forEach
import androidx.core.view.iterator
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.data.Question
import com.example.quizapp.data.QuestionType
import kotlinx.android.synthetic.main.question_layout.view.*
import java.time.LocalDateTime
import java.util.zip.Inflater

class QuestionAdapter (var questions : ArrayList<Question>): RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {

    lateinit var recyclerView : RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.question_layout, parent, false)
        return QuestionHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder?.number?.text = "Question ${position + 1}"
        holder?.questionText?.text = questions[position].questionText
        when(questions[position].qType) {
            QuestionType.SINGLE_SELECT -> inflateSingleSelect(holder, position)
            QuestionType.MULTI_SELECT -> inflateMultiSelect(holder, position)
        }

        if(questions.size - 1 != position) {
            holder?.next.visibility = View.VISIBLE
            holder?.next.setOnClickListener { recyclerView.scrollToPosition(position + 1) }
            holder?.submit.visibility = View.GONE
        }

        if(position != 0) {
            holder?.back.visibility = View.VISIBLE
            holder?.back.setOnClickListener { recyclerView.scrollToPosition(position - 1) }
        }

        holder?.submit.setOnClickListener {
            var result: Int = testGrade()
            var alertDialog  = AlertDialog.Builder(it.context)
            with(alertDialog) {
                setTitle("Congratulations!")
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    setMessage("You submitted at ${LocalDateTime.now()}, You achieved ${result}%!")
                }
                show()
            }
        }

    }

    private fun testGrade() : Int {
        var result : Int = 0
        for(i in recyclerView) {
            when(i.findViewById<RadioButton>(i.radiogroup.checkedRadioButtonId).text) {
                "To create a Singleton object" -> result += 33
                "Prior accepts any object of the same type while the latter accepts any objects of multiple types" -> result += 33
            }
            if(i.checkBox1.isSelected) result += 11
            if (i.checkBox2.isSelected ) result += 11
            if(i.checkBox3.isSelected) result += 11
        }
        return result
    }


    private fun inflateSingleSelect(holder: QuestionHolder, position: Int) {
        holder?.checkGroup.visibility = View.GONE
        holder?.radiogroup.visibility = View.VISIBLE
        holder?.choice1?.text = questions[position].choices[0]
        holder?.choice2?.text = questions[position].choices[1]
        holder?.choice3?.text = questions[position].choices[2]
        holder?.reset.setOnClickListener {
            holder?.choice1.isChecked = false
            holder?.choice2.isChecked = false
            holder?.choice3.isChecked = false
        }
    }

    private fun inflateMultiSelect(holder: QuestionHolder, position: Int) {
        holder?.checkGroup.visibility = View.VISIBLE
        holder?.radiogroup.visibility = View.GONE
        holder?.checkBox1?.text = questions[position].choices[0]
        holder?.checkBox2?.text = questions[position].choices[1]
        holder?.checkBox3?.text = questions[position].choices[2]
        holder?.reset.setOnClickListener {
            holder?.checkBox1.isChecked = false
            holder?.checkBox2.isChecked = false
            holder?.checkBox3.isChecked = false
        }
    }

    override fun getItemCount(): Int = questions.size


    class QuestionHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val number: TextView =itemView.findViewById(R.id.number)
        val questionText: TextView = itemView.findViewById(R.id.question)
        val checkBox1: CheckBox = itemView.findViewById(R.id.checkBox1)
        val checkBox2: CheckBox = itemView.findViewById(R.id.checkBox2)
        val checkBox3: CheckBox = itemView.findViewById(R.id.checkBox3)
        val checkGroup: LinearLayout = itemView.findViewById(R.id.checkgroup)
        val choice1 : RadioButton = itemView.findViewById(R.id.choice1)
        val choice2 : RadioButton = itemView.findViewById(R.id.choice2)
        val choice3 : RadioButton = itemView.findViewById(R.id.choice3)
        val radiogroup : LinearLayout = itemView.findViewById(R.id.radiogroup)
        val submit : Button = itemView.findViewById(R.id.submit)
        val back : Button = itemView.findViewById(R.id.back)
        val next : Button = itemView.findViewById(R.id.next)
        val reset : Button = itemView.findViewById(R.id.reset)
    }

}