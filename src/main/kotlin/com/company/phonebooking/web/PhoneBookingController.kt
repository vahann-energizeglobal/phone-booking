package com.company.phonebooking.web

import com.company.phonebooking.dto.PhoneBooking
import com.company.phonebooking.service.PhoneBookingService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/phone-bookings")
class PhoneBookingController(
    private val phoneBookingService: PhoneBookingService
) {
    @GetMapping
    fun get(
        @RequestParam phone: String,
        pageable: Pageable
    ): Page<PhoneBooking> = phoneBookingService.get(phone, pageable)
}
