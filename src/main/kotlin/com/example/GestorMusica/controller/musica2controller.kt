package com.example.GestorMusica.controller

import com.example.GestorMusica.model.Musica2
import com.example.GestorMusica.service.Musica2Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/musica2")   //endpoint
class musica2controller {
    @Autowired
    lateinit var musica2Service: Musica2Service

    @GetMapping
    fun list ():List <Musica2>{
        return musica2Service.list()
    }
    @PostMapping
    fun save (@RequestBody musica2: Musica2): ResponseEntity<Musica2> {
        return ResponseEntity(musica2Service.save(musica2), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody musica2: Musica2): ResponseEntity<Musica2> {
        return ResponseEntity(musica2Service.update(musica2), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody musica2: Musica2): ResponseEntity<Musica2> {
        return ResponseEntity(musica2Service.updateName(musica2), HttpStatus.OK)
    }
    //mapea unicamente el registro programado con diferente ruta http /codigorequerido....
    @GetMapping("/{tech_id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(musica2Service.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return musica2Service.delete(id)
    }

}
