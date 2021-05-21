package com.maxprof90.chatlocal.data.account

import com.maxprof90.chatlocal.domain.type.None
import com.maxprof90.chatlocal.domain.type.exception.Either
import com.maxprof90.chatlocal.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}