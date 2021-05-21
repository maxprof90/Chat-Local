package com.maxprof90.chatlocal.presentation.injection

import android.content.Context
import com.maxprof90.chatlocal.data.account.AccountCache
import com.maxprof90.chatlocal.data.account.AccountRemote
import com.maxprof90.chatlocal.data.account.AccountRepositoryImpl
import com.maxprof90.chatlocal.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}