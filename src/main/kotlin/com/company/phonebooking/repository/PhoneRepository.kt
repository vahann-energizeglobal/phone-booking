package com.company.phonebooking.repository

import com.company.phonebooking.domain.PhoneEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor


interface PhoneRepository : JpaRepository<PhoneEntity, Long>,
    QuerydslPredicateExecutor<PhoneEntity> {
}
