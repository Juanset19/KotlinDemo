package com.juanset.kotlin.demo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.juanset.kotlin.demo.model.Greeting
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(controllers = [GreetingController::class])
class GreetingControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `when Greeting with default value returns Hello World`() {
        mockMvc.get("/greetings").andExpect {
            status { isOk }
            content { json(objectMapper.writeValueAsString(Greeting("Hello World"))) }
        }
    }

    @Test
    fun `when Greeting with param value returns Hello param`() {
        mockMvc.get("/greetings?name=Universe").andExpect {
            status { isOk }
            content { json(objectMapper.writeValueAsString(Greeting("Hello Universe"))) }
        }
    }
}