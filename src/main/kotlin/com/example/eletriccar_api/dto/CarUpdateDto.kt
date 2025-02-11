package com.example.eletriccar_api.dto

import com.example.eletriccar_api.domain.Car

data class CarUpdateDto (
    val price: Number?,
    val battery: Number?,
    val power: Number?,
    val charge: Number?,
    val urlPhoto: String?
){
    fun toEntity(car: Car): Car {
        car.price = if(this.price != null) this.price else car.price
        car.battery = if(this.battery != null) this.battery else car.battery
        car.power = if(this.power != null) this.power else car.power
        car.charge = if(this.charge != null) this.charge else car.charge
        car.urlPhoto = if(this.urlPhoto != null) this.urlPhoto else car.urlPhoto
        return car
    }

}
