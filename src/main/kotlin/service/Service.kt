package service

import modelo.Personaje

interface Service {
    fun agregarPersonaje(personaje: Personaje):Long
    fun personajeById(id: Long):Personaje?
    fun edadDePersonaje(id: Long):Int
    fun dniDePersonaje(id: Long):Int
    fun nombrePersonaje(id: Long):String
    fun todosLosPersonajes():List<Personaje>
    fun eliminarPersonaje(id: Long)
}