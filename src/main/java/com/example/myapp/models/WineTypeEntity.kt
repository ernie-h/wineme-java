package com.example.myapp.models

import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity(name = "wine_type")
class WineTypeEntity(
        @get: NotBlank
        var wineType: String
) : AbstractModelPersistable<Int>()