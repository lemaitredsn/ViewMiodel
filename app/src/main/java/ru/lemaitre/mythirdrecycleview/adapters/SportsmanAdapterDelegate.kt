package ru.lemaitre.mythirdrecycleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.lemaitre.mythirdrecycleview.Celebrity
import ru.lemaitre.mythirdrecycleview.R

class SportsmanAdapterDelegate (
    private val onItemClicked: (id: Long, link:String, mName:String) -> Unit,
    private val onItemClickedDelete: (position: Int) -> Unit
    ):
AbsListItemAdapterDelegate<Celebrity.Sportsman, Celebrity, SportsmanAdapterDelegate.SportsmanHolder>() {

    class SportsmanHolder(
        override val containerView: View,
        onItemClicked: (id: Long, link:String, mName:String) -> Unit,
        onItemClickedDelete: (position: Int) -> Unit
    ) : BaseCelebtityHolder(containerView, onItemClicked, onItemClickedDelete) {
        fun bind(sportsman: Celebrity.Sportsman) {
            bindMainInfo(sportsman.id, sportsman.name, sportsman.salary, sportsman.career, sportsman.avatarLink, sportsman.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): SportsmanHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_sportsman, parent, false)
        return SportsmanHolder(
            view,
            onItemClicked,
            onItemClickedDelete
        )
    }

    override fun isForViewType(
        item: Celebrity,
        items: MutableList<Celebrity>,
        position: Int
    ): Boolean {
        return item is Celebrity.Sportsman
    }

    override fun onBindViewHolder(
        item: Celebrity.Sportsman,
        holder: SportsmanHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
}