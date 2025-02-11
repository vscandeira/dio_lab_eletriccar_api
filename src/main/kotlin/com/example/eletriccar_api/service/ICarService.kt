package com.example.eletriccar_api.service

import com.example.eletriccar_api.domain.Car
import java.util.Optional

interface ICarService {
    fun saveCar(car: Car): Car
    fun findAllCars(): List<Car>
    fun findCarById(carId: Long): Car
    fun deleteCar(carId: Long)
}