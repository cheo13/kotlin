package com.example.GestorMusica.repository

import com.example.GestorMusica.model.Musica2
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Musica2Repository : JpaRepository<Musica2, Long?> {
    //funcion que representa conexion
    fun findById (id: Long?): Musica2?


}