package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car
import java.math.BigDecimal

data class CarView (
    val id : Long?,
    val price: BigDecimal,
    val battery: BigDecimal?,
    val power: BigDecimal?,
    val charge: BigDecimal?,
    val urlPhoto: String
){
    constructor(car: Car): this (
        id = car.id,
        price = car.price,
        battery = car.battery,
        power = car.power,
        charge = car.charge,
        urlPhoto = car.urlPhoto
    )
}
