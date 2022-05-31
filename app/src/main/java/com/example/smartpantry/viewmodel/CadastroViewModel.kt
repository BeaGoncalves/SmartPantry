package com.example.smartpantry.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.smartpantry.data.repository.AuthenticationRepository
import com.example.smartpantry.data.repository.UserRepository
import com.example.smartpantry.model.User
import kotlinx.coroutines.flow.callbackFlow

class CadastroViewModel : ViewModel() {

    private var authenticationRepository = AuthenticationRepository()
    private var userRepository = UserRepository()
    var user = User()

    fun cadastro(email:String, senha: String, nome:String) {
        user.email = email
        user.senha = senha
        user.nome = nome
        authenticationRepository.cadastro(email, senha)

    }

  fun salvarUser(nome: String, email: String) {
        val id = authenticationRepository.getId().toString()
        user.id = id
        userRepository.salvarUser(id, nome, email)
    }
}