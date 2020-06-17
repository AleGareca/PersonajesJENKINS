package dao

import dao.exception.ExceptionDao
import modelo.Personaje
import java.util.concurrent.atomic.AtomicLong

class PersonajeDaoImpl(var personajes: MutableList<Personaje> = mutableListOf()): PersonajeDao  {
    val couter= AtomicLong()

    override fun serchById(id: Long): Personaje? =try {
        personajes.find { p->p.id== id }//:? throw  ExceptionDao("El personaje con dni $dni no esta en la base de datos")
    }catch (e:Exception){throw ExceptionDao("El personaje con id $id no esta en la base de datos")
    }

    override fun edadPersonaje(id: Long): Int {
        val personaje= serchById(id)
        return personaje!!.edad

    }

    override fun dniPersonaje(id: Long): Int {
        val personaje= serchById(id)
        return personaje!!.dni
    }

    override fun nombrePersonaje(id: Long): String {
        val personaje= serchById(id)
        return personaje!!.nombre
    }

    override fun todosLosPersonajes(): MutableList<Personaje> = personajes


    override fun eliminar(id: Long) {
        personajes.removeIf {p->p.id==id}
    }

    override fun agregar(personaje: Personaje): Long {
        personajes.add(personaje)
        personaje.id= couter.incrementAndGet()
        return personaje.id!!
    }
}