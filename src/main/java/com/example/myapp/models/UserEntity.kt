package com.example.myapp.models

import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity(name = "user")
class UserEntity(
        @get: NotBlank
        var name: String,
        @get: NotBlank
        var email: String,
        var myersBriggs: MyersBriggs,
        var favoriteStore: StoreEntity?,
        @get: NotBlank
        var screenName: String,
        @get: NotBlank
        var password: String
) : AbstractModelPersistable<Int>() {
    constructor(name: String, email: String, myersBriggs: MyersBriggs, screenName: String, password: String)
            : this(name, email, myersBriggs, null, screenName, password)
}