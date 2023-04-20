package com.curso.dni

object DNIUtils { // Clase de la que solo hay una instancia, creada automaticamente por SCALA: SINGLETON
    def calcularLetraDNI(numero: Integer): String = {
        "TRWAGMYFPDXBNJZSQVHLCKE".substring(numero % 23,numero % 23+1)
    }

}