package com.demo.bookslistcleanarchflowhilt28_10_2024.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.bookslistcleanarchflowhilt28_10_2024.R
import com.demo.bookslistcleanarchflowhilt28_10_2024.domain.model.Books

class BooksListAdapter(private var books: ArrayList<Books>):RecyclerView.Adapter<BooksListAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BooksListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.books_items,parent,false)
        return MyViewHolder(view)
    }

    class MyViewHolder(item: View):RecyclerView.ViewHolder(item) {
        var id  = item.findViewById<TextView>(R.id.txt_id)
        var name  = item.findViewById<TextView>(R.id.txt_name)
        var pageCount  = item.findViewById<TextView>(R.id.txt_pageCount)

        fun bindViews(books: Books){
            id.text = books.id.toString()
            name.text = books.title
            pageCount.text = books.pageCount.toString()
        }
    }

    override fun onBindViewHolder(holder: BooksListAdapter.MyViewHolder, position: Int) {
       holder.bindViews(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}