package com.example.GestorMusica.controller

import com.example.GestorMusica.model.Musica1
import com.example.GestorMusica.service.Musica1Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/musica1")   //endpoint
class musica1controller {
    @Autowired
    lateinit var musica1Service: Musica1Service

    @GetMapping
    fun list ():List <Musica1>{
        return musica1Service.list()
    }
    @PostMapping
    fun save (@RequestBody musica1:Musica1):ResponseEntity<Musica1>{
        return ResponseEntity(musica1Service.save(musica1), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody musica1: Musica1):ResponseEntity<Musica1>{
        return ResponseEntity(musica1Service.update(musica1), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody musica1: Musica1):ResponseEntity<Musica1>{
        return ResponseEntity(musica1Service.updateName(musica1), HttpStatus.OK)
    }
    //mapea unicamente el registro programado con diferente ruta http /codigorequerido....
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(musica1Service.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return musica1Service.delete(id)
    }

}
