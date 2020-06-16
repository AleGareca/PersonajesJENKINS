package modelo

import org.springframework.boot.autoconfigure.domain.EntityScan

@EntityScan
class Personaje(dni:Int,nombre:String,edad:Int){
    
    var id:Long?=null
    var nombre=nombre
    var edad =edad
    var dni=dni
}