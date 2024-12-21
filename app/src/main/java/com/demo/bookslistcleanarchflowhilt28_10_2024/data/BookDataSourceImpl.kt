package com.demo.bookslistcleanarchflowhilt28_10_2024.data

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books
import com.demo.bookslistcleanarchflowhilt28_10_2024.network.ApiService

class BookDataSourceImpl(private val apiService: ApiService):BookDataSource {

    override suspend fun getBooksData(): Books = apiService.getBooksData()
}