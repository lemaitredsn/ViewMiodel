package ru.lemaitre.mythirdrecycleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_sportsman.*
import ru.lemaitre.mythirdrecycleview.Celebrity
import ru.lemaitre.mythirdrecycleview.R
import java.io.Serializable

class CelebrityAdapter(
//    private val onItemClicked: (position: Int) -> Unit
    private val onItemClicked: (id: Long, link:String, mName:String) -> Unit,
    private val onItemClickedDelete: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<Celebrity>(CelebrityDiffUtilCallback()) {

/*    private val differ = AsyncListDiffer<Celebrity>(
        this,
        CelebrityDiffUtilCallback()
    )*/

    //private val delegatesManager = AdapterDelegatesManager<List<Celebrity>>()

    init {
        delegatesManager
            .addDelegate(ActorAdapterDelegate(onItemClicked, onItemClickedDelete))
            .addDelegate(SportsmanAdapterDelegate(onItemClicked, onItemClickedDelete))
    }

    class CelebrityDiffUtilCallback : DiffUtil.ItemCallback<Celebrity>() {
        override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
            return when {
                oldItem is Celebrity.Actor && newItem is Celebrity.Actor -> oldItem.id == newItem.id
                oldItem is Celebrity.Sportsman && newItem is Celebrity.Sportsman -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
            return oldItem == newItem
        }

    }

/*    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(differ.currentList, position)
    }*/

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }*/

//    override fun getItemCount(): Int = differ.currentList.size

/*    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(differ.currentList, position, holder)
    }*/

/*    fun updateCelebrities(newCelebrities: List<Celebrity>) {
        differ.submitList(newCelebrities)
    }*/
}