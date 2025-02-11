package com.example.eletriccar_api

import com.example.eletriccar_api.domain.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository: JpaRepository<Car, Long> {
}