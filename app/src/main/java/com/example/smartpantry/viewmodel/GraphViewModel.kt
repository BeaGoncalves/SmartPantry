package com.example.smartpantry.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class GraphViewModel : ViewModel() {

    private val results = MutableSharedFlow<Boolean>()
    val resultStream = results.asSharedFlow()

    fun onAccept(){
        viewModelScope.launch { results.emit(true) }
    }
    fun onDecline(){
        viewModelScope.launch { results.emit(false) }
    }
}