package com.swakarya.museumyog.presentation.ListMuseum

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
class ListMuseumViewModel @Inject constructor(
    private val repository: MuseumRepository
) : ViewModel() {
    private val _museums = MutableStateFlow<List<Museum>>(emptyList())
    val museums: StateFlow<List<Museum>> = _museums

    init {
        loadMuseums()
    }

    private fun loadMuseums() {
        viewModelScope.launch {
            _museums.value = repository.getMuseums()
        }
    }
}