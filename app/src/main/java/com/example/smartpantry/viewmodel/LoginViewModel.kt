package com.example.smartpantry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smartpantry.data.repository.AuthenticationRepository
import com.example.smartpantry.model.User
import java.lang.Exception

class LoginViewModel : ViewModel() {

    private var repository = AuthenticationRepository()
    var user = User()

    fun login(email: String, senha: String) {

        user.email = email
        user.senha = senha
        if (!email.isNullOrEmpty()) repository.login(email, senha)

    }

    fun resetSenha(email: String){
        repository.resetSenha(email)
    }
}