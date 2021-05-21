package com.maxprof90.chatlocal.presentation.injection

import android.content.Context
import android.content.SharedPreferences
import com.maxprof90.chatlocal.cache.AccountCacheImpl
import com.maxprof90.chatlocal.cache.SharedPrefsManager
import com.maxprof90.chatlocal.data.account.AccountCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}