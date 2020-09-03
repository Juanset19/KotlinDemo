package com.juanset.kotlin.demo.repository

import com.juanset.kotlin.demo.model.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao : CrudRepository<BookEntity, Long> {
}