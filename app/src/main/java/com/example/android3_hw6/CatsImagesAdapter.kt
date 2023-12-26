package com.example.android3_hw6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3_hw6.databinding.ItemCatBinding

class CatsImagesAdapter(private val imagesList:List<CatImage>): RecyclerView.Adapter<CatsImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatsImagesAdapter.ViewHolder {
        val itemBinding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CatsImagesAdapter.ViewHolder, position: Int) {
        val catImage: CatImage = imagesList[position]
        (holder.binding as ItemCatBinding).apply {
            //bind model to view
            Glide.with(holder.itemView.context)
                .load(catImage.url)
                .into(ivCatImage)
            val elementNumber = position + 1
            tvImageWidth.text = "Cat number $elementNumber"
        }
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
    inner class ViewHolder(val binding: ItemCatBinding)
        :RecyclerView.ViewHolder(binding.root)
}