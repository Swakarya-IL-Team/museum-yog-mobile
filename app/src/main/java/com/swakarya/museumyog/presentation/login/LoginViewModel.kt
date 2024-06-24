package com.swakarya.museumyog.presentation.login

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swakarya.museumyog.data.firebase.AuthRepository
import com.swakarya.museumyog.data.firebase.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    private val _state = Channel<LoginState>()
    val state = _state.receiveAsFlow()

    fun loginUser(email:String, password: String, home: ()-> Unit){
       viewModelScope.launch {
           repository.loginUser(email=email,password=password).collect{result ->
               when(result){
                   is Resource.Success ->{
                       _state.send(LoginState(success = "Login berhasil!!"))
                       home()
                   }
                   is Resource.Loading ->{
                       _state.send(LoginState(loading = true))
                   }
                   is Resource.Error ->{
                       _state.send(LoginState(error = result.message))
                   }
               }
           }
       }
    }
    fun registerUser(email:String, password: String, home: ()-> Unit){
        viewModelScope.launch {
            repository.loginUser(email=email,password=password).collect{result ->
                when(result){
                    is Resource.Success ->{
                        _state.send(LoginState(success = "Registrasi Berhasil!!"))
                        home()
                    }
                    is Resource.Loading ->{
                        _state.send(LoginState(loading = true))
                    }
                    is Resource.Error ->{
                        _state.send(LoginState(error = result.message))
                    }
                }
            }
        }
    }
}