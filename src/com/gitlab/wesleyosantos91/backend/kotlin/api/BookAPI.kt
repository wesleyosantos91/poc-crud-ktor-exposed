package com.gitlab.wesleyosantos91.backend.kotlin.api

import com.gitlab.wesleyosantos91.backend.kotlin.domain.Book
import com.gitlab.wesleyosantos91.backend.kotlin.service.BookService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import mu.KotlinLogging
import java.util.*

/**
 *
 * @author : wesleyosantos91
 * @Date : 11/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/

fun Route.book(service: BookService) {

    val logger = KotlinLogging.logger {}

    route("books") {

        post("/") {
            try {
                var book = call.receive<Book>()
                book = book.copy(id = UUID.randomUUID().toString())
                service.create(book)
                call.respond(HttpStatusCode.Created, book)
            } catch (e: Exception) {
                logger.error("Failed to perform insert", e)
            }
        }

        get("/{bookId}") {
            val id = call.parameters["bookId"]

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val book = service.read(id)
            if (book == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(HttpStatusCode.OK, book)
            }
        }

        put("/{bookId}") {
            val id = call.parameters["bookID"]
            val bookUpdate = call.receive<Book>()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@put
            }

            val book = service.read(id)
            if (book == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                service.update(bookUpdate, id)
                call.respond(HttpStatusCode.OK)
            }
        }

        delete("/{bookId}") {
            val id = call.parameters["bookID"]

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@delete
            }

            val book = service.read(id)
            if (book == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                service.delete(id)
                call.respond(HttpStatusCode.NoContent)
            }
        }

        get("/") {
            call.respond(HttpStatusCode.OK, service.getAll())
        }
    }
}