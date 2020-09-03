package com.juanset.kotlin.demo.model.response

import com.juanset.kotlin.demo.model.entity.BookEntity

data class BookResponse(
        val id: Long,
        val title: String,
        val genre: GenreResponse?,
        val author: AuthorResponse?
)

fun toBookResponse(entity: BookEntity) = BookResponse(id = entity.id,
        title = entity.title,
        genre = entity.genre?.let { toGenreResponse(entity = it) },
        author = entity.author?.let { toAuthorResponse(entity = it) }
)
