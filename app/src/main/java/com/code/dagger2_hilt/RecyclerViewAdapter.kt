package com.code.dagger2_hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.code.dagger2_hilt.model.RecyclerData
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>() {
    private var listData:List<RecyclerData>?=null
    fun setUpdateData(listData: List<RecyclerData>){
        this.listData = listData
    }
    class RecyclerViewViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val imageView = view.image_view
        private val name = view.tv_name
        private val description = view.tv_description
        fun bind(data: RecyclerData){
            name.text = data.name
            description.text = data.description
            Glide.with(imageView)
                .load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return RecyclerViewViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view,
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.bind(listData!![position])
    }

    override fun getItemCount(): Int {
        if (listData==null) return 0
        return listData?.size!!
    }
}