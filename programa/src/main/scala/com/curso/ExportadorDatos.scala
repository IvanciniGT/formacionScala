package com.curso

import com.curso.dni.{DNI, DNIUtils}

import scala.collection.mutable.ListBuffer

object ExportadorDatos {

    def main(args:Array[String]): Unit = {
        val simuladorDeLaExtraccion = new ListBuffer[String]()
        simuladorDeLaExtraccion.append("23000T")
        simuladorDeLaExtraccion.append("23.000T")
        simuladorDeLaExtraccion.append("00023000T")
        simuladorDeLaExtraccion.append("00.023.000-T")
        simuladorDeLaExtraccion.append("23000A")
        simuladorDeLaExtraccion.append("23000-a")
        simuladorDeLaExtraccion.append("23000$a")
        simuladorDeLaExtraccion.append("23000 t")
        val listaDeDNIsExtraidaDeUnaBBDD = simuladorDeLaExtraccion.toList

        // Programación imperativa
        val dnisValidos = new ListBuffer[DNI]()
        // Quiero saber cuales de esos DNIs son válidos
        for (textoDNI <- listaDeDNIsExtraidaDeUnaBBDD) {
            var dni = DNIUtils.dni(textoDNI)
            if(dni.valido)
                dnisValidos.append(dni)
        }
        println(dnisValidos)
        for (dni <- dnisValidos) {
            println(dni.formatear().get)
        }


        //// Programación funcional
        listaDeDNIsExtraidaDeUnaBBDD.map( DNIUtils.dni )            // Convierto los DNIS a Objetos de Tipo DNI
                                    .filter( dni => dni.valido )     // Me quedo con los válidos
                                    //.filter( filtrarValidos )       // Me quedo con los válidos
                                    .map ( dni => dni.formatear() ) // Me genera textos de nuevo con el formato que quiero
                                    .map ( texto => texto.get )     // Cojo los textos, que los tengo en una caja
                                    .foreach( println )             // Los imprimo

    }
    def filtrarValidos(dni:DNI): Boolean ={
        return dni.valido
    }

}
