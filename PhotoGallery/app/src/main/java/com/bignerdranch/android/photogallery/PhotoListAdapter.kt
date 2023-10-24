package com.bignerdranch.android.photogallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import api.GalleryItem
import coil.load
import com.bignerdranch.android.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder (
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem, onItemClicked: (Uri) -> Unit){
        binding.itemImageView.load(galleryItem.url) {
            placeholder(R.drawable.mai_pic)
        }
        binding.root.setOnClickListener { onItemClicked(galleryItem.photoPageUri) }
    }
}

class PhotoListAdapter (
    private val galleryItem: List<GalleryItem>,
    private val onItemClicked: (Uri) -> Unit

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
        holder.bind(item, onItemClicked)
    }

    override fun getItemCount() = galleryItem.size
}
