package com.example.solutionchallenge.datamodel

//PlanCalendar은 PlanToday의 List
data class ResponsePlanCalendarData(
    val status: Int,
    val data: PlanCalanderData
)

data class PlanCalanderData(
    val date: String,
    val planList: MutableList<Plan>

)


