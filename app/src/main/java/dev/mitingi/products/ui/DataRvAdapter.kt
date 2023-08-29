package dev.mitingi.products.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dev.mitingi.products.models.Data
import dev.mitingi.products.databinding.DatalistBinding

class DataRvAdapter(var postlist:List<Data>,var context: Context):RecyclerView.Adapter<DataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var binding=DatalistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        var posts=postlist[position]
        var binding=holder.binding
        binding.tvuser.text=posts.user.toString()
        binding.tvid.text=posts.id.toString()
        binding.tvtitle.text=posts.title
        binding.tvbody.text=posts.body

    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}
class DataViewHolder(var binding: DatalistBinding):ViewHolder(binding.root){

}