package com.example.dolcecapsulas.di

import com.example.dolcecapsulas.data.repository.AuthFirebaseDataSource
import com.example.dolcecapsulas.data.repository.AuthFirebaseDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {


    @Binds
    abstract fun bindsAuthRepositoryDataSource(
        authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
    ): AuthFirebaseDataSource

}