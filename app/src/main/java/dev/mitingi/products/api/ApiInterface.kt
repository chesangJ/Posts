package dev.mitingi.products.api

import dev.mitingi.products.models.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts():Response<List<Data>>


}