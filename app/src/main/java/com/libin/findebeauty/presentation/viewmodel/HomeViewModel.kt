package com.libin.findebeauty.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.model.Home
import com.libin.findebeauty.domain.usecase.GetHomePageData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomePageData: GetHomePageData,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _homeData = MutableLiveData<Resource<Home>>()
    val homeData: LiveData<Resource<Home>> get() = _homeData
    fun fetchHomePageData(lat: Double, logt: Double, lang: String, cityId: Int, all: Int) {
        getHomePageData(lat, logt, lang, cityId, all)
            .flowOn(dispatcher)
            .onEach { result ->
                _homeData.value = result
            }.launchIn(viewModelScope)
    }
}
