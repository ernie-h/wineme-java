package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "wine_type")
class WineTypeEntity(
    val wineType: String
) : AbstractModelPersistable<Int>()