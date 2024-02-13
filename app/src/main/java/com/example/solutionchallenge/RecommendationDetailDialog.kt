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


class RecommendationDetailDialog(context: Context, private val exercise: Exercise) : Dialog(context) {




    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recommendation_detail_dialog)

        var toCalendarButton : Button = findViewById(R.id.ToCalendarButton)
        var closeButton : Button = findViewById(R.id.CloseButton)
        var name : TextView = findViewById(R.id.RecommendNameTextView)
        var time : TextView = findViewById(R.id.RecommendTimeValue)
        var difficulty : TextView = findViewById(R.id.RecommendDifficultyValue)
        var description : TextView = findViewById(R.id.RecommendDescriptionValue)
        var caution : TextView = findViewById(R.id.RecommendCautionValue)
        var reference : TextView = findViewById(R.id.RecommendReferenceValue)

        name.text = exercise.name
        time.text = exercise.time.toString()
        difficulty.text = exercise.difficulty.toString()
        description.text = exercise.description
        caution.text = exercise.caution
        reference.text = exercise.reference



        window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))


        // 닫기 버튼 클릭 시 종료
        closeButton.setOnClickListener { dismiss()}
    }
}