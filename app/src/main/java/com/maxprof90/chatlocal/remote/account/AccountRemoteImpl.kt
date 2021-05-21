package com.maxprof90.chatlocal.remote.account

import com.maxprof90.chatlocal.data.account.AccountRemote
import com.maxprof90.chatlocal.domain.type.None
import com.maxprof90.chatlocal.domain.type.exception.Either
import com.maxprof90.chatlocal.domain.type.exception.Failure
import com.maxprof90.chatlocal.remote.core.Request
import com.maxprof90.chatlocal.remote.service.ApiService
import javax.inject.Inject

class AccountRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : AccountRemote {

    override fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None> {
        return request.make(service.register(createRegisterMap(email, name, password, token, userDate))) { None() }
    }

    private fun createRegisterMap(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.PARAM_EMAIL, email)
        map.put(ApiService.PARAM_NAME, name)
        map.put(ApiService.PARAM_PASSWORD, password)
        map.put(ApiService.PARAM_TOKEN, token)
        map.put(ApiService.PARAM_USER_DATE, userDate.toString())
        return map
    }
}