package com.nabiha.domain.utils

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Loading<out T>(val loading: Boolean) : Result<T>()
    data class Error<out T>(val errorMessage: String,val code:Int) : Result<T>()
}