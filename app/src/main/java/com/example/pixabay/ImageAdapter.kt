package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pixabay.databinding.IemImageBinding

class ImageAdapter(val list: MutableList<ImageModel>) : Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.ImageViewHolder {
        return ImageViewHolder(
            IemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    fun addData(newData: List<ImageModel>) {
        val lastOne = list.size
        list.addAll(newData)
        notifyItemRangeInserted(lastOne, newData.size)
    }

    fun changeData(newData: List<ImageModel>) {
        list.clear()
        list.addAll(newData)
        notifyDataSetChanged()
    }


    inner class ImageViewHolder(val binding: IemImageBinding) : ViewHolder(binding.root) {
        fun onBind(model: ImageModel) {
            binding.imgView.load(model.largeImageURL)
        }
    }
}