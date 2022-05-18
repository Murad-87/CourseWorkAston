package com.example.mycourseworkaston.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episode_table")
    fun flowEpisode(): Flow<List<EpisodeLocalEntity>>

    @Query("SELECT * FROM episode_table WHERE id = :episodeId LIMIT 1")
    fun flowEpisodeItem(episodeId: Int): Flow<EpisodeLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeLocalEntity)
}