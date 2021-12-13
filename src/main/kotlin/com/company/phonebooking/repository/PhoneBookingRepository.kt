package com.company.phonebooking.repository

import com.company.phonebooking.domain.PhoneBookingEntity
import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor


interface PhoneBookingRepository : JpaRepository<PhoneBookingEntity, Long>,
    QuerydslPredicateExecutor<PhoneBookingEntity> {

    @EntityGraph(attributePaths = ["user", "phone"])
    override fun findAll(
        predicate: Predicate, pageable: Pageable
    ): Page<PhoneBookingEntity>
}
