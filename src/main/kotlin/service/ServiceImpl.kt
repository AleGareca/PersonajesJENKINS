package service

import dao.PersonajeDao
import modelo.Personaje


class ServiceImpl(personajeDaoImpl: PersonajeDao):Service{
    private  var personajeDaoImpl= personajeDaoImpl

    override fun agregarPersonaje(personaje: Personaje): Long =personajeDaoImpl.agregar(personaje)

    override fun personajeById(id: Long): Personaje? = personajeDaoImpl.serchById(id)

    override fun edadDePersonaje(id: Long): Int = personajeDaoImpl.edadPersonaje(id)

    override fun dniDePersonaje(id: Long): Int = personajeDaoImpl.dniPersonaje(id)

    override fun nombrePersonaje(id: Long): String= personajeDaoImpl.nombrePersonaje(id)

    override fun todosLosPersonajes(): List<Personaje> = personajeDaoImpl.todosLosPersonajes()

    override fun eliminarPersonaje(id: Long) = personajeDaoImpl.eliminar(id)
}