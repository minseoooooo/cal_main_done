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

interface EveryHealthService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postUserLogin(@Body body: RequestUserLoginData):
            Call<ResponseUserLoginData>


    @POST("user/info")
    fun postUserInfo( @Header("Authorization: your auth token")
        @Body body : RequestUserInfoData
    ) : Call<ResponseUserInfoData>

}