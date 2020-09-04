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
            ResponseEntity.ok(Greeting(content = "Hello $name"))
    //FIXME append the name param into greeting content
            //ResponseEntity.ok(Greeting(content = "Hello"))
    // $name is a String template that appends the value of name passed as parameter

    // Greeting.content is set as a named argument. It even works without specifying the class properties name
    // This may be helpful when a function has a large number of arguments
}