package com.example.GestorMusica.service

import com.example.GestorMusica.model.Musica1
import com.example.GestorMusica.repository.Musica1Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class Musica1Service {
    //inyeccion de dependencias o clases.
    @Autowired
    lateinit var musica1Repository: Musica1Repository

    fun list ():List<Musica1>{
        return musica1Repository.findAll()
    }
    fun save(musica1: Musica1): Musica1 {
        try{
            return musica1Repository.save(musica1)
        }
        catch (ex:Exception){  //LANZA UN ERROR para ser manejado por el programador el cual debe hacerlo de una manera mas descriptiva.
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun update(musica1: Musica1): Musica1 {
        try {                   //llama base de datos y devuelve un solo valor de la tabla o registro programado
            musica1Repository.findById(musica1.id)
                ?: throw Exception("ID no existe")
                                        //'save' sirve para actualizar y guardar el dato ingresado.
            return musica1Repository.save(musica1)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(musica1: Musica1): Musica1 {
        try{        //en caso de que exista el registro se va a posicionar.
            val response = musica1Repository.findById(musica1.id)
                ?: throw Exception("ID no existe")    // nos permite editar el registro que recuperamos de la base de datos

            response.apply {
                //campo de la tabla
                tec_music = musica1.tec_music
            }
            return musica1Repository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
   //Se pide un solo registro de la tabla de base de datos.
    fun listById (id:Long?):Musica1?{
        return musica1Repository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = musica1Repository.findById(id)
                ?: throw Exception("ID no existe")
            musica1Repository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){

            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}
