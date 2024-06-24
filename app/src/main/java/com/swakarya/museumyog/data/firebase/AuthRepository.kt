package com.swakarya.museumyog.data.firebase

import kotlinx.coroutines.flow.Flow
import com.google.firebase.auth.AuthResult

interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}