package com.maxprof90.chatlocal.data.account

import com.maxprof90.chatlocal.domain.account.AccountEntity
import com.maxprof90.chatlocal.domain.account.AccountRepository
import com.maxprof90.chatlocal.domain.type.None
import com.maxprof90.chatlocal.domain.type.exception.Either
import com.maxprof90.chatlocal.domain.type.exception.Failure
import com.maxprof90.chatlocal.domain.type.exception.flatMap
import java.util.*

class AccountRepositoryImpl(
    private val accountRemote: AccountRemote,
    private val accountCache: AccountCache
) : AccountRepository {

    override fun login(email: String, password: String): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Login is not supported")
    }

    override fun logout(): Either<Failure, None> {
        throw UnsupportedOperationException("Logout is not supported")
    }

    override fun register(email: String, name: String, password: String): Either<Failure, None> {
        return accountCache.getToken().flatMap {
            accountRemote.register(email, name, password, it, Calendar.getInstance().timeInMillis)
        }
    }

    override fun forgetPassword(email: String): Either<Failure, None> {
        throw UnsupportedOperationException("Password recovery is not supported")
    }


    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Get account is not supported")
    }


    override fun updateAccountToken(token: String): Either<Failure, None> {
        return accountCache.saveToken(token)
    }

    override fun updateAccountLastSeen(): Either<Failure, None> {
        throw UnsupportedOperationException("Updating last seen is not supported")
    }


    override fun editAccount(entity: AccountEntity): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Editing account is not supported")
    }
}