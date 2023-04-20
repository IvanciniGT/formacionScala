package com.curso

import scala.collection.mutable.ListBuffer

// Inversion de dependencias                                              ~ Inyección de dependencias
object MiPrograma {
  def main(argumentos:Array[String]): Unit = {
    var dni1 : DNI = null // TODO... ya veremos de donde saco ese valor ("230000-T")
    dni1.valido
    dni1.numero
    dni1.formatear(false, false, false, false, null)
    dni1.formatear(true, true, true, true, null)
    dni1.formatear(true, false, true, false, null)

  }
}
////////
trait DNI {

  val numero:   Option[Integer] // El dato lo puedo tener o no.... Opcional
  val letra:    Option[Char]
  val valido:   Boolean
  val errores:  Option[List[String]]
  def formatear(puntos: Boolean,
                cerosDelante: Boolean,
                letra:Boolean,
                letraMayuscula: Boolean,
                caracterSeparacion: Char): String
}

class DNICreadoDesdeUnTexto (textoDNI:String) extends DNI {

  // Llamar a la función validarDNI....
  // Y con esos datos rellenar las propiedades del DNI
  override val (numero, letra, valido, errores) = validarDNI()

  def validarDNI(): ( Option[Integer], Option[Char], Boolean, Option[List[String]] ) = {
      var letraDelDni: Char = null
      var numeroDni: String = ""
      var valido        = true                      // Doy por supuesto que es válido
      var listaErrores  = new ListBuffer[String]()  // Doy por supuesto que no hay errores

      for (caracter_actual <- textoDNI.toCharArray.reverse) {
          // Comienzo a procesar esos caracteres
          // El primero de esos caracteres debe ser una letra... LA LETRA de control
          if (letraDelDni == null) { // Esto significa que es el primer caracter
              letraDelDni =  caracter_actual
              if (letraDelDni.isDigit) {
                  valido = false
                  listaErrores += "El DNI no tiene Letra de Control"
              }else if (!letraDelDni.isLetter) {
                  valido = false
                  listaErrores += "El DNI tiene Letra de Control inválida"
              }
          }else{ // Ya no estoy en el primer caracter
              // Qué podría encontrar ahora?
              // Si estoy en el segundo caracter, que puede haber aquí?
              //   digito o un caracter de separación (ESPACIO Y GUION)
              // Si no estoy en el segundo caracter, que puede haber aquí?
              //    dígito
              //    punto... siempre y cuando esté en la cuarta posición del número o
              //    en la octava ( y ojo solo cuando exista un punto en la cuarta

          }
      }


      return null
  }

  override def formatear(puntos: Boolean,
                         cerosDelante: Boolean,
                         letra: Boolean,
                         letraMayuscula: Boolean,
                         caracterSeparacion: Char): String = {
    var dniFormateado: String = ""
    // TODO: AQUI HABRA QUE PONER CODIGO QUE FORMATEE UN DNI
    dniFormateado
  }

}
