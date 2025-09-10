package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserController(private
 val userService: UserService) {

    @GetMapping
    open fun getAllUsers(): ResponseEntity<List<User>>{
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/{email}")
    fun findByEmail(@PathVariable email: String): ResponseEntity<Any>{
        val user = userService.findByEmail(email)
        if(user != null){
            return ResponseEntity.ok(user)
        }else{
            val responseBody = mapOf("error" to "User with email $email does not exist")
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody)
        }
    }
    @PostMapping
    fun addUser(@RequestBody user: User): ResponseEntity<User>{
        val user = userService.addUser(user)
        return ResponseEntity.ok(user)
    }
    @DeleteMapping("/{email}")
    fun deleteUser(@PathVariable email: String): ResponseEntity<String?> {
        val existingUser = this.userService.findByEmail(email)
        if(existingUser != null){
            this.userService.deleteByEmail(email)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User has been deleted")
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with the email $email does not exist")
        }
    }
    @PutMapping
    fun updateUser(@RequestBody user: User): ResponseEntity<Any>{
        val existingUser = this.userService.findByEmail(user.email)
        if(existingUser != null){

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User has been deleted")
        }else {
            val updatedUser = this.userService.updateUser(user)
            return ResponseEntity.status(HttpStatus.OK).body(user)
        }
    }
}