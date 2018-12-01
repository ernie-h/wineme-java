package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "user_reviews_wine")
class UserReviewsWineEntity(
        var rating: Boolean,
        var reviewer: UserEntity,
        var reviewedWine: WineEntity
) : AbstractModelPersistable<Int>() {
}