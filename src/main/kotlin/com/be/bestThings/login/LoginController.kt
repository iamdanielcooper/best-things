package com.be.bestThings.login

import com.be.bestThings.user.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/login")
class LoginController(private val loginService: LoginService) {
    @PatchMapping
    fun loginUser(@RequestBody user: User) = loginService.loginUser(user)
}