package com.example.mycourseworkaston.presentation.episodesFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.domain.useCase.EpisodeItemUseCase
import com.example.mycourseworkaston.domain.useCase.EpisodeListUseCase
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel
import com.example.mycourseworkaston.presentation.model.converter.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(
    private val episodeUseCase: EpisodeListUseCase,
    private val episodeItemUseCase: EpisodeItemUseCase
) : ViewModel() {

    private val episodeListMutable: MutableLiveData<List<EpisodeUiModel>> = MutableLiveData()
    val episodeList: LiveData<List<EpisodeUiModel>> = episodeListMutable

    private val isLoadingMutableEpisode: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = isLoadingMutableEpisode

    init {
        getEpisodeList()
    }

    private fun getEpisodeList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                episodeUseCase.getEpisodeList()

            }.onSuccess { response ->
                isLoadingMutableEpisode.postValue(false)
                episodeListMutable.postValue(response.map { it.toUi() })

            }.onFailure {
                isLoadingMutableEpisode.postValue(false)
                Log.d("TESTING", "${it.message}")
            }
        }

    }
}