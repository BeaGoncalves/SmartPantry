package com.example.smartpantry.data.firebase

import android.content.ContentValues
import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

open class FirebaseRealTimeDatabase{

    val dataBase = Firebase.database
    var myRef = dataBase.getReference()


    init{
        myRef.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                Log.i("SNAPSHOT", snapshot.value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("SNAPSHOT", error.message)
            }
        })
    }


}