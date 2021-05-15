package com.hadi.retrofitmvp.network

import com.hadi.retrofitmvp.model.PicsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/list")
    fun getPictures(): Call<PicsResponse>

}