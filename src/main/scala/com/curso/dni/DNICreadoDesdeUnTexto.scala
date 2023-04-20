package com.curso.dni

import scala.collection.mutable.ListBuffer

class DNICreadoDesdeUnTexto (textoDNI:String) extends DNIAbstracto {

    // Llamar a la función validarDNI....
    // Y con esos datos rellenar las propiedades del DNI
    override val (numero, letra, valido, errores) = validarDNI()

    private def validarDNI(): (Option[Integer], Option[Char], Boolean, Option[List[String]]) = {
        var letraDelDni: String = null
        var separador: String = null
        var numeroDni: String = ""
        val listaErrores = new ListBuffer[String]() // Doy por supuesto que no hay errores
        var usaPuntos = false

        for (caracterActual <- textoDNI.toUpperCase.toCharArray.reverse) {
            // Comienzo a procesar esos caracteres
            // El primero de esos caracteres debe ser una letra... LA LETRA de control
            if (letraDelDni == null) { // Esto significa que es el primer caracter
                letraDelDni = s"$caracterActual"
                if (caracterActual.isDigit) {
                    listaErrores += "El DNI no tiene Letra de Control"
                } else if (!caracterActual.isLetter) {
                    listaErrores += "El DNI tiene Letra de Control inválida"
                }
            } else { // Ya no estoy en el primer caracter
                // Qué podría encontrar ahora?
                // Si estoy en el segundo caracter, que puede haber aquí?
                if (numeroDni.isEmpty) {
                    //   digito o un caracter de separación (ESPACIO Y GUION)
                    if (caracterActual.isDigit) { // He comenzado a procesar el número
                        numeroDni = s"$caracterActual"
                    } else {
                        if (separador != null) {
                            listaErrores += "Sólo puede introducir un caracter de separación, o un espacio en blanco o un guión"
                        } else {
                            separador = s"$caracterActual"
                            if (caracterActual != ' ' && caracterActual != '-') {
                                listaErrores += "El caracter de separación no es VALIDO. Solo se admite un espacio en blanco o un guión"
                            }
                        }
                    }
                } else {
                    // Si no estoy en el segundo caracter, que puede haber aquí?
                    if (numeroDni.length == 6 && usaPuntos) { // 12.345.678 ->  345678
                        //    en la octava ( y ojo solo cuando exista un punto en la cuarta
                        if (caracterActual != '.') {
                            listaErrores += "Falta el separador de millones"
                        }
                        usaPuntos = false
                    } else if (caracterActual.isDigit) {
                        // Siempre será válido?
                        // Si estoy en la octava posición ... y el la cuarta se había metido un punto...
                        // Esto es válido? NO... aquí tiene que haber un PUNTO
                        numeroDni = s"$caracterActual$numeroDni"
                    } else if (caracterActual == '.') {
                        //    punto... siempre y cuando esté en la cuarta posición del número o
                        if (numeroDni.length == 3) {
                            usaPuntos = true
                        } else {
                            listaErrores += "El separador de miles no está en un sitio correcto"
                        }
                    } else {
                        listaErrores += "Caracter no válido dentro del número del DNI"
                    }
                }
            }
        }
        // El número no puede tener más de 8 dígitos
        if (numeroDni.length > 8) {
            listaErrores += "El número no puede ser mayor que el 99.999.999"
        } else if (numeroDni.length < 1) {
            // Y no puede tener menos de 1
            listaErrores += "No se ha introducido un número de DNI"
        }
        // Y la letra debe ser correcta. Este trabajo me lo planteo si por ahora es valido
        if (listaErrores.isEmpty) {
            if (letraDelDni != DNIUtils.calcularLetraDNI(numeroDni.toInt)) {
                // Y no puede tener menos de 1
                listaErrores += "La letra de control del DNI no coincide con el número"
            }
        }
        // Esto es lo que devolmemos
        (
            // Option[Integer] -> numero
            if (numeroDni.nonEmpty) Option(numeroDni.toInt) else None,
            // Option[Char] -> letra
            if (numeroDni.nonEmpty) Option(letraDelDni.charAt(0)) else None,
            listaErrores.isEmpty,
            if (listaErrores.isEmpty) None else Option(listaErrores.toList)
        )
    }

}