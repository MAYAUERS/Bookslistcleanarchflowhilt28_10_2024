package com.demo.bookslistcleanarchflowhilt28_10_2024.network

import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books
import retrofit2.http.GET

interface ApiService {

    //https://softwium.com/api/books
    @GET("books")
    suspend fun getBooksData():Books
}