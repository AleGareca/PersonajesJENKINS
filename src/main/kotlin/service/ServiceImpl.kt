package service

import dao.PersonajeDao
import modelo.Personaje


class ServiceImpl(personajeDaoImpl: PersonajeDao):Service{
    private  var personajeDaoImpl= personajeDaoImpl

    override fun agregarPersonaje(personaje: Personaje): Long =personajeDaoImpl.agregar(personaje)

    override fun personajeById(id: Long): Personaje? = personajeDaoImpl.serchById(id)

    override fun edadDePersonaje(id: Long): Int = personajeDaoImpl.edad(id)

    override fun dniDePersonaje(id: Long): Int = personajeDaoImpl.dni(id)

    override fun nombrePersonaje(id: Long): String= personajeDaoImpl.nombre(id)

    override fun todosLosPersonajes(): List<Personaje> = personajeDaoImpl.personajes()

    override fun eliminarPersonaje(id: Long) = personajeDaoImpl.eliminar(id)
}