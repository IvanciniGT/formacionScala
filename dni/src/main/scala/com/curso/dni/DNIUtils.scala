package com.curso.dni


object DNIUtils { // Clase de la que solo hay una instancia, creada automaticamente por SCALA: SINGLETON
    def calcularLetraDNI(numero: Integer): String = {
        "TRWAGMYFPDXBNJZSQVHLCKE".substring(numero % 23,numero % 23+1)
    }

    def dni(numero: Integer): DNI = {
        new DNICreadoDesdeUnNumero(numero)
    }

    def dni(texto: String): DNI = {
        new DNICreadoDesdeUnTexto(texto)
    }
}