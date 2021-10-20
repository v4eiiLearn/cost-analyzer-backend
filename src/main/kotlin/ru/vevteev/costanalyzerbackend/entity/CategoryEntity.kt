package ru.vevteev.costanalyzerbackend.entity

import org.springframework.data.relational.core.mapping.Table
import ru.vevteev.costanalyzerbackend.enums.Category
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
@Table(value = "category")
class CategoryEntity(
    @Id
    val categoryId: Long,
    @Enumerated(EnumType.STRING)
    val categoryCode: Category
)
