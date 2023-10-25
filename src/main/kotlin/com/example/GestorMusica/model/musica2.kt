package com.example.GestorMusica.model

import jakarta.persistence.*

@Entity
@Table(name = "musica2")
class Musica2 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null    //? permite valores nulos
    @Column (name = "nombre_cancion")
    var nombrecancion: String? = null
    var artista: String? = null
    var album: String? = null
    @Column (name = "año_lanzamiento")
    var anolanzamiento: Long? = null
    var genero: String? = null
    var duracion: Long? = null
    @Column (name = "formato_audio")
    var formatoaudio: String? = null
}