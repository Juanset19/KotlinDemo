package com.juanset.kotlin.demo.controller.v1

import com.juanset.kotlin.demo.model.response.AuthorResponse
import com.juanset.kotlin.demo.model.response.BookResponse
import com.juanset.kotlin.demo.model.response.toAuthorResponse
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
        return ResponseEntity.ok(bookService.findAll()
                .map { toBookResponse(it) }
                .groupBy { "${it.author?.name?:""} ${it.author?.lastName?:""}" })
        //FIXME
        /*return ResponseEntity.ok(bookService.findAll()
                .map { toBookResponse(it) }
                .groupBy { it.author?.id.toString() })*/
    }

    @GetMapping("/by-genre")
    fun getBooksGroupedByGenre(): ResponseEntity<Map<String, List<BookResponse>>> {
        return ResponseEntity.ok(bookService.findAll()
                .map { toBookResponse(it) }
                .filterNot{ it.genre == null }
                .groupBy { it.genre!!.name })
        //FIXME
        /*return ResponseEntity.ok(bookService.findAll()
                .map { toBookResponse(it) }
                .groupBy { it.title })*/
    }
}