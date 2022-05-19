package com.example.mycourseworkaston.presentation.locationsFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.domain.useCase.LocationListUseCase
import com.example.mycourseworkaston.presentation.model.LocationUiModel
import com.example.mycourseworkaston.presentation.model.converter.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(
    private val locationUseCase: LocationListUseCase,
) : ViewModel() {

    private val locationListMutable: MutableLiveData<List<LocationUiModel>> = MutableLiveData()
    val locationList: LiveData<List<LocationUiModel>> = locationListMutable

    private val isLoadingMutableLocation: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = isLoadingMutableLocation

    init {
        getLocationList()
    }

    private fun getLocationList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                locationUseCase.getLocationList()

            }.onSuccess { response ->
                isLoadingMutableLocation.postValue(false)
                locationListMutable.postValue(response.map { it.toUi() })

            }.onFailure {
                isLoadingMutableLocation.postValue(false)
                Log.d("TESTING", "${it.message}")
            }
        }
    }
}