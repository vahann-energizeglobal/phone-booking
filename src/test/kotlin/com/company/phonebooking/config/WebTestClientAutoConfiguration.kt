package com.company.phonebooking.config

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.Duration

@Configuration
class WebTestClientAutoConfiguration {

    @Bean
    fun webTestClientConfigurer() = object : BeanPostProcessor {
        override fun postProcessAfterInitialization(
            bean: Any,
            beanName: String
        ): Any =
            if (bean is WebTestClient) {
                bean.mutate()
                    .responseTimeout(Duration.ofMinutes(10))
                    .codecs {
                        it.defaultCodecs().maxInMemorySize(2 * 1024 * 1024)
                    }
                    .build()
            } else {
                bean
            }
    }
}
