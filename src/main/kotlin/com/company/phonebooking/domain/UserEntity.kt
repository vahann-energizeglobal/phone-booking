package com.company.phonebooking.domain

import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    val name: String,

    @OneToMany(mappedBy = "user")
    var phoneBookings: Set<PhoneBookingEntity> = HashSet()
)
