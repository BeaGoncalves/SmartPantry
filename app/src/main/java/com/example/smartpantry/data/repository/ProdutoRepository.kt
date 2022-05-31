package com.example.smartpantry.data.repository

import com.example.smartpantry.data.firebase.FirebaseRealTimeDatabase
import com.example.smartpantry.model.Alimento
import com.example.smartpantry.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProdutoRepository() : FirebaseRealTimeDatabase(){

    private lateinit var database: DatabaseReference

    val firebase = FirebaseRealTimeDatabase()

    fun criarUser(id: String, nome: String, email: String){
        val user = User(nome,nome)
        database.child("user").child("id").child("name").child("email")

    }











}