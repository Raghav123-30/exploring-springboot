package com.example.demo.repository

import com.example.demo.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String>{
    fun findByEmail(email: String): User?
    fun deleteByEmail(email: String)
}