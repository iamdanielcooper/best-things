package com.be.bestThings.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.username = ?1")
    fun findUserByUsername(username: String): Optional<User>
}