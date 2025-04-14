package com.example.calculator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(val items: MutableList<ItemModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.hoten
        holder.mssv.text = item.mssv
    }

    override fun getItemCount() = items.size



    inner class ItemViewHolder(itemView: View, val listener: ItemClickListener? = null): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.text_hoten)
        val mssv = itemView.findViewById<TextView>(R.id.text_mssv)
        val clearIMGV = itemView.findViewById<ImageView>(R.id.clear)
        init {
            clearIMGV.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    interface ItemClickListener {
        fun onItemClicked(position: Int)
    }
}