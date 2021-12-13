package com.company.phonebooking.config

import com.fasterxml.jackson.databind.Module
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.cloud.openfeign.support.PageJacksonModule
import org.springframework.cloud.openfeign.support.SortJacksonModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonAutoConfiguration {

    @Bean
    @ConditionalOnClass(name = ["org.springframework.data.domain.Page"])
    fun pageJacksonModule(): Module = PageJacksonModule()

    @Bean
    @ConditionalOnClass(name = ["org.springframework.data.domain.Sort"])
    fun sortJacksonModule(): Module = SortJacksonModule()
}
