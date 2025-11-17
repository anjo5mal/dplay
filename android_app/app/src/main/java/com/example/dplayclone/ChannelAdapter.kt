package com.example.dplayclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChannelAdapter(private var items: List<Channel>, val click: (Channel) -> Unit)
    : RecyclerView.Adapter<ChannelAdapter.VH>() {
    class VH(v: View): RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.chName)
        val logo: ImageView = v.findViewById(R.id.chLogo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_channel, parent, false)
        return VH(v)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val c = items[position]
        holder.name.text = c.name
        holder.itemView.setOnClickListener { click(c) }
    }
    override fun getItemCount(): Int = items.size
    fun update(newItems: List<Channel>) { items = newItems; notifyDataSetChanged() }
}
