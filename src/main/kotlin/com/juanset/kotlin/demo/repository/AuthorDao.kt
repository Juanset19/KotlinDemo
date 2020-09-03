package com.juanset.kotlin.demo.repository

import com.juanset.kotlin.demo.model.entity.AuthorEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorDao : CrudRepository<AuthorEntity, Long>