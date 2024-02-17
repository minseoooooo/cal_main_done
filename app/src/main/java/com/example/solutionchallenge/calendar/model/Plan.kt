
package com.example.solutionchallenge.calendar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plan(
    @PrimaryKey(autoGenerate = true)
    val planId : Int = 0,
    var check : Boolean,
    var exerciseId : Int,
    var exerciseName : String = "운동명",
    var plannedTime : Int,
    var doneTime : Int,
    var thisDate : String,
    var year : Int = thisDate.split("-")[0].toInt(),
    var month : Int = thisDate.split("-")[1].toInt(),
    var day : Int = thisDate.split("-")[2].toInt()

)