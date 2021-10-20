package ru.vevteev.costanalyzerbackend.service

import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Service
import ru.vevteev.costanalyzerbackend.entity.CostEntity
import ru.vevteev.costanalyzerbackend.enums.Category
import ru.vevteev.costanalyzerbackend.exception.ClientNotFoundException
import ru.vevteev.costanalyzerbackend.model.CostDTO
import ru.vevteev.costanalyzerbackend.repository.CostRepository

@Service
class CostService(
    private val costRepository: CostRepository,
    private val clientService: ClientService
) {

    suspend fun saveNewCost(clientId: Long, costDTO: CostDTO): Long {
        val client = clientService.getClient(clientId) ?: throw ClientNotFoundException(clientId)
        val cost = CostEntity(
            costId = 1,
            categoryName = Category.valueOf(costDTO.category),
            expenditure = costDTO.expenditure,
            client = client
        )
        return costRepository.save(cost).awaitFirst().costId
    }

}