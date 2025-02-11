package com.example.eletriccar_api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TB_CAR")
data class Car(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    @Column(nullable = false) var price: String,
    @Column(nullable = true) var battery: String,
    @Column(nullable = true) var power: String,
    @Column(nullable = true) var charge: String,
    @Column(nullable = false, unique = true) var urlPhoto: String
)
