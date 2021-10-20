package ru.vevteev.costanalyzerbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.vevteev.costanalyzerbackend.api.CategoryApi
import ru.vevteev.costanalyzerbackend.model.CategoryDTOWrapper
import ru.vevteev.costanalyzerbackend.service.CategoryService

@RestController
class CategoryController(
    private val categoryService: CategoryService
) : CategoryApi {

    override suspend fun getAllCategory(): ResponseEntity<CategoryDTOWrapper> =
        ResponseEntity.ok(categoryService.getAllCosts())
}