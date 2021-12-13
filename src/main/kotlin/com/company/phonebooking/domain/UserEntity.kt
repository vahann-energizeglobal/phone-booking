package com.company.phonebooking.domain

import javax.persistence.*

@Entity
@Table
class UserEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "sequenceGenerator"
    )
    @SequenceGenerator(name = "sequenceGenerator")
    var id: Long? = null,

    @Column
    val name: String,

    @OneToMany(mappedBy = "user")
    var phoneBookings: Set<PhoneBookingEntity> = HashSet()
)
