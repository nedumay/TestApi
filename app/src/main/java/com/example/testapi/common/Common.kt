package com.example.testapi.common

import com.example.testapi.retrofit.RetrofitClient
import com.example.testapi.retrofit.RetrofitServices

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices: RetrofitServices
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}