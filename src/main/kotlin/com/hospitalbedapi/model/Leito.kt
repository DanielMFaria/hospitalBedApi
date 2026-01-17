package com.hospitalbedapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_leitos")
class Leito(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var codigo: String = "",

    @Enumerated(EnumType.STRING)
    var status: StatusLeito = StatusLeito.LIVRE,

    var pacienteAtual: String? = null
) {
    enum class StatusLeito {
        LIVRE, OCUPADO, MANUTENCAO
    }
}