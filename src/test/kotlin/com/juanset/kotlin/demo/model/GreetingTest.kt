package com.juanset.kotlin.demo.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GreetingTest {
    @Test
    fun testModel() {
        val expectedGreeting = Greeting(content = "Hello")
        assertEquals(expectedGreeting, Greeting(content = "Hello"))
    }
}