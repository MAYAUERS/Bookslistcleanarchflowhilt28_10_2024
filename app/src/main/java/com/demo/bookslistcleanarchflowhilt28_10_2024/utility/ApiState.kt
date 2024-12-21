package com.demo.bookslistcleanarchflowhilt28_10_2024.utility

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books

sealed class ApiState {

    class Success(var data:List<Books>):ApiState()
    class Failure(var msg:Throwable):ApiState()
    object Loading:ApiState()
}