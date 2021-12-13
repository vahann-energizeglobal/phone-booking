package com.company.phonebooking.service

import com.company.phonebooking.dto.PhoneBooking
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PhoneBookingService {
    fun get(phone: String, pageable: Pageable): Page<PhoneBooking>
}
