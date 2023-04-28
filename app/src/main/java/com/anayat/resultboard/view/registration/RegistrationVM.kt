package com.anayat.resultboard.view.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anayat.resultboard.model.RegistrationInfo
import com.google.firebase.database.FirebaseDatabase

class RegistrationVM {
    val registrationInfo = RegistrationInfo()
    val enableToNext: LiveData<Boolean>
        get() = _enableToNext
    private val _enableToNext = MutableLiveData<Boolean>()

    fun doStudentRegistration() {
        val database = FirebaseDatabase.getInstance("https://resultboard-721d5-default-rtdb.firebaseio.com/").reference
        database.child("student").child(registrationInfo.userName).setValue(registrationInfo)
            .addOnSuccessListener {
                _enableToNext.value = true
            }
            .addOnFailureListener {
                _enableToNext.value = true
            }
    }
}
