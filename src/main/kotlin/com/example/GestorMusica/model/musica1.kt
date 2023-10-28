package com.example.GestorMusica.model

import jakarta.persistence.*

@Entity
    @Table(name = "musica1")
    class Musica1 {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null    //? permite valores nulos
        var tec_music: String? = null
        var reg_music: String? = null
        var cum_music: String? = null
        var sal_music: String? = null
        var dee_music: String? = null

    }


//Anotaciones :tIENEN UN @     @Autowired ---Informacion sumplementaria del codigo   metadatos...
//Son procesador por el compilador-
//


