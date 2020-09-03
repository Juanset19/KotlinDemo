package com.juanset.kotlin.demo.model.response

import com.juanset.kotlin.demo.model.entity.AuthorEntity

data class AuthorResponse(
        val id: Long,
        val name: String,
        val lastName: String
)

fun toAuthorResponse(entity: AuthorEntity) = AuthorResponse(id = entity.id,
        name = entity.name,
        lastName = entity.lastName)
