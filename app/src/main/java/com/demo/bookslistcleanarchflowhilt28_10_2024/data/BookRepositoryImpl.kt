package com.demo.bookslistcleanarchflowhilt28_10_2024.data

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books
import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.repository.BooksRepository

class BookRepositoryImpl(private val bookDataSource: BookDataSource):BooksRepository {
    override suspend fun getBooksData(): Books = bookDataSource.getBooksData()
}