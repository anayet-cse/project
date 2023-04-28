package com.anayat.resultboard.view.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.FirebaseDatabase

class ResultVM(examRoll: String, semester: String) {

    val result: LiveData<String>
        get() = _result
    private val _result = MutableLiveData<String>()

    init {
        fetchAllSemesterResult(examRoll, semester)
    }

    private fun fetchAllSemesterResult(examRoll: String, semester: String) {
        val database = FirebaseDatabase.getInstance("https://resultboard-721d5-default-rtdb.firebaseio.com/").reference

        database.child("result").child(examRoll).child(semester).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            _result.value = it.value.toString()
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
            //_enableToNext.value = false
        }
    }
}
