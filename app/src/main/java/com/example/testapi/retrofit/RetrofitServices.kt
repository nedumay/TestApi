package com.example.testapi.retrofit

import com.example.testapi.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}