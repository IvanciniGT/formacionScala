package com.curso.dni

import scala.collection.mutable.ListBuffer

// Inversion de dependencias                                              ~ Inyección de dependencias
object ProgramaPruebasDNI {
    def main(argumentos:Array[String]): Unit = {
        val dni1 : DNI = new DNICreadoDesdeUnTexto("23.000T") // TODO... ya veremos de donde saco ese valor ("230000-T")
        println(dni1.numero)
        println(dni1.letra)
        println(dni1.valido)
        println(dni1.errores)
        println(dni1.formatear(false, false, false, false, null))
        println(dni1.formatear(true, true, false, false, null))
        println(dni1.formatear(false, false, true, false, ""))
        println(dni1.formatear(true, true, true, false, "."))
        println(dni1.formatear(true, false, true, true, "-"))
        println(dni1.formatear())
        println(dni1.formatear(letraMayuscula = false))

        val dni2: DNI = new DNICreadoDesdeUnNumero(2003000)
        println(dni2.numero)
        println(dni2.letra)
        println(dni2.valido)
        println(dni2.errores)
        println(dni2.formatear(puntosMiles=true, caracterSeparacion = " "))

    }
}