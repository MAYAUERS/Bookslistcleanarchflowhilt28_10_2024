package com.demo.bookslistcleanarchflowhilt28_10_2024.domain.usecase

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books
import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksUsecase(private var booksRepository: BooksRepository) {

     operator fun invoke(): Flow<List<Books>> = flow {
        var result = booksRepository.getBooksData()
    }
}