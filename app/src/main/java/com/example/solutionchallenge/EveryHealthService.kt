package com.example.solutionchallenge

import com.example.solutionchallenge.datamodel.RequestUserInfoData
import com.example.solutionchallenge.datamodel.RequestUserLoginData
import com.example.solutionchallenge.datamodel.ResponseUserInfoData
import com.example.solutionchallenge.datamodel.ResponseUserLoginData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface EveryHealthService { //로그인시 사용
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postUserLogin(@Body body: RequestUserLoginData):
            Call<ResponseUserLoginData>

    //@Header("Authorization: your auth token")
    @Headers("Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwidHlwZSI6ImFjY2VzcyIsImlhdCI6MTcwODAxMDYzMCwiZXhwIjoxNzA4MDk3MDMwfQ.3ekTZY7dCWjxuWuPiztiTnqDFVDh5uzNq4wEJ5_6TcTkJKXf3aQfYI-oJiFnBxOTR3OlA8Idl4I9v97K8vSSKQ")
    @POST("user/info")
    fun postUserInfo(
        @Body body : RequestUserInfoData
    ) : Call<ResponseUserInfoData>

}