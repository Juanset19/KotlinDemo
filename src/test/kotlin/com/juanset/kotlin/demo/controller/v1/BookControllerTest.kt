package com.juanset.kotlin.demo.controller.v1

import com.fasterxml.jackson.databind.ObjectMapper
import com.juanset.kotlin.demo.model.response.AuthorResponse
import com.juanset.kotlin.demo.model.response.BookResponse
import com.juanset.kotlin.demo.model.response.GenreResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {
    private val fantasy = GenreResponse(id = 6, name = "FANTASY")
    private val romance = GenreResponse(id = 3, name = "ROMANCE")
    private val history = GenreResponse(id = 1, name = "HISTORY")
    private val gabriel = AuthorResponse(id = 1, name = "Gabriel", lastName = "García Marquez")
    private val hector = AuthorResponse(id = 2, name = "Hector", lastName = "Abad")
    private val efraim = AuthorResponse(id = 3, name = "Efraim", lastName = "Medina")
    private val carl = AuthorResponse(id = 4, name = "Carl", lastName = "Sagan")
    private val cienDeSoledad = BookResponse(id = 1, title = "Cien años de soledad",
            genre = fantasy, author = gabriel)
    private val elOlvido = BookResponse(id = 2, title = "El olvido que seremos",
            genre = history, author = hector)
    private val eraseUnaVez = BookResponse(id = 3, title = "Érase una vez el amor pero tuve que matarlo",
            genre = romance, author = efraim)
    private val dragonesEden = BookResponse(id = 4, title = "Los dragones del edén",
            genre = history, author = carl)
    private val relatoNaufrago = BookResponse(id = 5, title = "Relato de un naúfrago",
            genre = history, author = gabriel)
    private val cinemaArbol = BookResponse(id = 6, title = "Cinema Árbol",
            genre = history, author = efraim)
    private val na = BookResponse(id = 7, title = "N/A", genre = null, author = null)
    private val naP2 = BookResponse(id = 8, title = "N/A Parte 2", genre = null, author = null)

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `when getting authors returns data`() {
        mockMvc.get("/books").andExpect {
            status { isOk }
            content {
                json(objectMapper.writeValueAsString(listOf(cienDeSoledad, elOlvido, eraseUnaVez,
                        dragonesEden, relatoNaufrago, cinemaArbol, na, naP2)))
            }
        }
    }

    @Test
    fun `when getting by authors returns data grouped by authors name`() {
        mockMvc.get("/books/by-authors").andExpect {
            status { isOk }
            content {
                json(objectMapper.writeValueAsString(mapOf("${gabriel.name} ${gabriel.lastName}" to listOf(cienDeSoledad, relatoNaufrago),
                        "${efraim.name} ${efraim.lastName}" to listOf(eraseUnaVez, cinemaArbol),
                        "${carl.name} ${carl.lastName}" to listOf(dragonesEden),
                        " " to listOf(na, naP2))))
            }
        }
    }

    @Test
    fun `when getting by genre returns data grouped by genre name except books with null genre`() {
        mockMvc.get("/books/by-genre").andExpect {
            status { isOk }
            content {
                json(objectMapper.writeValueAsString(mapOf(fantasy.name to listOf(cienDeSoledad),
                        history.name to listOf(elOlvido, dragonesEden, relatoNaufrago, cinemaArbol),
                        romance.name to listOf(eraseUnaVez))))
            }
        }
    }
}