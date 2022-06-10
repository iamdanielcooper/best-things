package com.be.bestThings.user

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun addUser(@RequestBody newUser: User) = userService.addUser(newUser)

}