package service.interfaz

import modelo.Personaje

interface Service {

    fun personajeByDni(dni:Int):Personaje?
    fun edadDePersonaje(dni:Int):Int
    fun nombrePersonaje(dni:Int):String
    fun todosLosPersonajes():List<Personaje>
    fun eliminarPersonaje(personaje: Personaje)

}