package com.houseravenstudios.common.result

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error (val throwable: Throwable?) : ApiResult<Nothing>
}