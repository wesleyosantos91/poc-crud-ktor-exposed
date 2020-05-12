package com.gitlab.wesleyosantos91.backend.kotlin

import com.gitlab.wesleyosantos91.backend.kotlin.domain.Book
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/books").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
