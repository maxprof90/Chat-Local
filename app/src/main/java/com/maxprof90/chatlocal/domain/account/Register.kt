package com.maxprof90.chatlocal.domain.account

import com.maxprof90.chatlocal.domain.interactor.UseCase
import com.maxprof90.chatlocal.domain.type.None
import com.maxprof90.chatlocal.domain.type.exception.Either
import com.maxprof90.chatlocal.domain.type.exception.Failure
import javax.inject.Inject

class Register @Inject constructor(
    private val repository: AccountRepository
) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}