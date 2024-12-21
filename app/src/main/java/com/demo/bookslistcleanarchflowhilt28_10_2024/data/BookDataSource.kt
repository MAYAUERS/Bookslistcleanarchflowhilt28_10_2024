package com.demo.bookslistcleanarchflowhilt28_10_2024.data

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books

interface BookDataSource {

    suspend fun getBooksData():Books
}