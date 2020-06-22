package com.buergi.practical.Controller

import com.buergi.practical.Model.Cars
import com.buergi.practical.Service.carService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/")
class carController {

    @Autowired
    lateinit var carService: carService

    @GetMapping
    fun getCars(): Collection<Cars>{
        return carService.getCars()
    }
    @GetMapping("/{id}")
    fun getCarById(@PathVariable("id") id: String): Optional<Cars> {
        return carService.getCarById(id)
    }
    @PostMapping("/insert")
    fun insertCar(@RequestBody cars: Cars): Cars {
        return carService.insertCar(cars)
    }
    @PutMapping("/put/{id}")
    fun updateCar(@PathVariable("id") id: String, cars: Cars): ResponseEntity<Cars> {
        return carService.updateCar(id, cars)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteCarById(@PathVariable("id") id: String): Cars? {
        return carService.deleteCarById(id)
    }
}