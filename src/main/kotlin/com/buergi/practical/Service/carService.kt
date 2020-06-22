package com.buergi.practical.Service

import com.buergi.practical.DAO.CarDAO
import com.buergi.practical.Model.Cars
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class carService {

    @Autowired
    lateinit var carDAO: CarDAO

    fun getCars(): Collection<Cars>{
        return carDAO.getCars()
    }
    @Override
    fun getCarById(id: String): Optional<Cars> {
        return carDAO.getCarById(id)
    }
    @Override
    fun insertCar(cars: Cars): Cars {
        return carDAO.insertCar(cars)
    }
    @Override
    fun updateCar(id: String, cars: Cars): ResponseEntity<Cars> {
        return carDAO.updateCar(id, cars)
    }
    @Override
    fun deleteCarById(id: String): Cars? {
        return carDAO.deleteCarById(id)
    }
}