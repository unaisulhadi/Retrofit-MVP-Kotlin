package com.hadi.retrofitmvp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hadi.retrofitmvp.R
import com.hadi.retrofitmvp.model.DataItem

class PicsAdapter(private val context: Context) : RecyclerView.Adapter<PicsAdapter.PicsViewHolder>() {

    private var picsList = mutableListOf<DataItem>()

    fun setList(list: List<DataItem>){
        picsList.clear()
        picsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PicsViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_pics,
            parent,
            false
        )
    )
    override fun getItemCount() =  picsList.size

    override fun onBindViewHolder(holder: PicsViewHolder, position: Int) {
        val picItem = picsList[position]
        holder.apply {
            ivImage.load(picItem.download_url)
            tvImageId.text = picItem.id
            tvImageSize.text = "${picItem.width} x ${picItem.height}"
            tvImageAuthor.text = picItem.author
        }
    }

    inner class PicsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val ivImage : ImageView = itemView.findViewById(R.id.ivImage)
        val tvImageId : TextView  = itemView.findViewById(R.id.tvImageId)
        val tvImageSize : TextView  = itemView.findViewById(R.id.tvImageSize)
        val tvImageAuthor : TextView  = itemView.findViewById(R.id.tvImageAuthor)

    }
}
