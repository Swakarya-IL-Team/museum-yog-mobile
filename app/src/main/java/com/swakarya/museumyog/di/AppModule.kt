package com.swakarya.museumyog.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.auth.FirebaseAuth
import com.swakarya.museumyog.data.firebase.AuthRepository
import com.swakarya.museumyog.data.firebase.AuthRepositoryImpl
import com.swakarya.museumyog.data.local.MuseumDatabase
import com.swakarya.museumyog.data.repository.MuseumRepositoryImpl
import com.swakarya.museumyog.domain.repository.MuseumRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth, sharedPreferences: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        coroutineScope: CoroutineScope
    ): MuseumDatabase {
        return MuseumDatabase.getDatabase(context, coroutineScope)
    }

    @Provides
    @Singleton
    fun provideMuseumDao(db: MuseumDatabase) = db.museumDao()

    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMuseumRepository(
        museumRepositoryImpl: MuseumRepositoryImpl
    ): MuseumRepository
}