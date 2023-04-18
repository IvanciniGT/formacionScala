package com.curso

// Así podemos poner comentarios.
// Lo que se incluya después de una doble barra será ignorado por el compilador
// Y aquí sigue mi comentario

/*
En scala también podeis poner comentarios en bloque
Que de una ignoren varias lineas
*/

object App {

  // Esta función es muy importante... y su nombre no es azaroso.
  // Cuando arrancamos un programa scala, La máquina virtual que se encarga de ejecutar el código,
  // Busca la función MAIN... y el código de esa función es el que se ejecuta.
  // La función main, admite argumentos de texto.... un array
  // Cuando ejecutamos un programa desde linea de comandos, los argumentos que se suministren
  // Scala (JVM) los añade en un array de textos que se suministra a la función main.
  def main(args: Array[String]) { // Aqui se sobreentiende que la función NO DEVUELVE NADA....
                                  // Y que delante de las llaves no hay un signo IGUAL
    println("Hello World!") // TODO: Traducir al castellano
    saluda("Almudena")
  }

  def saluda(nombre: String) :Unit ={
    print(generarSaludo(nombre))
  }
  // Esas 2 sintaxis son equivalentes. En la de arriba al no poner el signo igual, ya se entiende que no retorna (devuelve) NADA
  // Y por ende tampoco es necesario poner el Tipo de dato devuelto Unit.
  // En la de abajo, que es la sintaxis más completa, SI ESTAMOS PONIENDO EL SIGNO IGUAL, por lo que se nos obliga
  // a informar del tipo de datos que se devuelve... Si no queremos que devuelva nada, usaremos el tipo de datos Unit

  def generarSaludo(nombre: String): String = {
    return "Hola " + nombre
  }

  def generarDespedida(nombre: String): String = {
    "Hasta ahora " + nombre // La palabra return es opcional. En scala se entiende que la última linea de código que tiene una función es lo que retorna
  }

}
