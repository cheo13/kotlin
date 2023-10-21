package com.example.GestorMusica.repository

import com.example.GestorMusica.model.Musica1
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
  //representante de la base de datos
@Repository
interface Musica1Repository : JpaRepository<Musica1, Long?> {
  //funcion que representa conexion
    fun findById (id: Long?): Musica1?


}