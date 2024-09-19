package com.example.dolcecapsulas.presenter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dolcecapsulas.data.model.Capsula
import com.example.dolcecapsulas.databinding.CapsulaItemBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private var capsulasList: List<Capsula> = listOf()

    inner class MyViewHolder(val binding: CapsulaItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CapsulaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = capsulasList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val capsula = capsulasList[position]
        holder.binding.textViewName.text = capsula.name
        holder.binding.textViewDescription.text = capsula.description
    }

    fun updateList(newCapsulas: List<Capsula>) {
        capsulasList = newCapsulas
        notifyDataSetChanged()
    }
}
