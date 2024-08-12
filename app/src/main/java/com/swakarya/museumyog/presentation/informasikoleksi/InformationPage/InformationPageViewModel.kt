package com.swakarya.museumyog.presentation.informasikoleksi.InformationPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swakarya.museumyog.data.local.entity.Museum
import com.swakarya.museumyog.domain.repository.MuseumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationPageViewModel @Inject constructor(
    private val repository: MuseumRepository
) : ViewModel() {
    private val _museum = MutableStateFlow<Museum?>(null)
    val museum: StateFlow<Museum?> = _museum

    fun loadMuseum(id: Int) {
        viewModelScope.launch {
            _museum.value = repository.getMuseumById(id)
        }
    }
}