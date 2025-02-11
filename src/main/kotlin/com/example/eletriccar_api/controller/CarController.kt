package com.example.eletriccar_api.controller

import com.example.eletriccar_api.dto.CarDto
import com.example.eletriccar_api.dto.CarUpdateDto
import com.example.eletriccar_api.dto.CarView
import com.example.eletriccar_api.service.impl.CarService
import jakarta.websocket.server.PathParam
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
@RequestMapping("/api/car")
class CarController(
    private val carService: CarService
) {
    @PostMapping
    fun saveCar(@RequestBody carDto: CarDto): String{
        val savedCar = this.carService.saveCar(carDto.toEntity())
        return "Car ${savedCar.id} saved successfully"
    }

    @GetMapping("/{car_id}")
    fun findCarById(@PathVariable car_id: Long) : CarView {
        val car = this.carService.findCarById(car_id)
        return CarView(car)
    }

    @DeleteMapping("/delete")
    fun deleteCarById(@RequestParam car_id: Long):String {
        this.carService.deleteCar(car_id)
        return "Car $car_id deleted successfuly"
    }

    @PutMapping("/update")
    fun updateCar(@RequestParam car_id: Long, @RequestBody carUpdateDto: CarUpdateDto): CarView{
        val oldCar = this.carService.findCarById(car_id)
        val newCar = carUpdateDto.toEntity(oldCar)
        this.carService.saveCar(newCar)
        return CarView(newCar)
    }
}