package com.company.phonebooking.phonebooking

import com.company.phonebooking.AbstractDbFunctionalTest
import com.company.phonebooking.dto.PhoneBooking
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient
import ru.alfastrahoms.eistfomscommontest.extensions.expectIsOkJsonPage

class PhoneBookingControllerTest(
    @Autowired private val phoneBookingSteps: PhoneBookingSteps
) : AbstractDbFunctionalTest() {

    @Test
    fun shouldGet() {
        // given
        phoneBookingSteps.givenInDatabase()

        val phone = phoneBookingSteps.phone

        // when
        val response = get("phone" to phone.name, "size" to Int.MAX_VALUE)

        // then
        val page = response.expectIsOkJsonPage<PhoneBooking>()
        then(page.totalElements).isEqualTo(1)
        then(page.totalPages).isEqualTo(1)
        then(page.numberOfElements).isEqualTo(1)
        then(page.content).singleElement()
    }

    private fun get(vararg queryParams: Pair<String, Any>): WebTestClient.ResponseSpec {
        val requestHeadersSpec = webTestClient.get().uri { uriBuilder ->
            uriBuilder.path("phone-bookings")
            queryParams.forEach { (name, value) ->
                uriBuilder.queryParam(
                    name,
                    value
                )
            }
            uriBuilder.build()
        }
        return requestHeadersSpec.exchange()
    }
}
