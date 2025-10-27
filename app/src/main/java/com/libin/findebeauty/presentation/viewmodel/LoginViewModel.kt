package com.libin.findebeauty.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.usecase.SaveToken

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val saveTokenUseCase: SaveToken
) : ViewModel() {
    private val _onSaveToken = MutableLiveData<Resource<Unit>>()
    val onSaveToken: LiveData<Resource<Unit>> get() = _onSaveToken

    fun saveToken(token: String) {
        viewModelScope.launch {
            saveTokenUseCase(token).onEach { result ->
                _onSaveToken.value = result
            }.launchIn(viewModelScope)
        }
    }
}