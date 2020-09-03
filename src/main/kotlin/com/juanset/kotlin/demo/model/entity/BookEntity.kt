package com.juanset.kotlin.demo.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "book")
class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long = 0

    @Column(name = "title")
    val title: String = ""

    @OneToOne
    @JoinColumn(name = "genre_id")
    val genre: GenreEntity? = null

    @OneToOne
    @JoinColumn(name = "author_id")
    val author: AuthorEntity? = null
}