package com.curso.dni

private class DNICreadoDesdeUnNumero (numeroSuministrado:Integer) extends DNIAbstracto {

    override val (numero, letra, valido, errores) = validarDNI()

    private def validarDNI(): (Option[Integer], Option[Char], Boolean, Option[List[String]]) = {
        var letraDelDni: String = null
        var numeroDni: Integer = 0
        var error: String = null // Doy por supuesto que no hay errores

        if (numeroSuministrado <= 0) {
            error = "El número del DNI no puede ser menor que CERO"
        } else if (numeroSuministrado >= 100000000) {
            error = "El número del DNI no puede ser mayor o igual a CIEN MILLONES"
        } else {
            numeroDni = numeroSuministrado
            letraDelDni = DNIUtils.calcularLetraDNI(numeroSuministrado)
        }
        // Devuelvo
        (
            // Option[Integer] -> numero
            if (numeroDni != 0) Option(numeroDni) else None,
            // Option[Char] -> letra
            if (letraDelDni != null) Option(letraDelDni.charAt(0)) else None,
            error == null,
            if (error == null) None else Option(List(error))
        )
    }

}



