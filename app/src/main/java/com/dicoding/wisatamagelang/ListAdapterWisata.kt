package com.dicoding.wisatamagelang

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.wisatamagelang.databinding.ItemRowWisataBinding

class ListAdapterWisata(private val listWisata: ArrayList<Wisata>): RecyclerView.Adapter<ListAdapterWisata.ListViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowWisataBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listWisata.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(
            name,
            description,
            photo) = listWisata[position]

        holder.binding.imgItemPhotoWisata.setImageResource(photo)
        holder.binding.tvItemNamaWisata.text = name
        holder.binding.tvItemDescriptionWisata.text = description

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailWisata::class.java)
            intentDetail.putExtra(DetailWisata.EXTRA_WISATA, listWisata[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }



    }

    class ListViewHolder(var binding: ItemRowWisataBinding) : RecyclerView.ViewHolder(binding.root)

}