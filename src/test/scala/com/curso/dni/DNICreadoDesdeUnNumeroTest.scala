package com.curso.dni

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DNICreadoDesdeUnNumeroTest extends AnyFunSuiteLike {

    test("testCrearUnDNIDesdeNumeroValido") {
        val dni = new DNICreadoDesdeUnNumero(23000)
        dni.numero should equal(Option(23000))
        dni.letra should equal(Option('T'))
        dni.valido should equal(true)
        dni.errores should equal(None)
    }

    test("testCrearUnDNIDesdeNumeroNoValido_Negativo") {
        val dni = new DNICreadoDesdeUnNumero(-23000)
        dni.numero should equal(None)
        dni.letra should equal(None)
        dni.valido should equal(false)
        dni.errores.get should contain("El número del DNI no puede ser menor que CERO")
        dni.errores.get.length should equal(1)
    }

    test("testCrearUnDNIDesdeNumeroNoValido_Gigante") {
        val dni = new DNICreadoDesdeUnNumero(230000000)
        dni.numero should equal(None)
        dni.letra should equal(None)
        dni.valido should equal(false)
        dni.errores.get should contain("El número del DNI no puede ser mayor o igual a CIEN MILLONES")
        dni.errores.get.length should equal(1)
    }


}
