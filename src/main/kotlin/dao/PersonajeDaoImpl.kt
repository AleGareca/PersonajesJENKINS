package dao

import dao.exception.ExceptionDao
import modelo.Personaje
import java.util.concurrent.atomic.AtomicLong

class PersonajeDaoImpl(var personajes: MutableList<Personaje> = mutableListOf()): PersonajeDao  {
    val couter= AtomicLong()

    override fun serchByDni(dni: Int): Personaje? =try {
        personajes.find { p->p.dni== dni }//:? throw  ExceptionDao("El personaje con dni $dni no esta en la base de datos")
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
        personaje.id= couter.incrementAndGet()
        return personaje.dni
    }
}