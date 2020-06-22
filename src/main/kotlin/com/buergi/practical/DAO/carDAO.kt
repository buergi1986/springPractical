package com.buergi.practical.DAO

import com.buergi.practical.Model.Cars
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class CarDAO {

    @Autowired
    lateinit var carRepository: CarRepository

    @Override
    fun getCars(): Collection<Cars>{
        return carRepository.findAll()
    }
    @Override
    fun getCarById(id: String): Optional<Cars> {
        return this.carRepository.findById(id)
    }
    @Override
    fun insertCar(cars: Cars): Cars {
        return this.carRepository.insert(cars)
    }
    @Override
    fun updateCar(id: String, cars: Cars): ResponseEntity<Cars> {
        return this.carRepository.findById(id).map { existingCars ->
            val updateCar: Cars = existingCars
                    .copy(  name = cars.name,
                            modell = cars.modell,
                            farbe = cars.farbe,
                            baujahr = cars.baujahr,
                            ps = cars.ps)
            ResponseEntity.ok().body(carRepository.save(updateCar))
        }.orElse(ResponseEntity.notFound().build())
    }

    @Override
    fun deleteCarById(id: String): Cars? {
        val cars: Optional<Cars>? = this.carRepository.findById(id)
        cars?.ifPresent { return@ifPresent this.carRepository.delete(cars.get()) }
        return null
    }
}