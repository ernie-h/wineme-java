package com.example.myapp.models

import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "store_stocks_wine")
class StoreStocksWineEntity(
        @Column(name = "stock_count")
        var count: Int,
        @Column(name = "price")
        var price: Double?,
        @Column(name = "store")
        var store: StoreEntity,
        @Column(name = "wine")
        var wine: WineEntity
) : AbstractModelPersistable<Int>() {
    constructor(count: Int, store: StoreEntity, wine: WineEntity) : this(count, null, store, wine)
}