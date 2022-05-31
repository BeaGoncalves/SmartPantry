package com.example.smartpantry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smartpantry.data.repository.AuthenticationRepository

class ResetSenhaViewModel : ViewModel() {

    private var repository = AuthenticationRepository()

    fun resetSenha(email: String){
        repository.resetSenha(email)
    }
}