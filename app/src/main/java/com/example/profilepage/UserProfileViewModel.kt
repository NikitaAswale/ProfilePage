package com.example.profilepage

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor() : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _info = MutableStateFlow<Info?>(null)
    val info: StateFlow<Info?> = _info.asStateFlow()

    private val _nameInput = MutableStateFlow("")
    val nameInput: StateFlow<String> = _nameInput.asStateFlow()

    private val _usernameInput = MutableStateFlow("")
    val usernameInput: StateFlow<String> = _usernameInput.asStateFlow()

    private val _bioInput = MutableStateFlow("")
    val bioInput: StateFlow<String> = _bioInput.asStateFlow()

    private val _emailInput = MutableStateFlow("")
    val emailInput: StateFlow<String> = _emailInput.asStateFlow()

    private val _phonenoInput = MutableStateFlow("")
    val phonenoInput: StateFlow<String> = _phonenoInput.asStateFlow()

    init {
        fetchProfile()
    }

    fun updateName(name: String) {
        _nameInput.value = name
    }

    fun updateUserName(username: String) {
        _usernameInput.value = username
    }

    fun updateBio(bio: String) {
        _bioInput.value = bio
    }

    fun updateEmail(email: String) {
        _emailInput.value = email
    }

    fun updatePhoneno(phoneno: String) {
        _phonenoInput.value = phoneno
    }

    fun saveProfile() {
        val name = _nameInput.value.trim()
        val username = _usernameInput.value.trim()
        val bio = _bioInput.value.trim()
        val email = _emailInput.value.trim()
        val phoneno = _phonenoInput.value.trim()

//        if (name.isEmpty() || username.isEmpty() || bio.isEmpty() ||email.isEmpty()  || phoneno.isEmpty() ) {
//            _status.value = "Please fill all fields"
//            return
//        }

        val profileMap = hashMapOf(
            "name" to name,
            "username" to username,
            "bio" to bio,
            "email" to email,
            "phoneno" to phoneno
        )

        db.collection("profiles")
            .document("edit_profile")
            .set(profileMap)
            .addOnSuccessListener {
                //_status.value = "Profile saved successfully!"
                _nameInput.value = ""
                _usernameInput.value = ""
                _bioInput.value = ""
                _emailInput.value = ""
                _phonenoInput.value = ""
                fetchProfile()
            }
            .addOnFailureListener { e ->
                //_status.value = "Error: ${e.message}"
            }
    }

    fun fetchProfile() {
        db.collection("profiles")
            .document("edit_profile")
            .get()
            .addOnSuccessListener { doc ->
                val name = doc.getString("name") ?: ""
                val username = doc.getString("username") ?: ""
                val bio = doc.getString("bio") ?: ""
                val email = doc.getString("email") ?: ""
                val phoneno = doc.getString("phoneno") ?: ""
                val data =
                    Info(
                        id = doc.id,
                        name = name,
                        username = username,
                        bio = bio,
                        email = email,
                        phoneno = phoneno,
                    )


                _info.value = data
                //_status.value = null
            }
            .addOnFailureListener { e ->
                // _status.value = "Error: ${e.message}"
            }
    }
}
