package com.company.phonebooking.phonebooking

import com.company.phonebooking.domain.PhoneBookingEntity
import com.company.phonebooking.domain.PhoneEntity
import com.company.phonebooking.domain.UserEntity
import com.company.phonebooking.repository.PhoneBookingRepository
import com.company.phonebooking.repository.PhoneRepository
import com.company.phonebooking.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PhoneBookingSteps(
    private val phoneBookingRepository: PhoneBookingRepository,
    userRepository: UserRepository,
    phoneRepository: PhoneRepository
) {
    private final val phones: List<PhoneEntity> = phoneRepository.findAll()
    val phone = phones.first()
    private val users: List<UserEntity> = userRepository.findAll()

    @Transactional
    fun givenInDatabase(): List<PhoneBookingEntity> {
        val user = users.first()
        val booking = PhoneBookingEntity(user = user, phone = phone)
        val lastPhone = phones.last()
        val bookingForAnotherPhone =
            PhoneBookingEntity(user = user, phone = lastPhone)
        return phoneBookingRepository.saveAll(
            listOf(booking, bookingForAnotherPhone)
        )
    }
}
