package com.gmariotti

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class SpringBootApplication

fun main(args: Array<String>) {
    runApplication<com.gmariotti.SpringBootApplication>(*args)
}
