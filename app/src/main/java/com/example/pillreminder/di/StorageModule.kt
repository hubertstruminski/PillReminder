package com.example.pillreminder.di

import android.content.Context
import com.example.pillreminder.MainActivity
import com.example.pillreminder.storage.GlobalPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): GlobalPreferences {

        return GlobalPreferences(context)
    }
}