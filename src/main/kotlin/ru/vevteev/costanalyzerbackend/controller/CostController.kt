package ru.vevteev.costanalyzerbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vevteev.costanalyzerbackend.api.CostsApi
import ru.vevteev.costanalyzerbackend.exception.NotValidRequestBodyException
import ru.vevteev.costanalyzerbackend.model.CostDTO
import ru.vevteev.costanalyzerbackend.model.CostsDTOWrapper
import ru.vevteev.costanalyzerbackend.service.CostService
import java.net.URI

@RestController
class CostController(
    private val costService: CostService
) : CostsApi {

    override suspend fun createNewCost(clientId: String, costDTO: CostDTO?): ResponseEntity<Unit> {
        val costId = costService.saveNewCost(clientId.toLong(), costDTO ?: throw NotValidRequestBodyException())
        return ResponseEntity.created(URI.create("/costs/$clientId/$costId")).build()
    }

    override suspend fun getAllCosts(clientId: String): ResponseEntity<CostsDTOWrapper> {
        TODO("Not implemented yet")
    }

    @GetMapping("/123")
    fun test(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}