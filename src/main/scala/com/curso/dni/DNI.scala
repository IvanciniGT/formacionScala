package com.curso.dni

trait DNI {

  val numero:   Option[Integer] // El dato lo puedo tener o no.... Opcional
  val letra:    Option[Char]
  val valido:   Boolean
  val errores:  Option[List[String]]
  def formatear(puntosMiles: Boolean = false,
                cerosDelante: Boolean = false,
                mostrarLetra:Boolean = true,
                letraMayuscula: Boolean = true,
                caracterSeparacion: String = ""): Option[String]
}
