package com.gitlab.wesleyosantos91.backend.kotlin.service

import com.gitlab.wesleyosantos91.backend.kotlin.domain.Book
import com.gitlab.wesleyosantos91.backend.kotlin.repository.BookRepository

/**
 *
 * @author : wesleyosantos91
 * @Date : 11/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
class BookService(val repository: BookRepository) {

    fun create(book: Book) {
        repository.create(book)
    }

    fun read(bookId: String): Book? {
       return repository.read(bookId)
    }

    fun update(book: Book, bookId: String) {
        repository.update(book, bookId)
    }

    fun delete(bookId: String) {
        repository.delete(bookId)
    }

    fun getAll(): ArrayList<Book> {
        return repository.getAll()
    }

}