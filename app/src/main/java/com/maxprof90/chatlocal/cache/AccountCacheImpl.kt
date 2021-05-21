package com.maxprof90.chatlocal.cache

import com.maxprof90.chatlocal.data.account.AccountCache
import com.maxprof90.chatlocal.domain.type.None
import com.maxprof90.chatlocal.domain.type.exception.Either
import com.maxprof90.chatlocal.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) :
    AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken() as Either<Failure, String>
    }
}