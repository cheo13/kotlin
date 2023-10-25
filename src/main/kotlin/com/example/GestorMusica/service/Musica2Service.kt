package com.example.GestorMusica.service


import com.example.GestorMusica.model.Musica2
import com.example.GestorMusica.repository.Musica1Repository
import com.example.GestorMusica.repository.Musica2Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class Musica2Service {
    //inyeccion de dependencias o clases.
    @Autowired
    lateinit var musica2Repository: Musica2Repository
    @Autowired
    lateinit var musica1Repository: Musica1Repository

    fun list ():List<Musica2>{
        return musica2Repository.findAll()
    }
    fun save(musica2: Musica2): Musica2 {


        try {
            musica1Repository.findById(musica2.id)
                ?: throw Exception("Id del cliente no encontrada")
            return musica2Repository.save(musica2)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }


    fun update(musica2: Musica2): Musica2 {
        try {                   //llama base de datos y devuelve un solo valor de la tabla o registro programado
            musica2Repository.findById(musica2.id)
                ?: throw Exception("ID no existe")
            //'save' sirve para actualizar y guardar el dato ingresado.
            return musica2Repository.save(musica2)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(musica2: Musica2): Musica2 {
        try{        //en caso de que exista el registro se va a posicionar.
            val response = musica2Repository.findById(musica2.id)
                ?: throw Exception("ID no existe")    // nos permite editar el registro que recuperamos de la base de datos

            response.apply {
                //campo de la tabla
                nombrecancion = musica2.nombrecancion
            }
            return musica2Repository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //Se pide un solo registro de la tabla de base de datos.
    fun listById (id:Long?): Musica2?{
        return musica2Repository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = musica2Repository.findById(id)
                ?: throw Exception("ID no existe")
            musica2Repository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){

            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}



