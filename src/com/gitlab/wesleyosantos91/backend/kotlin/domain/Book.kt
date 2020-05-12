package com.gitlab.wesleyosantos91.backend.kotlin.domain

/**
 *
 * @author : wesleyosantos91
 * @Date : 11/05/20
 * @Contact : wesleyosantos91@gmail.com
 *
 **/
data class Book(
    val id: String? = null,
    val title: String,
    @Transient val version: Int = 1
)