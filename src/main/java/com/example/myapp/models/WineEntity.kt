package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "wine")
class WineEntity(
        val name: String,
        val flavorProfile: String,
        val wineTypeEntity: WineTypeEntity // foreign key on WineTypeEntity
) : AbstractModelPersistable<Int>()