package com.demo.bookslistcleanarchflowhilt28_10_2024.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.usecase.BooksUsecase
import com.demo.bookslistcleanarchflowhilt28_10_2024.utility.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class BookViewModel(private var booksUsecase: BooksUsecase):ViewModel() {

    var books:Flow<ApiState> = booksUsecase.invoke().map {
        ApiState.Success(it)
    }.catch {
        ApiState.Failure(it)
    }.onStart {
        ApiState.Loading
    }
}