package ru.vevteev.costanalyzerbackend.service

import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Service
import ru.vevteev.costanalyzerbackend.model.CategoryDTO
import ru.vevteev.costanalyzerbackend.model.CategoryDTOWrapper
import ru.vevteev.costanalyzerbackend.repository.CategoryRepository

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    suspend fun getAllCosts() : CategoryDTOWrapper =
        CategoryDTOWrapper(
            categoryRepository.findAll()
                .map { CategoryDTO(it.categoryCode.code) }
                .collectList()
                .awaitFirst()
        )

}