package com.company.phonebooking.service

import com.company.phonebooking.domain.QPhoneBookingEntity
import com.company.phonebooking.dto.PhoneBooking
import com.company.phonebooking.repository.PhoneBookingRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultPhoneBookingService(
    private val phoneBookingRepository: PhoneBookingRepository
) : PhoneBookingService {

    @Transactional(readOnly = true)
    override fun get(phone: String, pageable: Pageable): Page<PhoneBooking> =
        phoneBookingRepository.findAll(
            QPhoneBookingEntity.phoneBookingEntity.phone.name.eq(phone),
            pageable
        ).map { PhoneBooking(it.date, it.user.name) }
}
