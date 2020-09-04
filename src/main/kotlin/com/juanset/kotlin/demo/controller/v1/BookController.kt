package com.juanset.kotlin.demo.controller.v1

import com.juanset.kotlin.demo.model.response.BookResponse
import com.juanset.kotlin.demo.model.response.toBookResponse
import com.juanset.kotlin.demo.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    lateinit var bookService: BookService

    @GetMapping
    fun getBooks(): ResponseEntity<List<BookResponse>> = ResponseEntity.ok(bookService.findAll().map { toBookResponse(it) })

    @GetMapping("/by-authors")
    fun getBooksGroupedByAuthor(): ResponseEntity<Map<String, List<BookResponse>>> {
        //FIXME
        val books = bookService.findAll().map { toBookResponse(it) }
        return ResponseEntity.ok(mapOf("The key should be the complete name of the author" to books))
    }

    @GetMapping("/by-genre")
    fun getBooksGroupedByGenre(): ResponseEntity<Map<String, List<BookResponse>>> {
        //FIXME
        val books = bookService.findAll().map { toBookResponse(it) }
        return ResponseEntity.ok(mapOf("The key should be the genre and non-null values should be included" to books))
    }
}