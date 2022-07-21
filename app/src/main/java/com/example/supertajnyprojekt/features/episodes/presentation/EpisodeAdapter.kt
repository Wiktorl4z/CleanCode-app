package com.example.supertajnyprojekt.features.episodes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.supertajnyprojekt.core.adapter.BindableAdapter
import com.example.supertajnyprojekt.databinding.ItemEpisodeBinding
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BindableAdapter<EpisodeDisplayable>,
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    var listener: ((EpisodeDisplayable) -> Unit)? = null
    private val episodes = mutableListOf<EpisodeDisplayable>()

    override fun setItems(items: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) this.episodes.clear()
        this.episodes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun getItemCount() = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                binding.item = episode
                listener?.let { root.setOnClickListener { it(episode) } }
                binding.executePendingBindings()
            }
        }
    }
}