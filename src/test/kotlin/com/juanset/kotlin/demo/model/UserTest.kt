package com.juanset.kotlin.demo.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {
    @Test
    fun `when creating user it accepts nullable nickname and address`() {
        val expectedUser = User(name = "Jhon", lastName = "Doe", address = null, nickname = null)
        assertEquals(expectedUser, User(name = "Jhon", lastName = "Doe", address = null, nickname = null))
    }

    @Test
    fun `when user introduces and has no nickname, then says the name`() {
        val expectedUser = User(name = "Jhon", lastName = "Doe", address = null, nickname = null)
        assertEquals(expectedUser.introduceYourself(), "Hello, I'm ${expectedUser.name}")
    }

    @Test
    fun `when user introduces and has nickname, then says the nickname`() {
        val expectedUser = User(name = "Jhon", lastName = "Doe", address = null, nickname = "Jhonny")
        assertEquals(expectedUser.introduceYourself(), "Hello, I'm ${expectedUser.nickname}")
    }
}