package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car
import java.math.BigDecimal

class CarDto (
    private val price: BigDecimal,
    private val battery: BigDecimal?,
    private val power: BigDecimal?,
    private val charge: BigDecimal?,
    private val urlPhoto: String
) {
    fun toEntity(): Car = Car(
        price = this.price,
        battery = this.battery,
        power = this.power,
        charge = this.charge,
        urlPhoto = this.urlPhoto
    )
}
