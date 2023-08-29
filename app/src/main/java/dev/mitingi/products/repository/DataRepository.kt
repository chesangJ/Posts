package dev.mitingi.products.repository

import dev.mitingi.products.api.ApiClient
import dev.mitingi.products.api.ApiInterface
import dev.mitingi.products.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DataRepository {
    private var apiclient=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<List<Data>>{
        return withContext(Dispatchers.IO){
            apiclient.getPosts()
        }
    }

}