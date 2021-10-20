package ru.vevteev.costanalyzerbackend.entity

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@Table(value = "cost")
class ClientEntity(
    @Id
    val clientId: Long,
    val login: String,
    val password: String,
    @OneToMany
    val costs: List<CostEntity>
)