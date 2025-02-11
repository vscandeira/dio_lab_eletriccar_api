package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car

data class CarView (
    val id : Long?,
    val price: Number,
    val battery: Number,
    val power: Number,
    val charge: Number,
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
