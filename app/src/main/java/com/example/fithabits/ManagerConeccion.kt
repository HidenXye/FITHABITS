package com.example.fithabits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String = ""
)

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState(isLoading = true)

            try {
                // Simula una llamada a API
                kotlinx.coroutines.delay(2000)
                if (username == "admin" && password == "1234") {
                    _loginState.value = LoginState(isSuccess = true)
                } else {
                    _loginState.value = LoginState(error = "Credenciales incorrectas")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState(error = "Error de red")
            }
        }
    }
}
