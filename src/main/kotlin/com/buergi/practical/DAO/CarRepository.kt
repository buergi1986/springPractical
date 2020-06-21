package com.buergi.practical.DAO

import com.buergi.practical.Model.Cars
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository:MongoRepository<Cars, String> {
}