package com.example.eletriccar_api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "TB_CAR")
data class Car(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Column(name = "price", nullable = false) var price: BigDecimal,
    @Column(name = "battery", nullable = true) var battery: BigDecimal?,
    @Column(name = "power", nullable = true) var power: BigDecimal?,
    @Column(name = "charge", nullable = true) var charge: BigDecimal?,
    @Column(name = "urlPhoto", nullable = false, unique = true) var urlPhoto: String
)
