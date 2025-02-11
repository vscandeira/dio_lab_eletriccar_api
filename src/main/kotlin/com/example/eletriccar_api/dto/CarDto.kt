package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car

class CarDto (
    val price: Number,
    val battery: Number,
    val power: Number,
    val charge: Number,
    val urlPhoto: String
) {
    fun toEntity(): Car = Car(
        price = this.price,
        battery = this.battery,
        power = this.power,
        charge = this.charge,
        urlPhoto = this.urlPhoto
    )
}
