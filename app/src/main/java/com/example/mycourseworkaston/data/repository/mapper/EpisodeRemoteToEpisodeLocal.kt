package com.example.mycourseworkaston.data.repository.mapper

import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote

class EpisodeRemoteToEpisodeLocal {
    fun mapEpisode(remoteEpisode: EpisodeSingleRemote): EpisodeLocalEntity{
        with(remoteEpisode){
            return EpisodeLocalEntity(
                id,
                air_date,
                characters,
                episode,
                name
            )
        }
    }
}