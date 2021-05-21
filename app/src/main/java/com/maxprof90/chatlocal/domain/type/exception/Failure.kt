package com.maxprof90.chatlocal.domain.type.exception

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object EmailAlreadyExistError : Failure()

}