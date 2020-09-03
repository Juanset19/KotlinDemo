package com.juanset.kotlin.demo.model

/**
 * We frequently create classes whose main purpose is to hold data.
 * In such a class some standard functionality and utility functions are often mechanically derivable from the data.
 * In Kotlin, this is called a data class and is marked as data.
 *
 * See: https://kotlinlang.org/docs/reference/data-classes.html
 */
data class Greeting(val content: String)