package com.example.zamin.dictionary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zamin.dictionary.R
import com.example.zamin.dictionary.databinding.ItemMainRecBinding


class AdapterMain(val listener:ItemClick) : RecyclerView.Adapter<AdapterMain.VH>() {

    interface ItemClick{
        fun clickItem(item: String)
    }
    private var list: MutableList<String> = mutableListOf()

    inner class VH(val item: View) : RecyclerView.ViewHolder(item) {
        private val bind = ItemMainRecBinding.bind(item)
        fun bind(s: String) {
            bind.txt.text = s
            item.setOnClickListener {
                listener.clickItem(s)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_rec, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: MutableList<String>) {
        this.list = list
        notifyDataSetChanged()
    }
}