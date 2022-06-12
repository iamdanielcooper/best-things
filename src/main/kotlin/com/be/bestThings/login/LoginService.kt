package com.be.bestThings.login

import com.be.bestThings.user.User
import com.be.bestThings.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.*


@Service
class LoginService(private val userRepository: UserRepository) {
    fun loginUser(user: User): String {
        val existingUser: Optional<User> =
            userRepository.findUserByUsername(user.username)

        if (existingUser.isEmpty) throw IllegalStateException("User not found")

        val correctPassword = BCrypt.checkpw(user.password, existingUser.get().password)
        if (!correctPassword) throw IllegalStateException("Incorrect password")

        return "User logged in successfully."
    }
}