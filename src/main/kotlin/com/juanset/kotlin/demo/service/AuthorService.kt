package com.juanset.kotlin.demo.service

import com.juanset.kotlin.demo.model.entity.AuthorEntity
import com.juanset.kotlin.demo.repository.AuthorDao
import org.springframework.stereotype.Service

@Service
class AuthorService(val authorDao: AuthorDao) {

    fun findAll(): List<AuthorEntity> {
        return authorDao.findAll().toList()
    }
}