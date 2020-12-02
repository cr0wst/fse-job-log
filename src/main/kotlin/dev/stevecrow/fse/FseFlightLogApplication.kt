package dev.stevecrow.fse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FseFlightLogApplication

fun main(args: Array<String>) {
    runApplication<FseFlightLogApplication>(*args)
}
