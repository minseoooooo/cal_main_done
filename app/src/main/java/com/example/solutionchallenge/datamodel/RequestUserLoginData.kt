package com.example.solutionchallenge.datamodel

import com.google.gson.annotations.SerializedName

data class RequestUserLoginData(
    @SerializedName("accessToken")
    val accessToken : String
)
