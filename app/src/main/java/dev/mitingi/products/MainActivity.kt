package dev.mitingi.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.mitingi.products.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataRvAdapter: DataRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var datalist:List<Data> = emptyList()

        dataRvAdapter= DataRvAdapter(emptyList())

    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }
    fun fetchData(){
var apiclient=ApiClient.buildClient(ApiInterface::class.java)
        var request=apiclient.getPosts()
        request.enqueue(object :Callback<DataResponse>{
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful){
                    var data=response.body()
                    var DataRvAdapter=DataRvAdapter(data?: emptyList<Data>())
                    binding.rvdata.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.rvdata.adapter=DataRvAdapter
                    Toast.makeText(baseContext,"fetched ${data?.data} products", Toast.LENGTH_SHORT).show()


                }
                else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {

                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }
        })
    }
}

























