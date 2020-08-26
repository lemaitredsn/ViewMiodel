package ru.lemaitre.mythirdrecycleview.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_sportsman.*
import ru.lemaitre.mythirdrecycleview.R

abstract class BaseCelebtityHolder(
    view: View,
    onItemClicked: (id: Long, link:String, mName:String) -> Unit,
    onItemClickedDelete: (position: Int) -> Unit
) : RecyclerView.ViewHolder(view), LayoutContainer {

    private var currentlyId: Long? = null
    private var link:String? = null
    private var mName:String? = null
    init {
        view.setOnClickListener {
            currentlyId?.let {
                mName?.let { it1 ->
                    link?.let { it2
                        -> onItemClicked(it, it2, it1) } }
            }
        }
        view.setOnLongClickListener {
            view ->
            adapterPosition?.let {
                onItemClickedDelete(it)
                return@setOnLongClickListener true
            }!!
        }
    }


    protected fun bindMainInfo(
        id: Long,
        name: String,
        salary: Int,
        career: String,
        avatarLink: String,
        icon: Int
    ) {
        currentlyId = id
        link = avatarLink
        mName = name
        nameTextView.text = name
        salaryTextView.text = "Зарплата $salary" +"M USD"
        careerTextView.text = career
        iconCelebrity.setImageResource(icon)
        Glide.with(itemView)
            .load(avatarLink)
            .placeholder(R.drawable.ic_no_avatar)
            .into(avatarImageView)
    }

}