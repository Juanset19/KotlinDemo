package com.juanset.kotlin.demo.service

import com.juanset.kotlin.demo.model.entity.BookEntity
import com.juanset.kotlin.demo.repository.BookDao
import org.springframework.stereotype.Service

@Service
class BookService(val bookDao: BookDao) {

    fun findAll(): List<BookEntity> {
        return bookDao.findAll().toList()
    }
}