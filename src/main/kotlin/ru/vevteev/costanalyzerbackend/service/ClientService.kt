package ru.vevteev.costanalyzerbackend.service

import org.springframework.stereotype.Service
import ru.vevteev.costanalyzerbackend.entity.ClientEntity
import ru.vevteev.costanalyzerbackend.repository.ClientRepository

@Service
class ClientService(
    private val clientRepository: ClientRepository
) {

    fun getClient(clientId: Long): ClientEntity? {
        return clientRepository.findById(clientId).block()
    }

}