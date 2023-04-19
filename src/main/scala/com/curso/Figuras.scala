package com.curso

import scala.collection.mutable.ListBuffer

object Figuras {
  def main(argumentos: Array[String]): Unit = {

    val cuadrado1 = new Cuadrado(10) // Aquí creo instancias de ese tipo      // ESTE SOY YO
    println("El lado del cuadrado 1 vale: " + cuadrado1.lado)                       // ESTOS SOIS VOSOTROS
    val cuadrado2 = new Cuadrado(20) // Aquí creo instancias de ese tipo
    println("El area del cuadrado 1 es: " + cuadrado1.area())
    println("El area del cuadrado 2 es: " + cuadrado2.area())
    println("El perimetro del cuadrado 1 es: " + cuadrado1.perimetro())
    println("El perimetro del cuadrado 2 es: " + cuadrado2.perimetro())
    val rectangulo1 = new Rectangulo(10, 20) // Aquí creo instancias de ese tipo
    val rectangulo2 = new Rectangulo(20, 30) // Aquí creo instancias de ese tipo
    println("El area del rectangulo 1 es: " + rectangulo1.area())
    println("El area del rectangulo 2 es: " + rectangulo2.area())
    println("El perimetro del rectangulo 1 es: " + rectangulo1.perimetro())
    println("El perimetro del rectangulo 2 es: " + rectangulo2.perimetro())


    var paralelogramo1= new Paralelogramo(10, 5, 45, true)
    println("La base del paralelogramo 1 es: " + paralelogramo1.base)
//    println("La altura del paralelogramo 1 es: " + paralelogramo1.altura)
    println("La lado del paralelogramo 1 es: " + paralelogramo1.lado)
    println("El anguloEnRadianes del paralelogramo 1 es: " + paralelogramo1.anguloEnRadianes)
    println("El area del paralelogramo 1 es: " + paralelogramo1.area())
    println("El perimetro del paralelogramo 1 es: " + paralelogramo1.perimetro())
    paralelogramo1.base = 20
    println("La base del paralelogramo 1 es: " + paralelogramo1.base)
//    println("La altura del paralelogramo 1 es: " + paralelogramo1.altura)
    println("La lado del paralelogramo 1 es: " + paralelogramo1.lado)
    println("El anguloEnRadianes del paralelogramo 1 es: " + paralelogramo1.anguloEnRadianes)
    println("El area del paralelogramo 1 es: " + paralelogramo1.area())
    println("El perimetro del paralelogramo 1 es: " + paralelogramo1.perimetro())

    var circunferencia1 = new Circunferencia(10)
    println("El área de la circunferencia 1 es "+ circunferencia1.area())
    println("El perímetro de la circunferencia 1 es "+ circunferencia1.perimetro())
    println("El radio de la circunferencia 1 es " + circunferencia1.radio)
    circunferencia1.radio = 20
    println("El área de la circunferencia 1 es " + circunferencia1.area())
    println("El perímetro de la circunferencia 1 es " + circunferencia1.perimetro())
    println("El radio de la circunferencia 1 es " + circunferencia1.radio)

    // var listadoDeFiguras: Array // Tanto array como list son tipos de datos INMUTABLES
    // var listadoDeFiguras: List
    // Que una vez creados, no se pueden cambiar.
    // A mi me gustaría una lista en la que poder ir AÑADIENDO COSAS (FIGURAS)

    var listadoDeFiguras= new ListBuffer[FiguraGeometrica]()
    listadoDeFiguras += cuadrado1       // Cuadrado
    listadoDeFiguras += cuadrado2       // Cuadrado
    listadoDeFiguras += rectangulo1     // Rectangulo
    listadoDeFiguras += rectangulo2
    listadoDeFiguras += paralelogramo1
    listadoDeFiguras += circunferencia1  // Circunferencia
    imprimirAreas(listadoDeFiguras.toList)

  }

  def imprimirAreas(listado: List[FiguraGeometrica]){

    for (figura <- listado) {
      println("El area de la figura es " + figura.area())
      println("El perimetro de la figura es " + figura.perimetro())
    }
  }
}

trait FiguraGeometrica{ // Un trait, en java llamado INTERFAZ (en python no existe)
  // Nos permite definir un nuevo TIPO DE DATOS, del que SOLO CONOZCO las funciones que debe tener
  // Pero no soy capaz de dar aún el cñódigo de esas funciones. No tengo la información
  def area():Double
  def perimetro():Double
}

trait Poligono extends FiguraGeometrica{ // Un trait, en java llamado INTERFAZ (en python no existe)
  // Nos permite definir un nuevo TIPO DE DATOS, del que SOLO CONOZCO las funciones que debe tener
  // Pero no soy capaz de dar aún el cñódigo de esas funciones. No tengo la información
  var lados:Integer
}

class Triangulo

class Circunferencia (var radio:Double) extends FiguraGeometrica{

  def area(): Double = {
    Math.PI * this.radio * this.radio
  }

  def perimetro(): Double = {
    2 * Math.PI * this.radio
  }

}

class Paralelogramo (var base: Double, val lado: Double, angulo:Double, enGrados:Boolean) extends Poligono{
  val anguloEnRadianes: Double = if(enGrados) angulo/180 * Math.PI else angulo
  //val altura: Double = this.lado * Math.sin(this.anguloEnRadianes)
  var lados = 4
  def area(): Double = {
    this.base * this.lado * Math.sin(this.anguloEnRadianes)
  }

  def perimetro(): Double = {
    this.base * 2 + this.lado * 2
  }

}

class Rectangulo (base:Double, altura:Double) extends Paralelogramo (base, altura, 90, true){ // Aquí defino el tipo de datos
  override def area(): Double = {  // Sobreescritura de una función (OVERRIDE)
    this.base * this.lado
  }
}

// Defino lo que es un cuadrado, basándome en el concepto de Rectangulo
class Cuadrado (lado:Double) extends Rectangulo(lado, lado)


class CuadradoViejo (val lado:Double){ // Aquí defino el tipo de datos
  def area():Double = {
    this.lado * this.lado
  }

  def perimetro():Double = {
    this.lado * 4
  }
}

