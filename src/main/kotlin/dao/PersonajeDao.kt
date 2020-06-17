package dao

import modelo.Personaje

interface PersonajeDao {
    fun serchById(id: Long):Personaje?
    fun nombre(id: Long):String
    fun edad(id: Long):Int
    fun dni(id: Long):Int
    fun personajes():MutableList<Personaje>
    fun eliminar(id: Long)
    fun agregar(personaje: Personaje):Long
}