package dao

import modelo.Personaje

interface PersonajeDao {
    fun serchById(id: Long):Personaje?
    fun nombrePersonaje(id: Long):String
    fun edadPersonaje(id: Long):Int
    fun dniPersonaje(id: Long):Int
    fun todosLosPersonajes():MutableList<Personaje>
    fun eliminar(id: Long)
    fun agregar(personaje: Personaje):Long
}