import dao.impl.PersonajeDaoImpl
import modelo.Personaje
import org.junit.*
import service.impl.ServiceImpl

class ServiceImplTest {
   private  val dao= PersonajeDaoImpl()
   private val serviceImpl= ServiceImpl(dao)
   lateinit var personaje:Personaje

   @Before
    fun setDeDatos(){
     personaje= Personaje(38,"Ale",25)


    }

    @Test
    fun `el servicio crea un personaje con dni 38 nombre ale edad 25 años- Y se agrega al DAO `(){
     serviceImpl.agregarPersonaje(personaje)
     val cantiadaDePersonajesEnDao=dao.personajes.size
     assert(cantiadaDePersonajesEnDao==1)
    }




}