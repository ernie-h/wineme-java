package com.example.myapp.models

import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity(name = "wine")
class WineEntity(
        @get: NotBlank
        var name: String,
        @get: NotBlank
        var flavorProfile: String,
        var wineTypeEntity: WineTypeEntity // foreign key on WineTypeEntity
) : AbstractModelPersistable<Int>()