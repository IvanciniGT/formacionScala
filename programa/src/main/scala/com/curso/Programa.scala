package com.curso

import com.curso.dni.DNIUtils
class Programa {

    def main(args:Array[String]): Unit = {
        val miDNI = DNIUtils.dni("72637263T")
        println(miDNI.valido)
    }

}
