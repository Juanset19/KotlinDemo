package com.juanset.kotlin.demo.model

/**
 * Data class with nullable properties
 */
data class User(val name: String,
                val lastName: String
                //FIXME add nullable parameters to this constructor
) {
    fun introduceYourself(): String {
        // FIXME if nickname is not null then show 'Hello, I'm $nickname' else 'Hello, I'm $name'. Check using elvis operator
        return "Hello, I'm $name"
    }
}