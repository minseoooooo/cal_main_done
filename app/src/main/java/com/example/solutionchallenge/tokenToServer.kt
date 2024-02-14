package com.example.solutionchallenge

import android.util.Log
import com.example.solutionchallenge.activity.LogInActivity.Companion.TAG
import com.example.solutionchallenge.datamodel.RequestUserLoginData
import com.example.solutionchallenge.datamodel.ResponseUserLoginData
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class TokenToServer(private val accessToken: String) {

    var isMember = false // 기본값은 실패로 초기화


    public fun sendTokenToServer(completion: (Boolean, String?) -> Unit) {
        val requestUserLoginData = RequestUserLoginData(accessToken = accessToken)
        val call: Call<ResponseUserLoginData> =
            ServiceCreator.everyHealthService.postUserLogin(requestUserLoginData)


        call.enqueue(object : Callback<ResponseUserLoginData> {
            override fun onResponse(
                call: Call<ResponseUserLoginData>,
                response: Response<ResponseUserLoginData>
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    // 서버로부터 성공적인 응답을 받은 경우 처리
                    if (responseData != null) {
                        Log.d(TAG, "Status: ${responseData.status}")
                        Log.d(TAG, "Message: ${responseData.message}")
                        Log.d(TAG, "Access Token: ${responseData.data.accessToken}")
                        Log.d(TAG, "Is Member: ${responseData.data.member}")

                        isMember = responseData.data.member // responseData.data.member 값을 그대로 success에 대입
                        var receviedAccessToken = responseData.data.accessToken
                        completion(isMember, receviedAccessToken )

                    } else {
                        Log.d("NetworkTest","sth wrong")

                    }
                }
            }

            override fun onFailure(call: Call<ResponseUserLoginData>, t: Throwable) {
                // 통신 실패 시 처리
                Log.e("NetworkTest", "error:$t")

            }
        })
    }
}
