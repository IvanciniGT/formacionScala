package com.curso.dni

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}

class DNIUtilsTest extends AnyFunSuiteLike {

    test("test1CalcularLetraDNI") {
        val letraDevuelta = DNIUtils.calcularLetraDNI(23000)
        val letraEsperada = "T"
        letraDevuelta should equal(letraEsperada)
    }
    test("test2CalcularLetraDNI") {
        val letraDevuelta = DNIUtils.calcularLetraDNI(23011)
        val letraEsperada = "B"
        letraDevuelta should equal(letraEsperada)
    }

}
