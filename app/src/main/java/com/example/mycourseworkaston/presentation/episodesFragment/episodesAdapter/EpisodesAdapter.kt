package com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.databinding.EpisodeItemBinding
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel

class EpisodesAdapter(private val listener: ItemClickEpisode) :
    ListAdapter<EpisodeUiModel, EpisodesAdapter.EpisodeViewHolder>(EpisodeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = EpisodeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class EpisodeViewHolder(
        private val binding: EpisodeItemBinding,
        private val listener: ItemClickEpisode,

        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: EpisodeUiModel) {
            binding.apply {
                itemEpisodeName.text = episode.name
                episodeItemEpisode.text = episode.episode
                itemEpisodeAirDate.text = episode.air_date

                root.setOnClickListener { listener.onItemClick(episode) }
            }
        }
    }

    class EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeUiModel>() {
        override fun areItemsTheSame(
            oldItem: EpisodeUiModel,
            newItem: EpisodeUiModel
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: EpisodeUiModel,
            newItem: EpisodeUiModel
        ) = oldItem == newItem
    }
}