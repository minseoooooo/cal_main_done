package com.example.solutionchallenge.datamodel

data class ResponseExerciseData(
    val status: Int,
    val data: ExerciseData //val data: MutableList<ExerciseData> 가 되어야하나.....??
)

data class ExerciseData(

    val id :Int,
    val name :String,
    val time :Int,
    val difficulty :Int,
    val description :String,
    val caution :String,
    val reference :String,
    val bookmarked :Boolean
    /*
    {
    "id": 0,
    "name": "string",
    "time": 0,
    "difficulty": 0,
    "description": "string",
    "caution": "string",
    "reference": "string",
    "bookmarked": true
  }
     */

)

