package com.company.phonebooking.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "phone_booking")
class PhoneBookingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "date", updatable = false)
    val date: Instant = Instant.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    var phone: PhoneEntity,
)
