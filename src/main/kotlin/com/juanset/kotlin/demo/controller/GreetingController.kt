package com.juanset.kotlin.demo.controller

import com.juanset.kotlin.demo.model.Greeting
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @GetMapping("/greetings")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            ResponseEntity.ok(Greeting("Hello $name"))
    // $name is a String template that appends the value of name passed as parameter
}