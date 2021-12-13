package com.company.phonebooking

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractDbFunctionalTest : AbstractFunctionalTest() {

    @BeforeEach
    fun cleanDatabase(@Autowired dbCleaner: DbCleaner) = dbCleaner.clean()
}
