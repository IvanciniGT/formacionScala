package com.curso


object  Funcional {

    def main(args:Array[String]): Unit = {
        // La capacidad de referenciar una funcion desde una variable

        var numero = 17         // Statement. El equivalente a una ORACIÓN /FRASE / SENTENCIA en español.

        var texto = "hola"
        var funcion = Funcional.generarSaludo _     // Referenciando a una funcion desde una variable
        funcion("Ivan")                             // Ejecutando la funcion a la que apunta la variable

        // Muchos lenguajes que soportan programación funcional permiten definir funciones como expresiones
        // En estos casos, las funciones que definimos van a ser ANONIMAS

        // Una expresión es un trozo de código que devuelve un valor:
        var numero2=3+5
        var texto2="hola".toUpperCase()

        // UNA EXPRESION LAMBDA: Una EXPRESION que nos permite definir una función ANONIMA
        var funcion2 = (nombre:String) => {
            println("Estamos ejecutando generarSaludo")
            "Hola " + nombre
        }

        println(funcion2("Menchu"))


        imprimirSaludo("Lucas", generarSaludoFormal)
        imprimirSaludo("Lucas", generarSaludoInformal)
    }
                                                                // NOMBRE    // SALUDO
    def imprimirSaludo(nombre: String, funcionGeneradoraDeSaludo: (String) => (String)): Unit = {
        println(funcionGeneradoraDeSaludo(nombre))
    }

    def generarSaludo(nombre: String): String = {
        "Hola " + nombre
    }

    def generarSaludoFormal(nombre: String): String = {
        "Buenos días " + nombre
    }

    def generarSaludoInformal(nombre: String): String = {
        "Qué pasa! " + nombre
    }
}
