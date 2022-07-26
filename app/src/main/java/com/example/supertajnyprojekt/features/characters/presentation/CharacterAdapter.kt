package com.example.supertajnyprojekt.features.characters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.supertajnyprojekt.core.adapter.BindableAdapter
import com.example.supertajnyprojekt.databinding.ItemCharacterBinding
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable

class CharacterAdapter : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var listener: ((CharacterDisplayable) -> Unit)? = null
    private val characters = mutableListOf<CharacterDisplayable>()

    fun setOnCharacterClickListener(listener: (CharacterDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun setItems(items: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) this.characters.clear()
        this.characters.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            with(binding) {
                binding.character = character
                listener?.let { root.setOnClickListener { it(character) } }
                binding.executePendingBindings()
            }
        }
    }
}