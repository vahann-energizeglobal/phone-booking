package com.company.phonebooking.domain

import javax.persistence.*

@Entity
@Table
class PhoneEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "sequenceGenerator"
    )
    @SequenceGenerator(name = "sequenceGenerator")
    var id: Long? = null,

    val name: String,

    @OneToMany(mappedBy = "phone")
    var phoneBookings: Set<PhoneBookingEntity> = HashSet()
)
