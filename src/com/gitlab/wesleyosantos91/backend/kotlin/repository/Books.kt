package com.gitlab.wesleyosantos91.backend.kotlin.repository

import com.gitlab.wesleyosantos91.backend.kotlin.domain.Book
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 * @author : wesleyosantos91
 * @Date : 11/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
object Books : Table("books") {
    val bookId: Column<String> = varchar("book_id", 60).primaryKey()
    val bookTitle: Column<String> = varchar("book_title", 100)
    val version: Column<Int> = integer("version")
}

class BookRepository {

    fun create(book: Book) {
        transaction {
            Books.insert {
                it[bookId] = book.id!!
                it[bookTitle] = book.title
                it[version] = book.version
            }
        }
    }

    fun read(bookId: String): Book? {
        return transaction {
            Books.select {
                Books.bookId eq bookId
            }.map {
                Book(
                    id = it[Books.bookId],
                    title = it[Books.bookTitle],
                    version = it[Books.version]
                )
            }.firstOrNull()
        }
    }

    fun update(book: Book, bookId: String) {
        transaction {
            Books.update({Books.bookId eq bookId}) {
                it[bookTitle] = book.title
            }
        }
    }

    fun delete(bookId: String) {
        transaction {
            Books.deleteWhere {
                Books.bookId eq bookId
            }
        }
    }

    fun getAll(): ArrayList<Book> {
        val books: ArrayList<Book> = arrayListOf()

        transaction {
            Books.selectAll().map {
                books.add(
                    Book(
                        id = it[Books.bookId],
                        title = it[Books.bookTitle],
                        version = it[Books.version]
                    )
                )
            }
        }
        return books
    }
}