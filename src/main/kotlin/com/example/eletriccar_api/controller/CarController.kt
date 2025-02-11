package com.example.eletriccar_api.controller

import com.example.eletriccar_api.dto.CarDto
import com.example.eletriccar_api.dto.CarUpdateDto
import com.example.eletriccar_api.dto.CarView
import com.example.eletriccar_api.service.impl.CarService
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cars")
class CarController(
    private val carService: CarService
) {
    @PostMapping("/save")
    fun saveCar(@RequestBody carDto: CarDto): ResponseEntity<String> {
        val savedCar = this.carService.saveCar(carDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Car ${savedCar.id} saved successfully")
    }

    @GetMapping("/")
    fun findAllCars() : ResponseEntity<List<CarView>> {
        val cars = this.carService.findAllCars()
        val carsV : MutableList<CarView> = mutableListOf()
        for (car in cars){
            carsV.add(CarView(car))
        }
        return ResponseEntity.status(HttpStatus.OK).body(carsV)
    }

    @GetMapping("/{carId}")
    fun findCarById(@PathVariable carId: Long) : ResponseEntity<CarView> {
        val car = this.carService.findCarById(carId)
        return ResponseEntity.status(HttpStatus.OK).body(CarView(car))
    }

    @DeleteMapping("/delete")
    fun deleteCarById(@RequestParam carId: Long) : ResponseEntity<String> {
        this.carService.deleteCar(carId)
        return ResponseEntity.status(HttpStatus.OK).body("Car $carId deleted successfuly")
    }

    @PutMapping("/update")
    fun updateCar(@RequestParam carId: Long, @RequestBody carUpdateDto: CarUpdateDto): ResponseEntity<CarView> {
        val oldCar = this.carService.findCarById(carId)
        val newCar = carUpdateDto.toEntity(oldCar)
        this.carService.saveCar(newCar)
        return ResponseEntity.status(HttpStatus.OK).body(CarView(newCar))
    }

}