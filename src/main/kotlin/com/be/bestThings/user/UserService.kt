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

    fun removeUser(user: User): String {
        val existingUser: Optional<User> =
            userRepository.findUserByUsername(user.username)

        if (existingUser.isEmpty) throw IllegalStateException("User not found")

        val correctPassword = BCrypt.checkpw(user.password, existingUser.get().password)
        if (!correctPassword) throw IllegalStateException("Incorrect password")

        userRepository.delete(existingUser.get())
        return "User successfully deleted"
    }
}