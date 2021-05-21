package com.maxprof90.chatlocal.domain.account

import com.maxprof90.chatlocal.domain.interactor.UseCase
import com.maxprof90.chatlocal.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}