package com.example.solutionchallenge

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import com.example.solutionchallenge.datamodel.Exercise

class RecommendationOfTodayDialog(context: Context, private val exercise : Exercise) : Dialog(context) {




    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recommendationoftoday_dialog)

        var toCalendarButton : Button = findViewById(R.id.ToCalendarButton)
        var closeButton : Button = findViewById(R.id.CloseButton)
        var name : TextView = findViewById(R.id.RecommendNameTextView)
        var time : TextView = findViewById(R.id.RecommendTimeValue)
        var difficulty : TextView = findViewById(R.id.RecommendDifficultyValue)



        name.text = exercise.name
        time.text = exercise.time.toString()
        difficulty.text = exercise.difficulty.toString()


        window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))


        // 닫기 버튼 클릭 시 종료
        closeButton.setOnClickListener { dismiss()}

        val toRecommendationDialogButton: Button = findViewById(R.id.ToRecommendationDialogButton)
        toRecommendationDialogButton.setOnClickListener {
            val recommendationDialog = RecommendationDetailDialog(context, exercise)
            recommendationDialog.show()
        }
    }
    }

