package com.juanset.kotlin.demo.controller.v1

import com.juanset.kotlin.demo.model.response.AuthorResponse
import com.juanset.kotlin.demo.model.response.toAuthorResponse
import com.juanset.kotlin.demo.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorController {
    @Autowired
    lateinit var authorService: AuthorService

    @GetMapping
    fun getAuthors(): ResponseEntity<List<AuthorResponse>> = ResponseEntity.ok(authorService.findAll().map { toAuthorResponse(it) })
}