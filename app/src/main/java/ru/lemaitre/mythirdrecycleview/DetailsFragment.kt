package ru.lemaitre.mythirdrecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.item_sportsman.*

class DetailsFragment: Fragment(R.layout.fragment_details) {
    private val args: DetailsFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailIdTextView.text = args.celebrityId.toString()
        Glide.with(detailFragment)
            .load(args.imageLink)
            .placeholder(R.drawable.ic_no_avatar)
            .into(detailImageView)
        detailNameId.text = args.nameDetail.toString()
    }
}