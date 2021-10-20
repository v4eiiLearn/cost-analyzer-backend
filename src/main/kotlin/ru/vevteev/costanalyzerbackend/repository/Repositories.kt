package ru.vevteev.costanalyzerbackend.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import ru.vevteev.costanalyzerbackend.entity.CategoryEntity
import ru.vevteev.costanalyzerbackend.entity.ClientEntity
import ru.vevteev.costanalyzerbackend.entity.CostEntity

@Repository
interface CategoryRepository : ReactiveCrudRepository<CategoryEntity, Long>

@Repository
interface ClientRepository : ReactiveCrudRepository<ClientEntity, Long> {

//    @Query(value = "SELECT nextval('client_sequence')", nativeQuery = true)
//    fun getNextId(): Long
}

@Repository
interface CostRepository : ReactiveCrudRepository<CostEntity, Long> {

//    @Query(value = "SELECT nextval('cost_sequence')", nativeQuery = true)
//    fun getNextId(): Long
}