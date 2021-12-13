package com.company.phonebooking

import com.company.phonebooking.repository.PhoneBookingRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DbCleaner(
    private val phoneBookingRepository: PhoneBookingRepository,
) {

    @Transactional
    fun clean() {
        phoneBookingRepository.deleteAllInBatch()
    }
}
