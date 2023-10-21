CREATE TABLE IF NOT EXISTS musica1 (
    id SERIAL,
    tec_music VARCHAR(50) NOT NULL,
    reg_music VARCHAR(50) NOT NULL,
    cum_music VARCHAR(50) NOT NULL,
    sal_music VARCHAR(50) NOT NULL,
    dee_music VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS musica2 (
    id SERIAL,
    nombre_cancion VARCHAR(100) NOT NULL,
    artista VARCHAR(100) NOT NULL,
    album VARCHAR(100) NOT NULL,
    año_lanzamiento INT,
    genero VARCHAR(50) NOT NULL,
    duracion INT,
    formato_audio VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES musica1(id)
    );
