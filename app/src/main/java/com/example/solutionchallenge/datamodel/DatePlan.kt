package com.example.solutionchallenge.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class DatePlan(
    @PrimaryKey
    val date : Date,
    var planList : MutableList<Plan>
)