package ru.vevteev.costanalyzerbackend.entity

import org.springframework.data.relational.core.mapping.Table
import ru.vevteev.costanalyzerbackend.enums.Category
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(value = "cost")
class CostEntity(
    @Id
    val costId: Long,
    @Enumerated(EnumType.STRING)
    val categoryName: Category,
    val expenditure: BigDecimal,
    @ManyToOne
    val client: ClientEntity
)