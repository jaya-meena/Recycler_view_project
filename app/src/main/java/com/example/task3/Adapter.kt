package com.example.task3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val listener: OnItemClickListener,
              private var items: ArrayList<Pair<String,Int>> )
    : RecyclerView.Adapter<Adapter.DataHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.item_data, parent, false)
        val viewHolder = DataHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
            val currentItem = items[position]
            holder.titleView.text = currentItem.first
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val titleView: TextView = itemView.findViewById(R.id.title)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            listener.onItemClicked(items[position].second)
        }
    }
}

interface OnItemClickListener
{
    fun onItemClicked(item: Int)

}