package com.company.phonebooking.domain

import javax.persistence.*

@Entity
@Table(name = "phone")
class PhoneEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val name: String,

    @OneToMany(mappedBy = "phone")
    var phoneBookings: Set<PhoneBookingEntity> = HashSet()
)
