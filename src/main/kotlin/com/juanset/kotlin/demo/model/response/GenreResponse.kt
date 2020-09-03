package com.juanset.kotlin.demo.model.response

import com.juanset.kotlin.demo.model.entity.GenreEntity

data class GenreResponse(
        val id: Long,
        val name: String
)

fun toGenreResponse(entity: GenreEntity) = GenreResponse(id = entity.id,
        name = entity.name)
