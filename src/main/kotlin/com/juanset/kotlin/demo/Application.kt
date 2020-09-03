package com.juanset.kotlin.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("com.juanset.kotlin.demo.model.entity")
@EnableJpaRepositories("com.juanset.kotlin.demo.repository")
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
