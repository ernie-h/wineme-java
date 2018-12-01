package com.example.myapp.models

import javax.persistence.Entity

@Entity(name = "store_stocks_wine")
class StoreStocksWineEntity(
        val count: Int,
        val price: Double?,
        val store: StoreEntity,
        val wine: WineEntity
) : AbstractModelPersistable<Int>() {
    constructor(count:Int, store: StoreEntity, wine: WineEntity) : this(count, null, store, wine)
}