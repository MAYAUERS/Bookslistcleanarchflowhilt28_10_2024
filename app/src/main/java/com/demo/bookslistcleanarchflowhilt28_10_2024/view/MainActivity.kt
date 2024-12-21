package com.demo.bookslistcleanarchflowhilt28_10_2024.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.bookslistcleanarchflowhilt28_10_2024.R
import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books
import com.demo.bookslistcleanarchflowhilt28_10_2024.utility.ApiState
import com.demo.bookslistcleanarchflowhilt28_10_2024.viewmodel.BookViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val bookViewModel: BookViewModel by viewModels()
    private lateinit var booksListAdapter: BooksListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            bookViewModel.books.collect{
                when(it){
                    is ApiState.Success ->{
                        booksListAdapter = BooksListAdapter(it as ArrayList<Books>)
                        recyclerView.adapter = booksListAdapter
                    }
                    is ApiState.Failure -> {
                        Toast.makeText(this@MainActivity,"Error $it",Toast.LENGTH_SHORT).show()
                    }
                    is ApiState.Loading ->{
                        Toast.makeText(this@MainActivity,"Loading $it",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}