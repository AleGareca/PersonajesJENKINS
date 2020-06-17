package com.example.demo

import dao.PersonajeDaoImpl
import modelo.Personaje
import org.junit.jupiter.api.*
import org.springframework.boot.test.context.SpringBootTest
import service.ServiceImpl


@SpringBootTest
class  ServiceTests {

	private val dao= PersonajeDaoImpl()
	private val serviceImpl= ServiceImpl(dao)
	lateinit var personaje:Personaje
	lateinit var personaje2:Personaje
	var idPersonaje: Long = 0


	@BeforeEach
	fun setDeDatos(){
		personaje= Personaje(38,"Ale",25)
		personaje2= Personaje(11,"Maria",25)
		idPersonaje=serviceImpl.agregarPersonaje(personaje2)
	}

	@Test
	fun `el servicio crea un personaje y al llegar al dao se le asigna un Id- Y se agrega al DAO `(){
		val idDelPersonajeCreado=serviceImpl.agregarPersonaje(personaje)
		assert(idDelPersonajeCreado==personaje.id)
	}
	@Test
	fun `dado un id retorna un personaje con ese id si existe en el dao`(){

		val personajeRecuperado=serviceImpl.personajeById(idPersonaje)
		assert(personajeRecuperado!!.id== idPersonaje)
	}
	@Test
	fun `dao un id se retorna la edad del personaje con ese id`(){
		val edadDelPersonajeRecuperado=serviceImpl.edadDePersonaje(idPersonaje)
		val edadDelPersonaje= serviceImpl.personajeById(idPersonaje)!!.edad
		assert(edadDelPersonajeRecuperado==edadDelPersonaje)
	}

	@Test
	fun `dao un id se retorna el nombre del personaje con ese id`(){
		val nombreDelPersonajeRecuperado=serviceImpl.nombrePersonaje(idPersonaje)
		val nombreDelPersonaje= serviceImpl.personajeById(idPersonaje)!!.nombre
		assert(nombreDelPersonajeRecuperado==nombreDelPersonaje)
	}
	@Test
	fun `dao un id se retorna el dni del personaje con ese id`(){
		val dniDelPersonajeRecuperado=serviceImpl.dniDePersonaje(idPersonaje)
		val dniDelPersonaje= serviceImpl.personajeById(idPersonaje)!!.dni
		assert(dniDelPersonajeRecuperado==dniDelPersonaje)
	}

	@Test
	fun `el servicio puede retornar todos los personajes almacenados`(){
		val cantidadDePersonajesEnDao= dao.personajes.size
		assert(cantidadDePersonajesEnDao==1)
	}

	@Test
	fun `se puede eliminar a un personaje con un id`(){
		serviceImpl.eliminarPersonaje(idPersonaje)
		val cantidadDePersonajesEnDao= dao.personajes.size
		assert(cantidadDePersonajesEnDao==0)
	}





}
