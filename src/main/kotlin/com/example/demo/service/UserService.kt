package com.example.demo.service

import com.example.demo.entity.User

interface UserService{
    fun findByEmail(email: String): User?
    fun addUser(user: User): User
    fun getAllUsers(): List<User>
    fun deleteByEmail(email: String)
    fun updateUser(user: User): User
}