package dev.mitingi.products.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mitingi.products.models.Data
import dev.mitingi.products.repository.DataRepository
import kotlinx.coroutines.launch

class DataViewModel:ViewModel() {
    private val dataRepo = DataRepository()
    val postLiveData = MutableLiveData<List<Data>>()
    val errLiveData = MutableLiveData<String>()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = dataRepo.getPosts()
         if (response.isSuccessful){
             val postList=response.body()?: emptyList<Data>()
             postLiveData.postValue(postList as List<Data>)
         }
            else{
                errLiveData.postValue(response.errorBody()?.string())
         }


        }
    }
}