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
      var separador: Char = null
      var numeroDni: String = ""
      var valido        = true                      // Doy por supuesto que es válido
      var listaErrores  = new ListBuffer[String]()  // Doy por supuesto que no hay errores
      var usaPuntos = false

      for (caracterActual <- textoDNI.toCharArray.reverse) {
          // Comienzo a procesar esos caracteres
          // El primero de esos caracteres debe ser una letra... LA LETRA de control
          if (letraDelDni == null) { // Esto significa que es el primer caracter
              letraDelDni =  caracterActual
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
              if(numeroDni.isEmpty){
                  //   digito o un caracter de separación (ESPACIO Y GUION)
                  if (caracterActual.isDigit){ // He comenzado a procesar el número
                      numeroDni = s"$caracterActual"
                  }else{
                      if(separador != null){
                          valido = false
                          listaErrores += "Sólo puede introducir un caracter de separación, o un espacio en blanco o un guión"
                      }else{
                          separador = caracterActual
                          if(separador != ' ' && separador != '-') {
                              valido = false
                              listaErrores += "El caracter de separación no es VALIDO. Solo se admite un espacio en blanco o un guión"
                          }
                      }
                  }
              }else{
                  // Si no estoy en el segundo caracter, que puede haber aquí?
                  if(numeroDni.length == 6 && usaPuntos){       // 12.345.678 ->  345678
                      //    en la octava ( y ojo solo cuando exista un punto en la cuarta
                      if( caracterActual!='.'){
                          valido = false
                          listaErrores += "Falta el separador de millones"
                      }
                      usaPuntos = false
                  }else if(caracterActual.isDigit){
                      // Siempre será válido?
                      // Si estoy en la octava posición ... y el la cuarta se había metido un punto...
                      // Esto es válido? NO... aquí tiene que haber un PUNTO
                      numeroDni = s"$caracterActual$numeroDni"
                  }else if(caracterActual == '.'){
                      //    punto... siempre y cuando esté en la cuarta posición del número o
                      if(numeroDni.length == 3){
                          usaPuntos = true
                      }else{
                          valido = false
                          listaErrores += "El separador de miles no está en un sitio correcto"
                      }
                  }else{
                      valido = false
                      listaErrores += "Caracter no válido dentro del número del DNI"
                  }
              }
          }
      }
      // El número no puede tener más de 8 dígitos
      if (numeroDni.length > 8) {
          valido = false
          listaErrores += "El número no puede ser mayor que el 99.999.999"
      }else if (numeroDni.length <1) {
          // Y no puede tener menos de 1
          valido = false
          listaErrores += "No se ha introducido un número de DNI"
      }
      // Y la letra debe ser correcta

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
