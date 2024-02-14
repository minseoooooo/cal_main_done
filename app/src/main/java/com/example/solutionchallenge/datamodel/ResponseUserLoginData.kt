package com.example.solutionchallenge.datamodel

data class ResponseUserLoginData(
    val status: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val accessToken: String,
        val member: Boolean
    )
}



