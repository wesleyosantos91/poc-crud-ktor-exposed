package com.gitlab.wesleyosantos91.backend.kotlin

import com.gitlab.wesleyosantos91.backend.kotlin.api.book
import com.gitlab.wesleyosantos91.backend.kotlin.config.DatabaseMigration
import com.gitlab.wesleyosantos91.backend.kotlin.repository.BookRepository
import com.gitlab.wesleyosantos91.backend.kotlin.service.BookService
import com.google.gson.FieldNamingPolicy
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.Routing
import io.ktor.server.netty.EngineMain
import org.jetbrains.exposed.sql.Database
import org.slf4j.event.Level
import java.lang.reflect.Modifier
import java.util.*


fun main(args: Array<String>): Unit = EngineMain.main(args)

fun initConfig() {
    ConfigFactory.defaultApplication()
}

fun initDatabase() {
    val dbType = ConfigFactory.load().getString("db_type")
    val config = ConfigFactory.load().getConfig(dbType)

    val properties = Properties()
    config.entrySet().forEach { entry ->
        properties.setProperty(entry.key, config.getString(entry.key))
    }

    val hikariConfig = HikariConfig(properties)
    val dataSource = HikariDataSource(hikariConfig)
    Database.connect(dataSource)
}

fun migrateDatabase() {
    DatabaseMigration.migrate()
}

@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {

    initConfig()
    initDatabase()
    migrateDatabase()

    install(ContentNegotiation) {
        gson {
            setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            excludeFieldsWithModifiers(Modifier.TRANSIENT)
        }
    }

    install(Routing) {
        book(BookService(BookRepository()))
    }

    install(CallLogging) {
        level = Level.TRACE
        mdc("executionID") {
            UUID.randomUUID().toString()
        }
    }

}

