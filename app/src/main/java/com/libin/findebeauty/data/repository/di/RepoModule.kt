package com.libin.findebeauty.data.repository.di

import com.libin.findebeauty.data.local.PreferenceStorageManager
import com.libin.findebeauty.data.remote.ApiService
import com.libin.findebeauty.data.repository.HomeRepositoryImpl
import com.libin.findebeauty.data.repository.LoginRepositoryImpl
import com.libin.findebeauty.domain.repository.HomeRepository
import com.libin.findebeauty.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideHomeRepository(apiService: ApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(preferenceStorageManager: PreferenceStorageManager): LoginRepository {
        return LoginRepositoryImpl(preferenceStorageManager)
    }
}
