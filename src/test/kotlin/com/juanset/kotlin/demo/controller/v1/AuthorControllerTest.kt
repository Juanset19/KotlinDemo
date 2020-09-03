package com.juanset.kotlin.demo.controller.v1

import com.fasterxml.jackson.databind.ObjectMapper
import com.juanset.kotlin.demo.model.response.AuthorResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {
    private val gabriel = AuthorResponse(id = 1, name = "Gabriel", lastName = "García Marquez")
    private val hector = AuthorResponse(id = 2, name = "Hector", lastName = "Abad")
    private val efraim = AuthorResponse(id = 3, name = "Efraim", lastName = "Medina")
    private val carl = AuthorResponse(id = 4, name = "Carl", lastName = "Sagan")

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `when getting authors returns data`() {
        mockMvc.get("/authors").andExpect {
            status { isOk }
            content { json(objectMapper.writeValueAsString(listOf(gabriel, hector, efraim, carl))) }
        }
    }
}