package com.hospitalbedapi.repository

import com.hospitalbedapi.model.Leito
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeitoRepository : JpaRepository<Leito, Long> {
    fun findByStatus(status: Leito.StatusLeito): List<Leito>
}