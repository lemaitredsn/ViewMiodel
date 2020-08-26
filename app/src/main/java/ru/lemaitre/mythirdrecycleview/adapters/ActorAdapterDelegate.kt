package ru.lemaitre.mythirdrecycleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.lemaitre.mythirdrecycleview.Celebrity
import ru.lemaitre.mythirdrecycleview.R

class ActorAdapterDelegate (
    private val onItemClicked: (id: Long, link:String, mName:String) -> Unit,
    private val onItemClickedDelete: (position: Int) -> Unit
    ):
    AbsListItemAdapterDelegate<Celebrity.Actor, Celebrity, ActorAdapterDelegate.ActorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ActorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_actor, parent, false)
        return ActorHolder(
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
        return item is Celebrity.Actor
    }

    override fun onBindViewHolder(
        item: Celebrity.Actor,
        holder: ActorHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class ActorHolder(
        override val containerView: View,
        onItemClicked: (id: Long, link:String, mName:String) -> Unit,
        onItemClickedDelete: (position: Int) -> Unit
    ) : BaseCelebtityHolder(containerView, onItemClicked, onItemClickedDelete) {
        fun bind(actor: Celebrity.Actor) {
            bindMainInfo(actor.id,actor.name, actor.salary, actor.career, actor.avatarLink, actor.icon)
        }
    }
}