package com.example.supertajnyprojekt.features.locations.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.supertajnyprojekt.core.adapter.BindableAdapter
import com.example.supertajnyprojekt.databinding.ItemLocationBinding
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable

class LocationAdapter : BindableAdapter<LocationDisplayable>,
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    var listener: ((LocationDisplayable) -> Unit)? = null
    private val locations = mutableListOf<LocationDisplayable>()

    fun setOnLocationClickListener(listener: (LocationDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun setItems(items: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) this.locations.clear()
        this.locations.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    override fun getItemCount() = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            with(binding) {
                binding.location = location
                listener?.let { root.setOnClickListener { it(location) } }
                binding.executePendingBindings()
            }
        }
    }
}