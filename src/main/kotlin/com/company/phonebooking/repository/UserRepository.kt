package com.company.phonebooking.repository

import com.company.phonebooking.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor


interface UserRepository : JpaRepository<UserEntity, Long>,
    QuerydslPredicateExecutor<UserEntity>
