package com.anayat.resultboard.view.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anayat.resultboard.model.Credential
import com.google.firebase.database.FirebaseDatabase

class LoginVM {
    val credential = Credential()
    val enableToNext: LiveData<Boolean>
        get() = _enableToNext
    private val _enableToNext = MutableLiveData<Boolean>()

    val examRoll: LiveData<String>
        get() = _examRoll
    private val _examRoll = MutableLiveData<String>()

    fun checkCredential() {
        val database = FirebaseDatabase.getInstance("https://resultboard-721d5-default-rtdb.firebaseio.com/").reference

        database.child("student").child(credential.userName).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            _examRoll.value = it.child("examRoll").value.toString()
            _enableToNext.value = true
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
            _enableToNext.value = false
        }
    }
}