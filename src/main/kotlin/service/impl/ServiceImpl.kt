package service.impl

import dao.impl.PersonajeDaoImpl
import modelo.Personaje
import service.interfaz.Service

class ServiceImpl(personajeDaoImpl: PersonajeDaoImpl):Service {
    private var personajeDao=personajeDaoImpl
    override fun personajeByDni(dni:Int): Personaje? = personajeDao.serchByDni(dni)

    override fun edadDePersonaje(dni:Int): Int = personajeDao.edad(dni)

    override fun nombrePersonaje(dni:Int): String= personajeDao.nombre(dni)

    override fun todosLosPersonajes(): List<Personaje> = personajeDao.personajes()

    override fun eliminarPersonaje(personaje: Personaje) = personajeDao.eliminar(personaje)
}