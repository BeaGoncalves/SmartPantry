package com.example.smartpantry.data.repository

import android.util.Log
import com.example.smartpantry.data.firebase.FirebaseRealTimeDatabase
import com.example.smartpantry.model.User
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserRepository : FirebaseRealTimeDatabase() {

    private lateinit var database : DatabaseReference

    init {
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.i("SNAPSHOT", snapshot.value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Snapshot", error.message.toString())
            }
        })
    }

    fun salvarUser(id: String, nome: String, email: String){
//        val databaseReference: DatabaseReference =
//            FirebaseDatabase.getInstance().getReference("users").child(id).push()
//             databaseReference.child(id).child(nome).setValue(this)
        database = Firebase.database.reference
        val user = User(nome, email)
        database.child("users").child(id).setValue(user)

    }

}