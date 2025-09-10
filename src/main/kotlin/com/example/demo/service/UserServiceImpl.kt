package com.example.demo.service

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private  val userRepository: UserRepository): UserService {
    override fun findByEmail(email: String): User? {
        return this.userRepository.findByEmail(email)
    }

    override fun addUser(user: User): User {
        return this.userRepository.save(user)
    }

    override fun getAllUsers(): List<User> {
        return this.userRepository.findAll()
    }

    override fun deleteByEmail(email: String) {
        return this.userRepository.deleteByEmail(email)
    }

    override fun updateUser(user: User): User {
        return this.userRepository.save(user)
    }


}