package com.example.eletriccar_api.service.impl

import com.example.eletriccar_api.domain.Car
import com.example.eletriccar_api.repository.CarRepository
import com.example.eletriccar_api.service.ICarService
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CarService(
    private val carRepository: CarRepository
): ICarService {
    override fun saveCar(car: Car): Car {
        return this.carRepository.save(car)
    }

    override fun findAllCars(): List<Car> {
        return this.carRepository.findAll()
    }

    override fun findCarById(carId: Long): Car {
        return this.carRepository.findById(carId).orElseThrow{
            throw RuntimeException("Id $carId not found")
        }
    }

    override fun deleteCar(carId: Long) {
        this.carRepository.deleteById(carId)
    }
}