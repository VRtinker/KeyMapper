package io.github.sds100.keymapper.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.sds100.keymapper.Selection.ISelectionProvider
import io.github.sds100.keymapper.Selection.SelectableItem
import io.github.sds100.keymapper.Selection.SelectionCallback
import io.github.sds100.keymapper.Selection.SelectionProvider

/**
 * Created by sds100 on 12/08/2018.
 */

/**
 * A RecyclerView Adapter which allows items to be selected when long pressed
 * @param T The object type for the items
 */
abstract class SelectableAdapter<T : SelectableItem, VH : SelectableAdapter<T, VH>.ViewHolder>(
        itemList: List<T> = listOf()
) : RecyclerView.Adapter<VH>(), SelectionCallback {

    val iSelectionProvider: ISelectionProvider = SelectionProvider(
            allItemIds = itemList.map { it.id }
    )

    var itemList: List<T> = listOf()
        set(value) {
            iSelectionProvider.allItemIds = value.map { it.id }
            field = value
        }

    init {
        iSelectionProvider.subscribeToSelectionEvents(this)

        this.itemList = itemList
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        //if the item is selected, highlight it by changing the state of the background Drawable
        val isSelected = iSelectionProvider.isSelected(getItemId(position))
        holder.itemView.isSelected = isSelected
    }

    override fun onItemSelected(id: Long) {
        val item = itemList.indexOfFirst { getItemId(itemList.indexOf(it)) == id }
        notifyItemChanged(item)
    }

    override fun onItemUnselected(id: Long) {
        val item = itemList.indexOfFirst { getItemId(itemList.indexOf(it)) == id }
        notifyItemChanged(item)
    }

    override fun getItemCount() = itemList.size

    override fun onSelectAll() {
        notifyDataSetChanged()
    }

    override fun onStopMultiSelect() {
        //call onBindViewHolder so the background for each item reverts to the original
        notifyDataSetChanged()
    }

    override fun onStartMultiSelect() {}

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnLongClickListener {
                if (!iSelectionProvider.inSelectingMode) {
                    iSelectionProvider.toggleSelection(getItemId(adapterPosition))
                }

                true
            }

            itemView.setOnClickListener {
                if (iSelectionProvider.inSelectingMode) {
                    iSelectionProvider.toggleSelection(getItemId(adapterPosition))
                }
            }
        }
    }
}