package ru.alfastrahoms.eistfomscommontest.extensions

import org.assertj.core.api.BDDAssertions.then
import org.springframework.core.ParameterizedTypeReference
import org.springframework.data.domain.Page
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified B : Any> WebTestClient.ResponseSpec.expectIsOkJsonPage(): Page<B> {
    val responseBody = expectStatus().isOk
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody(object : ParameterizedTypeReference<Page<B>>() {})
        .returnResult().responseBody

    then(responseBody).isNotNull
        .doesNotContainNull()

    return responseBody!!
}
