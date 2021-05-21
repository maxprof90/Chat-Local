package com.maxprof90.chatlocal.presentation.injection

import com.maxprof90.chatlocal.BuildConfig
import com.maxprof90.chatlocal.data.account.AccountRemote
import com.maxprof90.chatlocal.remote.account.AccountRemoteImpl
import com.maxprof90.chatlocal.remote.core.Request
import com.maxprof90.chatlocal.remote.service.ApiService
import com.maxprof90.chatlocal.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}