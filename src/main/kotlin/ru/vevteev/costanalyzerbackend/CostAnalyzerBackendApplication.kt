package ru.vevteev.costanalyzerbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
class CostAnalyzerBackendApplication

fun main(args: Array<String>) {
    runApplication<CostAnalyzerBackendApplication>(*args)
}
