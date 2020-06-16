package dao

import dao.exception.ExceptionDao
import modelo.Personaje

class PersonajeDaoImpl(var personajes: MutableList<Personaje> = mutableListOf()): PersonajeDao  {
    override fun serchByDni(dni: Int): Personaje? =try {
        personajes.find { p->p.dni== dni }
    }catch (e:Exception){throw ExceptionDao("El personaje con dni $dni no esta en la base de datos")
    }

    override fun edad(dni: Int): Int {
        val personaje= serchByDni(dni)
        return personaje!!.edad

    }

    override fun nombre(dni: Int): String {
        val personaje= serchByDni(dni)
        return personaje!!.nombre
    }

    override fun personajes(): MutableList<Personaje> = personajes


    override fun eliminar(personaje:Personaje) {
        personajes.remove(personaje)
    }

    override fun agregar(personaje: Personaje): Int {
        personajes.add(personaje)
        return personaje.dni
    }
}