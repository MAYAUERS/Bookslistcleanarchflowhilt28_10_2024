package com.demo.bookslistcleanarchflowhilt28_10_2024.domain.repository

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books

interface BooksRepository {

    suspend fun getBooksData():Books
}