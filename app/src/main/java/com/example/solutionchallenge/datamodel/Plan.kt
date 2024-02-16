package com.example.solutionchallenge.datamodel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Plan(
    @PrimaryKey(autoGenerate = true)
    val planId: Int, // 자동 생성
    var exerciseId : Int,
    var exerciseName : String,
    var plannedTime: Int,
    var doneTime: Int = 0 // 수행 시간, 수행 전에는 0으로 초기화

)