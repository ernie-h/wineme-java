package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "user_reviews_wine")
class UserReviewsWineEntity(
        val rating: Boolean,
        val reviewer: UserEntity,
        val reviewedWine: WineEntity
) : AbstractModelPersistable<Int>() {
}