package com.swakarya.museumyog.data.firebase

import android.content.SharedPreferences
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.swakarya.museumyog.app.component.SharedVariables.fullname
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            sharedPreferences.edit().putString("fullname", fullname).apply()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override fun getFullname(): String {
        return sharedPreferences.getString("fullname", "") ?: ""
    }

    override fun saveFullname(fullname: String) {
        sharedPreferences.edit().putString("fullname", fullname).apply()
    }
}