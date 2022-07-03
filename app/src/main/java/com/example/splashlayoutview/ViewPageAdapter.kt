package com.example.splashlayoutview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bin_list_item.view.*

class ViewPagerAdapter(binList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = binList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bin.setImageResource(item[position])
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.bin_list_item, parent, false)){

        val bin = itemView.imageView_bin!!
    }


}