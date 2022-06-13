package com.be.bestThings.security

import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: BCryptPasswordEncoder
    ) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
    }
}