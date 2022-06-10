package com.be.bestThings.user

import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun addUser(newUser: User): String {
        val existingUser: Optional<User> =
            userRepository.findUserByUsername(newUser.username)

        if (existingUser.isPresent) throw IllegalStateException("Username already taken")

        newUser.password =
            BCrypt.hashpw(newUser.password, BCrypt.gensalt())

        userRepository.save(newUser)
        return "User successfully created"
    }
}