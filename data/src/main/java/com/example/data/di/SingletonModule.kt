package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.work.WorkManager
import com.example.data.utils.SharedPreferencesKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences(
            SharedPreferencesKeys.PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideWorkManager(@ApplicationContext appContext: Context): WorkManager {
        return WorkManager.getInstance(appContext)
    }

//    @Provides
//    @Singleton
//    fun providePreferencesPhotosStorage(
//        sharedPreferences: SharedPreferences,
//        @ApplicationContext appContext: Context
//    ): PreferencesPhotosStorage {
//        return PreferencesPhotosStorage(sharedPreferences, appContext)
//    }
}