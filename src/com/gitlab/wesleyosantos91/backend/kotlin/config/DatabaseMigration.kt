package com.gitlab.wesleyosantos91.backend.kotlin.config

import com.typesafe.config.ConfigFactory
import org.flywaydb.core.Flyway

/**
 *
 * @author : wesleyosantos91
 * @Date : 11/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
object DatabaseMigration {

    fun migrate() {
        val dbType = ConfigFactory.load().getString("db_type")
        val config = ConfigFactory.load().getConfig(dbType)
        val flyway = Flyway.configure()
            .dataSource(config.getString("dataSource.url"),
                config.getString("dataSource.user"),
                config.getString("dataSource.password"))
            .schemas("library")
            .locations("db/migration")
            .load()
        flyway.migrate()
    }
}