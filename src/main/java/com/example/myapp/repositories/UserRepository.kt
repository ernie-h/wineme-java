package com.example.myapp.repositories

import com.example.myapp.models.UserEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface UserRepository : CrudRepository<UserEntity, Int> {
    @Query("SELECT u FROM User u WHERE u.username=:username")
    fun findUserByUsername(@Param("username") username: String): Optional<UserEntity>

    @Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
    fun findUserByUsernameAndPassword(
            @Param("username") username: String,
            @Param("password") password: String): UserEntity
}