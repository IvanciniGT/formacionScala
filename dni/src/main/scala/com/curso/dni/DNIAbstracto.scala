package com.curso.dni

private abstract class DNIAbstracto extends DNI {

    def formatear(puntosMiles: Boolean = false,
                  cerosDelante: Boolean = false,
                  mostrarLetra: Boolean = true,
                  letraMayuscula: Boolean = true,
                  caracterSeparacion: String = ""): Option[String] = {

        if (!valido) return None
        // Extrae el contenido del Option
        var parteNumerica = s"${numero.get}"
        if (cerosDelante) {
            parteNumerica = s"0000000$parteNumerica"
            parteNumerica = parteNumerica.substring(parteNumerica.length - 8)
        }
        if (puntosMiles && parteNumerica.length > 3) { // pondré puntos de miles
            if (parteNumerica.length > 6) { // Tambie´n puntos de millones
                val unidades = parteNumerica.substring(parteNumerica.length - 3)
                val miles = parteNumerica.substring(parteNumerica.length - 6, parteNumerica.length - 3)
                val millones = parteNumerica.substring(0, parteNumerica.length - 6)
                parteNumerica = s"$millones.$miles.$unidades"
            } else {
                // Solo los de miles
                val unidades = parteNumerica.substring(parteNumerica.length - 3)
                val miles = parteNumerica.substring(0, parteNumerica.length - 3)
                parteNumerica = s"$miles.$unidades"
            }

        }
        var dniFormateado: String = s"$parteNumerica"
        if (mostrarLetra) {
            dniFormateado = s"$dniFormateado$caracterSeparacion${letra.get}"
            if (letraMayuscula)
                dniFormateado = dniFormateado.toUpperCase
            else
                dniFormateado = dniFormateado.toLowerCase
        }
        Option(dniFormateado)
    }
}