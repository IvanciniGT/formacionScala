package com.curso

object Geometria {

  def main(argumentos: Array[String]): Unit = {
    // punto en el espacio 2D, esta definido por una coordenada X y otra coordenada Y

    ///////// PARADIGMA IMPERATIVO ////////////////////////////////////////////////////////////////////////////////////

    // La palabra var me permite definir VARIABLES.
    // Cada variable tendrá su tipo de datos.
    // Puedo suministrarlo...
    var coordenadaX: Double = -7.5
    // En ocasiones puedo pedir a scala ue infiera el tipo de datos, en base al dato que estoy introduciendo
    var coordenadaY = 10.0
    // Me gustaría conocer la distancia de ese punto al origen de coordenadas.
    var distancia: Double = Math.sqrt(coordenadaX * coordenadaX + coordenadaY * coordenadaY)
    println(distancia)

    coordenadaX = 5
    coordenadaY = 5
    distancia = Math.sqrt(coordenadaX * coordenadaX + coordenadaY * coordenadaY)
    println(distancia)
    // Repetitivo...
    // Necesito escribir mucho código... y cuantos más puntos, más código -> Esto hace el código más dificil de leer
    // Poco mantenible. Como tenga que hacer un cambio...
    //  1º Me cuesta leer el programa mucho
    //  2º El cambio lo tendría que hacer en 50 sitios

    ///////// PARADIGMA PROCEDURAL ////////////////////////////////////////////////////////////////////////////////////
    // ME defino una función que calcule la distancia... y sólo la invoco!
    imprimirDistancia(5, 10)
    imprimirDistancia(-5, 15)
    imprimirDistancia(10, 3)
    println(cuadrante(5, 10))
    println(cuadrante(-5, 15))
    println(cuadrante(10, 3))

    ///////// PARADIGMA ORIENTADO A OBJETOS //////////////////////////////////////////////////////////////////////////
    val p2 = new Punto(10.5, 11.8)
    println(p2.x)
    println(p2.y)
    val p3 = new Punto(5,8)
    val p4 = new Punto(3,1)
          /* ^ Instancia de un punto , que será un dato, que yo referencio desde una variable, como cualquier otro dato */

    println(p4.distanciaAlOrigen())


    println(new Punto(13,10).distanciaAlOrigen())
    println(new Punto(10,20).distanciaAlOrigen())
    println(new Punto(0,10).distanciaAlOrigen())

    ///
    val p1: Punto = new Punto(10.5, 11.8)
    println(p1.distanciaAlOrigen())
    println(p1.cuadrante())
    println(p1.x)
    println(p1.y)
    p1.x = 25 // MUTAR EL OBJETO PUNTO . Ahora no puedo... he redefinido el dato como VAL > CONSTANTE. No es reasignable
              // Es el mismo punto... pero lo mhe movido de sitio
    println(p1.distanciaAlOrigen())
    println(p1.cuadrante())

  }

  // Esto que estoy escribiendo aquí abajo, NO ES CODIGO QUE SE VAYA A EJECUTAR
  // Solo estamos tratando de explicar a SCALA, lo que es un PUNTO !, como concepto!
  // Como si se lo explicara a un niñ@ de 10 años!
                // Cuando alguien quiera crearse un Punto, debe suministrar sus coordenadas X e Y, que deben ser Doubles
                // Y te vas a apuntar esos datos, asociados a ese punto... para lo que pueda necesitar en el futuro
  class Punto (var x:Double, val y: Double) {
    def distanciaAlOrigen(): Double = {
      // La suma de los cuadrados de SUS coordenadas
      Math.sqrt(this.x * this.x + this.y * this.y)
    }

    def cuadrante(): Integer = {
      if (this.x >= 0) {
        if (this.y >= 0)
          return 1
        4
      } else {
        if (this.y >= 0) 2 else 3
      }
    }
  }
  def calcularDistancia(coordenadaX: Double, coordenadaY: Double): Double = {
    Math.sqrt(coordenadaX * coordenadaX + coordenadaY * coordenadaY)
  }

  def imprimirDistancia(coordenadaX: Double, coordenadaY: Double): Unit = {
    println(calcularDistancia(coordenadaX, coordenadaY))
  }


  def cuadrante(coordenadaX: Double, coordenadaY: Double): Integer = {
    if (coordenadaX >= 0) {
      if (coordenadaY >= 0)
        return 1
      4
    } else {
      if (coordenadaY >= 0) 2 else 3
    }
  }
}
