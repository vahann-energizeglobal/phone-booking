package com.company.phonebooking.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table
class PhoneBookingEntity(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "sequenceGenerator"
    )
    @SequenceGenerator(name = "sequenceGenerator")
    var id: Long? = null,

    @Column(name = "creation_date", updatable = false)
    val date: Instant = Instant.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    var phone: PhoneEntity,
)
