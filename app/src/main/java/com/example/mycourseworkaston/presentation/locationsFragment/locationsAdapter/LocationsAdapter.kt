package com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.databinding.LocationItemBinding

class LocationsAdapter(private val listener: ItemClickLocation) :
    ListAdapter<LocationSingleRemote, LocationsAdapter.LocationViewHolder>(LocationDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationViewHolder {
        val binding = LocationItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class LocationViewHolder(
        private val binding: LocationItemBinding,
        private val listener: ItemClickLocation
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(location: LocationSingleRemote) {
            binding.apply {
                itemLocationName.text = location.name
                itemLocationType.text = location.type
                itemLocationDimension.text = location.dimension

                root.setOnClickListener { listener.onItemClick(location) }
            }
        }
    }

    class LocationDiffCallback : DiffUtil.ItemCallback<LocationSingleRemote>() {
        override fun areItemsTheSame(
            oldItem: LocationSingleRemote,
            newItem: LocationSingleRemote
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: LocationSingleRemote,
            newItem: LocationSingleRemote
        ) = oldItem == newItem
    }
}