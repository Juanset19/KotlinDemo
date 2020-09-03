package com.juanset.kotlin.demo.model

/**
 * Data class with nullable properties
 */
data class User(val name: String,
                val lastName: String,
                val nickname: String?, //nullable String
                val address: String? //nullable String
) {
    fun introduceYourself(): String {
        val nameToShow = if (nickname == null) name else nickname
        // When using ? (elvis) operator you can check if nickname value is not null and assign the value. If it's null it then returns the name
        // val nameToShow = nickname ?: name
        return "Hello, I'm $nameToShow"
    }
}