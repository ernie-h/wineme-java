package com.example.myapp.models

import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity(name = "store")
class StoreEntity(
        @get: NotBlank
        var name: String,
        var longitude: Long,
        var latitude: Long
) : AbstractModelPersistable<Int>()