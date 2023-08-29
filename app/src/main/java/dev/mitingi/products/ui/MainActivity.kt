package dev.mitingi.products.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import dev.mitingi.products.databinding.ActivityMainBinding
import dev.mitingi.products.viewmodel.DataViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val DataViewModel:DataViewModel by viewModels()
    lateinit var dataRvAdapter: DataRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        DataViewModel.fetchPosts()
        DataViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext,err,Toast.LENGTH_LONG).show()
        })
        DataViewModel.postLiveData.observe(this) {postlist ->
            binding.rvdata.layoutManager=LinearLayoutManager(this@MainActivity)
            binding.rvdata.adapter=DataRvAdapter(postlist,this)
        }
    }


}





























