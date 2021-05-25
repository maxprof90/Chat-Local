package com.maxprof90.chatlocal.ui


import android.app.Application
import com.maxprof90.chatlocal.presentation.injection.AppModule
import com.maxprof90.chatlocal.presentation.injection.CacheModule
import com.maxprof90.chatlocal.presentation.injection.RemoteModule
import com.maxprof90.chatlocal.presentation.injection.ViewModelModule
import com.maxprof90.chatlocal.ui.activity.RegisterActivity
import com.maxprof90.chatlocal.ui.fragment.RegisterFragment
import com.maxprof90.chatlocal.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)

}