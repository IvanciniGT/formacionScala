package com.curso

// Inversion de dependencias                                              ~ Inyección de dependencias
object MiPrograma {
  def main(argumentos:Array[String]): Unit = {
    var dni1 : DNI = null // TODO... ya veremos de donde saco ese valor ("230000-T")
    dni1.valido
    dni1.numero
    dni1.formatear(false, false, false, false, null)
    dni1.formatear(true, true, true, true, null)
    dni1.formatear(true, false, true, false, '-')

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

  override val numero:  Option[Integer] = ???
  override val letra:   Option[Char] = ???
  override val valido:  Boolean = ???
  override val errores: Option[List[String]] = ???

  def validarDNI(): ( Option[Integer], Option[Char], Boolean, Option[List[String]] ) = {
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