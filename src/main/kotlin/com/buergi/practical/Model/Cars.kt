package com.buergi.practical.Model


@Document(collection = "cars")
class Cars @Id @Generated var _id: String? = null,
var name: String,
var modell: String,
var farbe: String,
var baujahr: Int = 0,
var ps: Int = 0) {

    fun copy(name: String,
             modell: String,
             farbe: String,
             baujahr: Int,
             ps: Int) = Cars(_id, name, modell, farbe, baujahr, ps)
}