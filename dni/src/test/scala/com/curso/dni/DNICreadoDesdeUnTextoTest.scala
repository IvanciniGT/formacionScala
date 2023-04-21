package com.curso.dni

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DNICreadoDesdeUnTextoTest extends AnyFunSuiteLike {

    test("testCrearUnDNIDesdeTextoValido_SinPuntos") {
        val dni = new DNICreadoDesdeUnTexto("23000T")
        dni.numero should equal(Option(23000))
        dni.letra should equal(Option('T'))
        dni.valido should equal(true)
        dni.errores should equal(None)
    }

    test("testCrearUnDNIDesdeTextoValido_ConPuntos") {
        val dni = new DNICreadoDesdeUnTexto("23.000T")
        dni.numero should equal(Option(23000))
        dni.letra should equal(Option('T'))
        dni.valido should equal(true)
        dni.errores should equal(None)
    }

    test("testCrearUnDNIDesdeTextoValido_ConPuntosYSeparador") {
        val dni = new DNICreadoDesdeUnTexto("23.000-T")
        dni.numero should equal(Option(23000))
        dni.letra should equal(Option('T'))
        dni.valido should equal(true)
        dni.errores should equal(None)
    }
    test("testCrearUnDNIDesdeTextoValido_ConPuntosYSeparadorYCerosYMinuscula") {
        val dni = new DNICreadoDesdeUnTexto("00.023.000 t")
        dni.numero should equal(Option(23000))
        dni.letra should equal(Option('T'))
        dni.valido should equal(true)
        dni.errores should equal(None)
    }
    // Pruebas que controlen los DNIs inválidos

}
