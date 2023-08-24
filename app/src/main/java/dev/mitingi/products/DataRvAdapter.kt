package dev.mitingi.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dev.mitingi.products.databinding.DatalistBinding

class DataRvAdapter(var datalist: Any):RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
var binding=DatalistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
var data=datalist[position]
        var binding=holder.binding
        binding.tvuser.text=data.user.toString()
        binding.tvid.text=data.id.toString()
        binding.tvtitle.text=data.title
        binding.tvbody.text=data.body

    }

    override fun getItemCount(): Int {
return datalist.size
    }

}
class DataViewHolder(var binding: DatalistBinding):ViewHolder(binding.root){

}