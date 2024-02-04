package com.example.solutionchallenge.DataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    @PrimaryKey(autoGenerate = true) // 자동으로 기본키 값 증가
    val id: Int = 0,
    val name: String,
    val time: Int,
    val difficulty: Int,
    val description: String,
    val caution: String,
    val reference: String,
    var bookmarked: Boolean
)
