package com.example.demo

import dao.PersonajeDaoImpl
import modelo.Personaje
import org.springframework.web.bind.annotation.*
import service.ServiceImpl


@RestController
class PersonajeController {

    private val service = ServiceImpl(PersonajeDaoImpl())

    @PostMapping("/create")
    fun crearPersonaje(@RequestBody personaje: Personaje) {
         service.agregarPersonaje(personaje)
    }
}