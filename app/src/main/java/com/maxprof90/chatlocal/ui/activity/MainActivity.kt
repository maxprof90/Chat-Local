package com.maxprof90.chatlocal.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.maxprof90.chatlocal.R
import com.maxprof90.chatlocal.cache.AccountCacheImpl
import com.maxprof90.chatlocal.cache.SharedPrefsManager
import com.maxprof90.chatlocal.data.account.AccountRepositoryImpl
import com.maxprof90.chatlocal.domain.account.AccountRepository
import com.maxprof90.chatlocal.domain.account.Register
import com.maxprof90.chatlocal.remote.account.AccountRemoteImpl
import com.maxprof90.chatlocal.remote.core.NetworkHandler
import com.maxprof90.chatlocal.remote.core.Request
import com.maxprof90.chatlocal.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("123456")

        val register = Register(accountRepository)
        register(Register.Params("abg5cd@m.com", "abg5cd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}