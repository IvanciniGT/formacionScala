package com.curso

object Figuras {
  def main(argumentos: Array[String]): Unit = {
    val cuadrado1 = new Cuadrado(10) // Aquí creo instancias de ese tipo
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

  }
}

class Paralelogramo
class Triangulo
class Circunferencia

class Rectangulo (val base:Double, val altura:Double){ // Aquí defino el tipo de datos
  def area():Double = {
    this.base * this.altura
  }

  def perimetro():Double = {
    this.base * 2 + this.altura * 2
  }
}

// Defino lo que es un cuadrado, basándome en el concepto de Rectangulo
class Cuadrado (val lado:Double) extends Rectangulo(lado, lado)

