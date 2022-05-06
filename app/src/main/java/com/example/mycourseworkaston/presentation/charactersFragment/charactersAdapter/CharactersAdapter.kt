package com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.databinding.CharacterItemBinding

class CharactersAdapter(private val listener: ItemClickCharacter) :
    ListAdapter<CharacterSingleRemote, CharactersAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class CharacterViewHolder(
        private val binding: CharacterItemBinding,
        private val listener: ItemClickCharacter
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterSingleRemote) {
            binding.apply {
                Glide.with(itemView)
                    .load(character.image)
                    .into(characterItemImage)
                characterItemName.text = character.name
                characterItemSpecies.text = character.species
                characterItemStatus.text = character.status
                characterItemGender.text = character.status

                root.setOnClickListener { listener.onItemClick(character) }
            }
        }
    }

    class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterSingleRemote>() {
        override fun areItemsTheSame(
            oldItem: CharacterSingleRemote,
            newItem: CharacterSingleRemote
        ) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CharacterSingleRemote,
            newItem: CharacterSingleRemote
        ) =
            oldItem == newItem
    }
}