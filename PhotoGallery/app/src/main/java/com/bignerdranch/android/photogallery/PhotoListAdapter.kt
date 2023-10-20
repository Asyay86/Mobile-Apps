package com.bignerdranch.android.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import api.GalleryItem
import coil.load
import com.bignerdranch.android.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder (
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem){
        binding.itemImageView.load(galleryItem.url) {
            placeholder(R.drawable.mai_pic)
        }
    }
}

class PhotoListAdapter (
    private val galleryItem: List<GalleryItem>
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItem[position]
        holder.bind(item)
    }

    override fun getItemCount() = galleryItem.size
}
