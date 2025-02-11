package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car
import java.math.BigDecimal

data class CarUpdateDto (
    val price: BigDecimal?,
    val battery: BigDecimal?,
    val power: BigDecimal?,
    val charge: BigDecimal?,
    val urlPhoto: String?
){
    fun toEntity(car: Car): Car {
        car.price = this.price ?: car.price
        car.battery = this.battery ?: car.battery
        car.power = this.power ?: car.power
        car.charge = this.charge ?: car.charge
        car.urlPhoto = this.urlPhoto ?: car.urlPhoto
        return car
    }

}
