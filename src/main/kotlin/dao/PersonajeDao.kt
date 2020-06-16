package dao

import modelo.Personaje

interface PersonajeDao {
    fun serchByDni(dni: Int):Personaje?
    fun nombre(dni:Int):String
    fun edad(dni: Int):Int
    fun personajes():MutableList<Personaje>
    fun eliminar(personaje: Personaje)
    fun agregar(personaje: Personaje):Int
}