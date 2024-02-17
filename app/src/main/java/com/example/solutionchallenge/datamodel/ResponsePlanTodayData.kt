package com.example.solutionchallenge.datamodel


data class ResponsePlanTodayData(

    val status: Int,
    val data: PlanTodayData

)


data class PlanTodayData(
    val date: String,
    val planList: MutableList<Plan>
)


/* response body 있음
[
  {
    "date": "2024-02-17",
    "planList": [
      {
        "planId": 0,
        "exerciseId": 0,
        "exerciseName": "string",
        "plannedTime": 0,
        "doneTime": 0
      }
    ]
  }
]
 */


