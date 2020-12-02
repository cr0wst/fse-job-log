package dev.stevecrow.fse

import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FseFlightLogApplication {
    @Bean
    fun apacheClient(): HttpHandler = ApacheClient()
}

fun main(args: Array<String>) {
    runApplication<FseFlightLogApplication>(*args)
}
