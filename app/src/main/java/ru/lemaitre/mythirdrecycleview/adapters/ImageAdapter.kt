package ru.lemaitre.mythirdrecycleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image.*
import ru.lemaitre.mythirdrecycleview.Images
import ru.lemaitre.mythirdrecycleview.R

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImagesHolder>() {

    private var images = emptyList<Images>()

    fun updateImagesList(imageList: List<Images>) {
        images = imageList
    }


    class ImagesHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(imageLink: String) {
            Glide.with(itemView)
                .load(imageLink)
                .placeholder(R.drawable.ic_no_avatar)
                .into(imageViewItemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_image, parent, false)
        return ImagesHolder(
            view
        )
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        holder.bind(images[position].imageLink)
    }
}