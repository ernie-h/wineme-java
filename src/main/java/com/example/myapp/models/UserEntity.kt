package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "user")
class UserEntity(
        val name: String,
        val email: String,
        val myersBriggs: MyersBriggs,
        val favoriteStore: StoreEntity,
        val screenName: String,
        val password: String
) : AbstractModelPersistable<Int>()