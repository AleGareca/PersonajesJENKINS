package service

import dao.PersonajeDao
import modelo.Personaje

class ServiceImpl(personajeDaoImpl: PersonajeDao):Service{
    private  var personajeDaoImpl= personajeDaoImpl

    override fun agregarPersonaje(personaje: Personaje): Int =personajeDaoImpl.agregar(personaje)

    override fun personajeByDni(dni:Int): Personaje? = personajeDaoImpl.serchByDni(dni)

    override fun edadDePersonaje(dni:Int): Int = personajeDaoImpl.edad(dni)

    override fun nombrePersonaje(dni:Int): String= personajeDaoImpl.nombre(dni)

    override fun todosLosPersonajes(): List<Personaje> = personajeDaoImpl.personajes()

    override fun eliminarPersonaje(personaje: Personaje) = personajeDaoImpl.eliminar(personaje)
}