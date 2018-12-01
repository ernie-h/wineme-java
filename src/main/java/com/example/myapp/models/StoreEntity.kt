package com.example.myapp.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity(name = "store")
class StoreEntity(
        @get: NotBlank
        @Column(name = "store_name")
        var name: String,
        @Column(name = "store_longitude")
        var longitude: Long,
        @Column(name = "store_latitude")
        var latitude: Long
) : AbstractModelPersistable<Int>()