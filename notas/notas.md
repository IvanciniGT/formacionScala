# SCALA

Lenguaje de programación.

## Lenguaje

Forma de comunicación sujeta a una GRAMATICA (morfología + sintaxis) + SEMANTICA (significados)

- Lenguajes naturales: Son los que usamos los seres humanos
- Lenguajes formales:  Tienen una estructura muy rígida

El receptor de los mensajes que comunicamos es una computadora/ordenador.

## Tipos de lenguaje de programación

### Lenguajes compilados / lenguajes interpretados

Quién ejecuta/controla un programa? El Sistema Operativo que tenga instalado en la computadora.
Qué lenguajes de programación habla un SO?
- Python? NO
- JAVA? NO
- Scala? NO
  Habla su propio lenguaje (API)

Necesitamos traducir el programa que hemos hecho al lenguaje del SO de la computadora donde vamos a ejecutarlo.

- Lenguajes compilados      Pre-traducción estática de un código.
  c                       Pasamos del código en nuestro lengauje de programación al código necesario en una determinada
  c++                     computadora: WINDOWS + Microprocesador x86
  fortran                              MacOS + Microsprocesador x64
  MacOS + M1
  Beneficios:
  - El que recibe el programa, lo recibe listo para su ejecución
  - Durante el momento en el que hago esa PRETRADUCCION, tengo la oportunidad de revisar lo que he escrito.

                            Contras:
                            - Más incómodos, hay que compilar, es otra tarea que me echo a la espalda!

- Lenguajes interpretados   Necesitamos un INTERPRETE que en tiempo real realice esa traducción entre el lenguaje de mi
  python(cython)            programa y el lenguaje del SO.
  pypy
  jython             Beneficios:
  - Para mi es muy cómodo. A todo el mundo le distribuyo el mismo programa!
  - Responsabilidad de ellos es contratar a un INTERPRETE.
  - Más cómodos de usar... Una cosa menos que hacer

                            Contra:
                            - El programa (a priori) se ejecuta más lento... ya que en el momento de la ejecución, además de 
                              ejecutarlo hay que traducirlo
                            - Pierdo ese momento (compilación) donde poder revisar si hay problemas con el código

#### Y donde entra JAVA?

Java es un lenguaje muy peculiar en cuanto a su diseño.
Es un lenguaje compilado + interpretado. SIMULTANEAMENTE

Código JAVA            
.java      --- compilación ---->   .class    ----- empaquetarlos -----> .jar ---- Hay que interpretarlo ---> EJECUCION
^               ^                 ^ jar                         ^ java JVM (JIT+GC)
javac             ^ Están escritos en otro lenguaje de programación (BYTE-CODE)
^ Compilador de java

# SCALA ???

Java es un lenguaje REGULARMENTE DISEÑADO. Tiene fallos / incoherencias / incomodidades en su gramática.
Pero... su arquitectura y su Máquina virtual es GENIAL !!!!

.scala     --- compilación ---->   .class    ----- empaquetarlos -----> .jar ---- Hay que interpretarlo ---> EJECUCION
^               ^                 ^ jar                         ^ java JVM (JIT+GC)
scalac             ^ Están escritos en otro lenguaje de programación (BYTE-CODE)
^ Compilador de scala (javac) (Se hace lo que se llama una TRANSPILACION)

En un momento dado aparecen alternativas a la sintaxis de JAVA, que también me permiten generar BYTE-CODE:
- scala
- kotlin

### Lenguajes de tipado estático / de tipado dinámico

- tipado estático (scala, java)       Son lenguajes en los que cuando definimos una variable, a la variable se le asocia un
  TIPO DE DATO al que puede referenciar
    ```java
    String nombre = "Ivan";    # FUNCIONA? SI
    nombre = 4                 # FUNCIONA? NO... nombre, tal y como ha sido definida esa variable solo puede apuntar a TEXTOS
    ```

    ```scala
    var nombre = "Ivan";       # FUNCIONA? SI
    nombre = 4                 # FUNCIONA? NO... nombre, tal y como ha sido definida esa variable solo puede apuntar a TEXTOS
                               # Pero???? Yo no he puesto arriba nada de textos(strings)?????
                               # Scala INFIERE el tipo de la variable del valor que le hemos asignado en primer lugar
    ```


- tipado dinámico (python)            Son lenguajes en los que cuando definimos una variable, a la variable NO se le asocia
  un TIPO DE DATO y por tanto puede referenciar a cualquier tipo de dato
    ```python
    nombre = "Ivan"    # FUNCIONA? SI
    nombre = 4         # FUNCIONA? SI
    ```

### Qué es mejor? Tipado estático o tipado dinámico?

Los lenguajes de tipado dinámico, son COMODOS de manejar. ME OLVIDO de andar escribiendo tipos.
El problema es que el comportamiento del código no queda EXPLICITO.

```python
def genera_informe(titulo, datos):
    # ... código
```

```scala
def genera_informe(titulo:String, datos:Array[Int]):String ={
    # ... código
}
```

## DATO

Es un valor con el que quiero operar / almacenar. Pueden ser de distinta naturaleza:
- Numero
- Texto
- Valor lógico (True/False)
- Fecha
- Lista
- ...

Esas naturalezas es lo que llamamos un TIPO DE DATOS.
Cada valor/dato es de un tipo, per se.

## Variable

En lo lenguajes de programación que nosotros vamos a manejar es:
UNA REFERENCIA a un DATO almacenado en MEMORIA.

```python
nombre = "Ivan"
```

Cuantas cosas ejecuta es linea? Cuantas partes tiene ese statement? 3
- "Ivan"        ->  Coloca un objeto(DATO) de tipo STRING(TEXTO) con valor "Ivan" en memoria RAM
- nombre        ->  Define una variable cuyo nombre es "nombre"
- =             ->  OPERADOR (acción~verbo) Que la variable nombre APUNTE al espacio de memoria donde está almacenado ese DATO

```python
nombre = "Menchu"
```

Cuantas cosas ejecuta es linea? Cuantas partes tiene ese statement? 2
- "Menchu"      ->  Coloca un objeto(DATO) de tipo STRING(TEXTO) con valor "Menchu" en memoria RAM.
  Dónde se coloca el dato MENCHU? En el mismo sitio donde estaba Iván o en otro? EN OTRO
- nombre =      ->  VARIAR la VARIABLE, para que ahora apunte a MENCHU!

En este momento, cuantos DATOS tenemos en la RAM? 2: IVAN y MENCHU

Pero, hay alguna variable apuntando a IVAN? NO -> Ivan se acaba de convertir en BASURA !!!!! GARBAGE
Y en algún momento (indeterminado y fuera de nuestro control) entrará el RECOLECTOR DE BASURA (GARBAGE COLECTOR) a eliminar ese dato IVAN, que está ocupando espacio en la RAM innecesariamente.

Estos lenguajes hacen un DESTROZO con la memoria RAM... son muy ineficientes gestionando la RAM.
Eso es bueno o malo? Ni bueno ni malo... ES UN FEATURE !

Un espacio que se reserva en memoria para guardar un dato de un tipo concreto... Si estuvieramos trabajando en lenguaje C, o ADA, esto estaría BIEN.... pero ni en JAVA, ni en PYTHON, ni en JS, ni en SCALA esta definición se ajusta a lo que es una variable.

---

# MAVEN

Es una herramienta de software que fabrica la fundación Apache.
Nos ayuda a automatizar tareas habituales en proyectos JAVA.

Ejemplos de tareas que nos ayuda a automatizar:
- La obtención de dependencias desde repositorios de artefactos (MAVEN CENTRAL)
- Compilar un proyecto
- Empaquetar un proyecto
- Distribuir un proyecto
- Ejecutar un proyecto
- A realizarle pruebas
- A enviar nuestro proyecto a SonarQube para su análisis

Pero realmente maven no sabe hacer NADA de NADA por si mismo. Todo lo hace mediante PLUGINS.
Maven ya viene de serie con unos cuantos plugins... y nosotros podemos añadir más... desactivar los que trae por defecto, o cambiarlos por otras versiones.

Hay varias herramientas equivalentes a maven:
- gradle
- En el mundo scala la más habitual: sbt
- poetry
- yarn
- npm
- msbuild
- dotnet

Cuando trabajamos con maven, maven nos impone (realmente lo podemos cambiar, aunque nunca lo hacemos) un determina estructura de carpetas en el proyecto.

    proyecto/
        |- src/
        |   |- main
        |   |    |- scala           Código de nuestro proyecto...  1 o 500 archivos .scala
        |   |    |- resources       Otros archivos que pueda necesitar mi programa (configuración, datos...)
        |   |- test
        |        |- scala           Código de programas de pruebas automatizados
        |        |- resources       Otros archivos que puedan necesitar mis programas de prueba (configuración, datos...)
        |- target                   Carpeta que gestiona maven donde va dejando resultantes de las tareas
        |   |- classes                  El resultado de compilar lo que hay en src/main/scala
        |   |                           Una copia de los archivos de src/main/resources
        |   |- test-classes             El resultado de compilar lo que hay en src/test/scala
        |   |                           Una copia de los archivos de src/test/resources
        |   |- artefacto                Un archivo .jar con el empaquetado de mis fichero .class
        |- pom.xml                  Configuración de maven para mi proyecto

Una vez tenemos un proyecto creado con una estructura compatible con maven, solicitaremos a maven que realice ciertas tareas sobre nuestro proyecto. Esas tareas las denominamos GOALS.
Antes os he dicho que maven no sabe haver nada por si mismo y que todo lo hace mediante plugins

Cada GOAL (cada tarea con la que maven me va a ayudar) tiene asociado un plugin.
Tareas comunes que ejecutamos en los proyectos:
- compile                           Compila lo que hay en src/main/scala y el resultado (montón de fichero .class)
  se deposita en target/classes
  Sin que yo se lo pida, previo a esta tarea maven:
  - Descargar de internet las dependencias (librerías) necesarias de mi proyecto
  y depositarlas en la carpeta ".m2" (oculta), que existe en mi carpeta de
  Usuario del SO.
  - Ejecutar el goal "resources": Esto copia los archivos que tengamos en
  src/main/resources también dentro de target/classes
- test-compile                      Compila lo que hay en src/test/scala y el resultado (montón de fichero .class)
  se deposita en target/test-classes
  Sin que yo se lo pida, previo a esta tarea maven:
  - Descargar de internet las dependencias (librerías) necesarias para mis
  programas de pruebas y depositarlas en la carpeta ".m2" (oculta), que existe
  en mi carpeta de Usuario del SO.
  - Ejecutar el goal "test-resources": Esto copia los archivos que tengamos en
  src/test/resources también dentro de target/test-classes
- test                              Ejecuta los programas de pruebas ... que los tengo en: target/test-classes
  Esto puede generar informes con los resultados de esas pruebas.
  Dependiendo el plugin esos reportes se almacenará en una carpeta u otra.
  Usualmente para pruebas "unitarias", en maven viene configurado el plugin "surefire"
  En nuestro caso, como vamos a trabajar con scala, no usaremos ese plugin.
- package                           Empaquetar lo que tenemos en target/classes en un fichero .jar
  que se deposita en target/
- install                           Copia el artefacto (el .jar) dentro de nuestra carpeta .m2
  Para que así, ese artefacto pueda ser utilizado en otros proyectos de nuestro pc
- clean                             Borra la carpeta target/

Esos goals van en orden:
compile > test-compile > test > package > install (1)
clean

Las tareas (1) se realizan de forma incremental.
Cuando yo compilo el proyecto (compile), maven lo primero que hace es mirar si hay archivos YA COMPILADOS y que no hayan cambiado. En ese caso, esos archivos no se recompilan. Solo se compilan los archivos nuevos y los que hayan cambiado.
Esto está guay, ya que nos hace ir más rápido (tarda menos en compilar)

El problema puede ser por ejemplo, que haya un archivo que yo borre (un archivo .scala). Maven no elimina ese archivo de la carpeta target/classes al compilar la nueva versión que ya no tiene ese archivo. Y esto podría interferir con la correcta ejecución de mi programa.
Con las mismas, puede ser que tuviera antes un archivo en src/main/resources o en src/target/resources que ahora he borrado.
Pero maven no lo elimina de target/classes o target/test-classes... y puede ser que el hecho de que ese fichero siga allí, haga que mi programa no se ejecute correctamente.

Si trabajamos en proyectos pequeños, habitualmente ejecutamos:
>    $ mvn clean install     Cuando acabo
>    $ mvn clean test        Cuando pruebo

Si trabajo en proyectos grandes, donde puedo tener 500, 2000 clases ... aquello tarda mucho en compilar
En estos casos, lo habitual es ir haciendo
>   $ mvn test
Y sólo cuando tenga claro que necesito hacer un clean, lo haré...

# ARTEFACTO

nuestro archivo .jar, con el contenido de nuestro programa (y recursos adicionales necesarios) listo para distribuir

### pom.xml

- Datos identificativos de mi proyecto/programa: COORDENADAS de mi proyecto
  - groupId       Identifica un proyecto de alto nivel:
  com.miempresa.<proyecto>
  - artifactId    El identificador (nombre) de mi programa dentro de un proyecto!
  Hoy en día los proyectos los montamos de forma modular
  - version       La versión del artefacto(programa) que estamos montando... Irá cambiando con el tiempo

- plugins que vamos a usar para los goals (tareas que queremos automatizar)
  Maven trae muchos por defecto... que nos veo en el fichero... porque vienen por defecto... pero que están.
- Esos plugins pueden requerir de parámetros de configuración... y también los suministramos en este fichero.
- A veces, queremos declarar nuestros propios parámetros de configuración, más allá de los que requieren los plugins,
  para que a nosotros nos sea más fácil configurar ciertas cosas dentro del fichero POM
- Dependencias

### Arquetipo

Es como llamamos en MAVEN a un plantilla de proyecto.

## Versiones de software

1.2.3
Cuándo se incrementan?
1: MAJOR                Cuando se hace un rediseño de sistema que no respeta RETROCOMPATIBILIDAD
Elimino algo que estaba marcado como deprecated
2: MINOR                Cuando se añade una funcionalidad
Cuando marcamos una funcionalidad existente como deprecated (obsoleta)
(Esto se hace para dar tiempo a los usuarios de tu programa a dejar de usar esa funcionalidad)
+ Pueden venir arreglos en un incremento de MINOR
3: PATCH/MICRO          Cuando hay un arreglo de un bug (fix)


## Dependencia

Una librería que necesita mi proyecto en algún momento.
Esa librería es necesario conseguirla (descargarla) en una determinada versión... que podrá cambiar.

## Sonarqube

Herramienta de análisis de calidad de código

---

# SCM

Qué vamos a hacer con el código de nuestro proyecto? Dónde lo dejamos?
En mi pc? en una carpeta del disco duro?
En un repositorio de un Sistema de Control de Código fuente: SCM

Sistema de control de versiones... este nombre es una mala adaptación al español de un antiguo SCM que se usaba mucho: CVS

Hoy en día usamos git (96% de los desarrolladores)

    cvs > svn (subversión) > git

## Qué es un SCM?  Para que sirve?

- Para ir almacenando todos los cambios que se van haciendo en nuestro proyecto
  > Lo podría conseguir con cualquier sistema de COPIAS DE SEGURIDAD (Trabaja con versiones secuenciales en el tiempo)
- Trabajar con múltiples versiones en PARALELO -> SCM -> RAMA
- Compartir/sincronizar el trabajo de un equipo

# RAMA - Branch

Una linea de evolución paralela en el tiempo de mi proyecto.
En las ramas, es donde guardamos COMMITs

# COMMIT

En git, es una FOTO COMPLETA (backup) del proyecto en un momento dado.
No incremental (no guarda diferencias) ... guarda el proyecto completo !

Internamente en git, en muchas operaciones se CALCULAN los patch (los cambios que se han realizado entre 2 commits)

Git lo creo Linus Torvalds... el creador de Linux (Kernel de SO... el más usado del mundo actualmente)

# Repositorios

Las ramas se guardan en repositorios.
Y git lo hace de una manera especial.

Git es un sistema de SCM distribuido. El qué????
Cuando trabajamos con git, no hay un único repositorio centralizado, como ocurría en CVS o SVN.
En su lugar, cada participante en el proyecto tiene su propio REPO... y además usan REPOs alojados en servidores accesibles por red para sincronizar sus repos (las ramas de sus repos)- compartir su trabajo
La suma de todos esos repos es el proyecto en su conjunto.
Todos esos repos, son diferentes entre si.

Cuando trabajamos con git, necesitamos de esos REPOSITORIOS en red, para sincronizar cambios entre los desarrolladores.
A esos repos se les denomina REPOSITORIOS REMOTOS.
Hay herramientas de software que nos permiten alojar repositorios remotos de git: GITHUB, GITLAB, BITBUCKET

## Qué guardamos en git?

Cuando trabajamos en un proyecto mavenizado (con maven), no todos los archivos los guardamos en git.
Hay algo que NUNCA GUARDARÉ EN GIT: la carpeta target/

Los archivos/carpetas que NO DEBEN SUBIR a nuestro repositorio de git los definimos en el archivo ".gitignore"

---

# Refactorizar un código

Etapa en la que reorganizamos el código sin cambiar su comportamiento, para facilitar el mantenimiento

# Documentar vs Comentar

## Documentar un código

Qué hace mi código y cómo hablo con él
Va orientada a usuarios de mi programa (que serán también desarrolladores) que integrarán mi programa en el suyo.
No van a modificar mi programa. Simplemente deben sabe QUE HACE y COMO COMUNICARSE con mi programa.

## Comentar un código

Cómo hace mi código lo que hace
Orientado a compañeros desarrolladores que vayan en el futuro a cambiar el programa

---

# Palabrotas de scala

## object -> objeto

Que no tiene nada que ver (o si... pero no es evidente) con lo que habitualmente entendemos por un OBJETO en el mundo
de la programación orientada a objetos.

Un object de scala es un SINGLETON, una clase, de la que solo se puede generar una instancia, que se generará AUTOMATICAMENTE por scala.

### Singleton

Una clase de la que solo habrá una UNICA instancia, un único objeto

## class

Un tipo de dato propio que nosotros creamos en el lenguaje, que podrá tener sus propios atributos/propiedades y funciones.

De una clase generamos INSTANCIAS.

    clase       instancias de esa clase
    String      "hola"      "adios"     "hasta luego"
    Integer     3           -8          10

Una instancia es un DATO concreto de un TIPO (clase), que tienes guardada en la memoria RAM del proceso que se ejecuta.

Hay lenguajes, y en general en el mundo de la programación orientada a objetos, donde a esas instancias se las denomina OBJETOS.

# companion

Una clase que tiene asociado un object de scala

---

# Tipos de datos

Los lenguajes de programación al fin lo que me permiten es montar PROGRAMAS para manipular DATOS.

Esos datos pueden tener distintas naturalezas:
- textos
- numeros
    - enteros
    - decimales
- valores lógicos
- fechas
- listas
- tablas

Los lenguajes de programación vienen con un conjunto preestablecido de tipos de datos.
Pero algunos me permiten crear mis propios tipos de datos -> Orientados a Objetos

Una clase define un tipo de datos propio.

                                    Propiedades             Asociado a cada TIPO de dato, podemos tener funciones
- "hola"        -> Texto            valor                       .toUpperCase()  . toLowerCase()
- -8            -> Enteros          valor                       .abs()
- 1.87E5        -> Decimal          mantisa+exponente           .parteEntera()
- new Punto(1,3)-> Punto            x + y                       .distanciaAlOrigen()
---
# Paradigmas de programación

Es una forma de usar un lenguaje para expresar un concepto.

    Pon una silla debajo de la ventana                      Imperativa
    Quiero una silla debajo de la ventana                   Desiderativa
    Debe haber una silla debajo de la ventana               Enunciativa afirmativa

## Paradigmas habituales
                                                                                            PALABRAS
- Imperativo                Cuando doy órdenes que se procesan de forma secuencial          if else for while try
- Procedural                Cuando el lenguaje me da la posibilidad de crear/definir        def
  funciones, procedimientos, métodos
  Y solicitar su ejecución                                        ()
- Funcional                 Cuando el lenguaje me permite referenciar desde una variable    Expresiones lambda
  una función:
  numero = 7
  texto = "hola"
  funcion = print
  funcion()
  El impacto de esto es trascendental, ya que, desde el
  momento, en que una variable puede referenciar una
  función, podemos pasar funciones como argumentos
  a otras funciones, o hacer que una función devuelva
  otra función
- Orientación a objetos     Cuando el lenguaje me da la posibilidad de definir              class extends
  MIS PROPIOS tipos de datos, con sus propios
  atributos/propiedades y funciones
---

Código -> Programa -> Ejecución del programa
.scala      .class      La realiza la JVM... dando lugar a un proceso en SO

                        Ejecución 1: Ese proceso que se crea en el SO tendrá un espacio reservado en memoria RAM donde almacenar sus datos.
                            Cada ejecución del programa guarda sus propios DATOS
                        Ejecución 2: Ese proceso que se crea en el SO tendrá un espacio reservado en memoria RAM donde almacenar sus datos.

Un singleton, permite la creación de una UNICA INSTANCIA de una clase, en tiempo de EJECUCION, dentro de un proceso de SO.

                    Y
        2           |             1
                    |
                    y1---· P
                    |    |
        ------------|---x1--------- X
                    |
                    |
       3            |             4
                    |

# En Scala usamos CAMEL CASE

ESTO ES IMPORTANTE!!!!!
MUY IMPORTANTE!!!!
No es una norma... pero si es de muy buen gusto....
Más bien el no hacerlo es algo considerado de MUY MAL GUSTO... suficiente como para tirar un programa a la basura !

En los lenguajes de programación, vamos a  crear clases, variables, funciones

Los nombres de esas clases, variables funciones, deben construirse siguiendo unas reglas.
Cada lenguaje usa sus propias reglas.
Las de python son diferentes de las de SCALA.

                                    variable            funcion                     clase
En python se usa SNAKE CASE         numero_de_hijos     imprimir_numero_de_hijos    CosasDeFamilia
En scala se usa CAMEL CASE          numeroDeHijos       imprimirNumeroDeHijos       CosasDeFamilia



```py
class Punto :
  # Constructor: Me permite explciar a SCALA cómo alguien puede crear un Punto concreto
  def __init__(self, x, y):
    self.coordenadaX=x
    self.coordenadaY=y
```

```java
class Punto {
  double coordenadaX
  double coordenadaY
  
  Punto(double x, double y) {
    this.coordenadaX=x
    this.coordenadaY=y
  }
}
```

```scala
class Punto (var x:Double, var y: Double){
}
```

## Condicional como STATEMENT

```python
if condicion:
    # Tarea 1
else:
    # Tarea 2
```
```java
if (condicion){
    // Tarea 1
}else{
    // Tarea 2
}
```
```scala
if (condicion){
    // Tarea 1
}else{
    // Tarea 2
}
```
## Condicional como EXPRESSION

```python
numero = 7
par = true if numero % 2 == 0 else false
#     <valor si se cumple la condicion> if <condicion> else <valor si no se cumple>
#par = numero % 2 == 0
```
```java
int numero = 7;
boolean par = numero % 2 == 0 ? true : false
//            <condicion> ? <valor si se cumple la condicion> : <valor si no se cumple>
```
```scala
var numero = 7;
var par = if (numero % 2 == 0 ) true else false
//     if (<condicion>)  <valor si se cumple la condicion> else <valor si no se cumple>
```

### Statement vs expression

```py
numero = 17 + 6
texto = "hola"
print(texto)
```
```java
int numero = 17 + 6;    // Esto es un statement
             ///^// Es una expresion
String texto = "hola";   // Esto es un STATEMENT
System.out.print(texto);
```
```scala
var numero = 17 + 6
var texto = "hola"
print(texto)
print(3-8)
```

Una EXPRESSION es una porción de código escrito dentro de un statement que DEVUELVE UN VALOR !

## Variable

Una variable es una referencia a un dato que tenemos en memoria.
Por qué es VARIABLE? Porque en un momento dado puede referenciar a OTRO DATO

    var1 ----> DATO1

    var1       DATO1
         ----> DATO2

    var1 ----> DATO1' Mutación en el DATO


    var var1 = "hola"                               var1        "hola"
    var1 = "adios"                                       -----> "adios"

    lista = []                                      lista ---> [1] He mutado la lista
    lista[0] = 1

## Constante

Una Constante es una referencia a un dato que tenemos en memoria.
Por qué es CONSTANTE? Porque en un momento dado NO PUEDE YA referenciar a OTRO DATO distinto del inicial que se referenció

En python NO EXISTE EL CONCEPTO DE CONSTANTE

En JAVA si... basta con usar la palabra "final" delante de la definición de una variable
```java
int numero = 8;
numero = 14;

final int numero2 = 8; // Esta 'variable' numero2 no podrá apuntar a ningún otro valor... es final... Es constante!
numero2 = 14;          // ERROR
```

En SCALA también:
```scala
var numero = 8;
numero = 14;

val numero2 = 8;
numero2 = 14;       // ERROR 
```

BUENA PRACTICA (IMPRESCINDIBLE):
Siempre que pueda usar la palabra val, en lugar de var, debo usarla!!!!!

# Paralelogramo
                ______________
               /|         O /
              / |          / b
             --------a-----
    Perimetro 2·a + 2·b
    Area a · h 
    Altura  b·sen(O)
      
# Constructor de una clase en un lenguaje cualquiera que soporte Orientación a Objetos

Es una función que le indica al programa cómo se pueden crear instancias de esa clase.

> Si defino lo que es un cuadrado... aparte le doy al programa instrucciones de cómo crear un cuadrado.
> Para crear un cuadrado debes darme su lado... y ese lado se anotará como EL LADO de ESE CUADRADO

---

```py
class Punto :

  # Constructor: Me permite explciar cómo alguien puede crear un Punto concreto
  def __init__(self, x, y):
    self.coordenadaX=x
    self.coordenadaY=y
```

```java
class Punto {
  double coordenadaX;
  double coordenadaY;
  
  Punto(double x, double y) {       // Constructor
    this.coordenadaX=x;
    this.coordenadaY=y;
  }
}
```

```scala
class Punto (var x:Double, var y: Double){
}
```

```java
class Paralelogramo {
  double base; // Base está definido como una variable.... en JAVA ... y por ende, cualquiera podría cambiar el valor a posteriori
  final double lado;    // Lado está definido en este caso como constante... y por ende? nadie podría cambiar ese dato una vez asignado
  double anguloEnRadianes;

                // v Le anoto tal cual? SI
                             // v Le anoto tal cual? SI
                                        // v Le anoto tal cual? NO le guardo... lo uso para calcular OTRO DATO
                                                          // v Le anoto tal cual?  NO le guardo... lo uso para calcular OTRO DATO
  Paralelogramo(double base, double lado, double angulo, boolean enGrados) {       // Constructor
    this.base=base;
    this.lado=lado;
    if(enGrados)
        this.anguloEnRadianes=angulo/180 * Math.PI;
    else
      this.anguloEnRadianes=angulo;
  }
}
```
 ^^^^
```scala
class Paralelogramo (var base: Double, val lado: Double, angulo:Double, enGrados:Boolean) {
  var anguloEnRadianes: Double
  if(enGrados)
    this.anguloEnRadianes=angulo/180 * Math.PI;
  else
    this.anguloEnRadianes=angulo;

}
```
```java
class Paralelogramo {
  double base;
  final double lado;
  double anguloEnRadianes;

  Paralelogramo(double base, double lado, double angulo, boolean enGrados) {
    this.base=base;
    this.lado=lado;
    if(enGrados)
      this.anguloEnRadianes=angulo/180 * Math.PI;
    else
      this.anguloEnRadianes=angulo;

  }
}
```

IVAN DICE : Quiero un cuadrado de 127000cm de lado HE HABLADO !!!!
ALMUDENA y anota... Mi cuadrado tien 1270m de lado HE ANOTADO !!!!

---
```scala
class Paralelogramo (var base: Double, val lado: Double, angulo:Double, enGrados:Boolean) {
  val anguloEnRadianes: Double = 0
  if(enGrados)
    this.anguloEnRadianes=angulo/180 * Math.PI;
  else
    this.anguloEnRadianes=angulo;
  val altura: Double = this.lado * Math.sin(this.anguloEnRadianes)
  
  def area(): Double = {
    this.base * this.altura 
  }

  def perimetro(): Double = {
    this.base * 2 + this.lado * 2
  }

}
```
Oye programa... a partir de ahora la gente quiero que pueda crear Paralelogramos.
Cuando alguien quiera crear un paralelogramo, te debe suministrar una base, un lado, un ángulo, e indicarte si el ángulo está en grados o en radianes.
El Paralelogramos que vas a crear tendrá:
- por base la que te hayan dado
- por lado el que te hayan dado.. eso si: ese lado no podrán cambiarlo en el futuro
- y un angulo en radianes (que no será actualziable):
  - Si el angulo te lo han dado en radianes... ese es el valor
  - Pero, si el angulo te lo dan en grados... lo transformas, según la fórmula que te suministro
- y una altura, calculada como SU lado por el seno de SU angulo en radianes. ESA ALTURA NO ES MODIFICABLE A FUTURO
Una vez creado un Paralelogramo, la gente podrá:
- solicitarte que calcules su área, según la formula que se suministra, a saber:
  Tomas la base de ESE paralelogramo y SU altura
                  (this)               (this)                 
- solicitarte que calcules su perímetro... igualmente.


Figura Geomética*                              area + perimetro
                        ^                 ^
Triangulo    >     Poligono* (3 )(lados)  ^
                        ^                 ^ 
                  Paralelogramo (2)  Circunferencia (2)
                        ^           area + perimetro 
                   Rectangulo (1)
                        ^
                    Cuadrado (1)

* TRAIT: Solo definen contratos que los que quieran PRESUMIR de cumplir con ese contrato deben asegurar 
                                                                                                                        JAVA
Cuando usamos extends con NOMBRE DE CLASE detrás, que significa? (1)                                                      extends
  La clase que estoy definiendo hereda las características de la clase que extiende

Cuando usamos extends en una clase con NOMBRE DE UN TRAIT detrás, que significa? (2)                                      implements
  La clase debe garantizar que cumple con el contrato (trait) es decir, que ofrece código (implementación) 
  para los métodos y propiedades definidas en el trit correcpondiente

Cuando usamos extends en un TRAIT con un nombre de TRAIT detrás (3)                                                      extends
  Extiendo el contrato, para que ahora, cualquier que quiera asegurar que cumple con mi contrato deba garantizar el proporcionar
  código para los requisitos que yo esté definiendo MAS los que se hayan definido en el contrato que extiendo

ME temo que todos desde que teneis 5-6 años os enseñan en el colegio un segundo lenguaje... cual? LENGUAJE MATEMATICO (lenguaje formal)
  (3+6)x14
  f(x,y)
    FUNCION BIYECTIVA!
  var(X)
    VARIANZA
ME temo que todos desde que teneis 7-8 años os enseñan en el colegio un tercer lenguaje... cual? INGLES 

---

## Ejercicio / Proyecto

Nos gustaría un programa / Librería para poder trabajar con DNIs
- Validar un texto para ver si es un DNI válido o no
- Dado un número de DNI, calculame la letra que le toca
- Formatear un DNI con el patrón (formato) que a mi me interese

Para montar esto en scala. Primera pregunta que me hago? 
QUE PARADIGMA VOY A USAR? 
- Imperativo? NO, ya que lo que quiero precisamente es poder disponer de unas funciones REUTILIZABLES
- Procedural? Es decir, crearme esas funciones? Podría... pero no me va a traer cuentas
- Orientado a Objetos? IDEEAL !!!!!! para este escenario

Quiero definir mi propio tipo de datos: El tipo DNI
Qué es un DNI?                                                                      propiedades
  - Un número entero 
  - Letra
Qué debo suministrar para crear un DNI?                                             constructor
  - El texto original de un DNI que tengo por ahí
Qué le puedo preguntar, pedir a un DNI? Qué funciones voy a montar en esa clase?    funciones
  - Eres válido?
    def valido(): Boolean
  - errores?
    def errores(): List[String]
  - Formateate con este formato
      def formatear(cerosDelante: Boolean, letra: Boolean, puntos : Boolean, letraEnMayuscula: Boolean, caracterSeparacionDigitoControl: String): String
-------------------------------------------
HASTA 8 Numeros y 1 letra
    TABLA 1 : 2300000T            VALIDO
    TABLA 2 : 2.300.000T          VALIDO
    TABLA 3 : 2.300.000-t         VALIDO
    TABLA 4 : 02300000T           VALIDO
    TABLA 5 : 2300.000-t          NO VALIDO
    TABLA 6 : 23.00.000-t         NO VALIDO
    TABLA 7 : 2.300T              VALIDO
    TABLA 8 : desconocido

    Eso tiene un formato válido de DNI
    Es un DNI válido? 
      Qué es la letra del DNI? Es un mecanismo de comprobación.
      De los números obtenemos una letra
        Hay que dividir el número entre 23. Lo que me interesa es el RESTO de la división
          23.000.001 | 23
                     -------------
                   1   1.000.000
                   ^RESTO y es lo que me interesa (estaría entre 0 y 22)
              Al tener el nñumeo como resto 1 (cuando se divide entre 23), le corecponde la letra R
              Cuanta probabilidad hay de que dos números generen la misma letra? 1/23
              Dicho de ota forma: Tengo más de un 95% de confianza en que el dato es bueno... si el númeor y letra coinciden

  Número: 
    1 bit = 0 | 1 -> Puedo guardar 2 significados
    2 bits = 00 01 10 11  = 4 =  2 elevado a 2
    3 bits = 2^3 = 000 001 010 011 100 101 110 111
    1 byte  = 8 bits ->  256 valores
    2 bytes = 65536
    4 bytes = Más de 4kM de valores diferentes ... me da pa meter los hasta 100M de datos distintos que puede tener un DNI?
  
Pero si guardo el DNI como un texto? 
Cuánto ocupa cada caracter en un sistema informático? DEPENDE del juego de caracteres que use. 
  UTF-8
  UTF-16
  ASCII
Lo normal es que un caracter básico (letras, números, signos de puntuación) me entran en 1 byte (256 valores)
Al menos 1 byte por caracter...
Por lo que el DNI me ocuparía? Al menos 9 bytes

Qué significa eso? Pasar de 4 bytes a 9? Más del doble...
- de información tengo que transmitir por una red
- de información tengo que guardar o leer de la RAM
- de información tengo que guardar o leer de un disco
- comparar en mi CPU para ver si 2 DNIs son iguales o no
En definitiva... si trabajo con textos, mi programa irá MUCHO MAS LENTO !!!! EXTRAORDINARIAMENTE MAS LENTO !

claro que ... esas comprobaciones...colocar en RM el computador las hace en micro segundos o incluso ns
Pero si tengo que hacer la operación 50M de veces?
CUIDAO

NUNCA JAMAS programo (hago un programa) contra unos datos! Eso no lo hacemos
PROGRAMO CONTRA UNA ESPECIFICACION !

## Análisis del DNI

// 12345.678-T         345678            
letraDelDni  = T
separador    = '8'
numeroDni    = ""
valido       = true
listaErrores = []

T
-
-
8
7
6
.
5
4
3
.
2
1




----------

Option[] es otro tipo de dato que tenemos en SCALA

Un option es como una CAJA... que puede tener algo dentro o no
Es una forma que usamos al programar de ofrecer información al que piede un dato
Para hacerle saber si le estamos dando o no el dato

Yo siempre voy a entregar esa CAJA.
Que podrá estar vacia o rellena... con un dato del tipo que defina (al definir el Option)

---
# Uso de OPTION

class Diccionario {

def existe(palabra:String):Boolean = {
return true
}

def obtenerSignificados(palabra:String): List[String] = {
  return List.empty(null)
}
// A dia de hoy eso que acabamos de hacer es una MUY MALA PRACTICA.
// Por qué?

}
....
dict1.obtenerSignificados("estringoclestro")
Quizás la función devolverá una Lista vacia
Pero... quizás el programador ha optado por devolver un null

A priori, yo no soy el tio que ha desarrollado esa funcion.... no se lo que habrá dentro ese personaje!!!!
Cómo lo averiguo?
- Mirar el código es una opción... que me lleva tiempo ... y si acaso puedo verlo... 
- Mirar la documentación de la función... que me lleva tiempo... y si acabo el buen personaje ha optado por escribir una documentación...
- Lo pruebo y que sea lo que Dios quiera!... yo que sé




(1) def obtenerSignificados(palabra:String): List[String] = {
  
  VVV

(2) def obtenerSignificados(palabra:String): Option[List[String]] = {


En 1, no se si me devuelven null o lista vacia
En 2... lo tengo muy claro:
- Si paso una palabra que exista recibo:
   Un Option(una caja) que contendrá una lista con los significados (strings)
- Si paso una palabra que no exista recibo?
   Un Option(caja) vacia
y se que no voy a recibir nunca un null... por qué lo se? 
- PORQUE HOY EN DIA ESTA PROHIBIDISIMO DEVOLVER NULL DESDE UNA FUNCION
- NO SE HACE
- FATAL TIO !!!!!!

---
# INTERPOLACION DE TEXTOS

var edad = 33
var nombre= "Menchu"

var saludo = "$nombre tiene $edad años"

Si ejecuto eso:
              Menchu tiene 33 años

----

# Tipos de datos en scala

HEredado de una gran cagada que tiene JAVA en su sintaxis,
En scala de forma encubierta tenemos tipos de datos de 2 naturalezas diferentes:
- Tipos de datos que admiten como valor null
- Tipos de datos que no admiten como valor null

A una variable de tipo Char, Integer, Double, Boolean 
no se le puede asignar el valor null

---

# QUE ENTENDEMOS POR UNA PRUEBA 

ME COMPRUEBA una CARACTERISTICA DE UN SISTEMA:
- Al final de la prueba, debo saber si la característica se cumple o no se cumple.

- Una prueba acaba en 3 posibles estados:
- Superada
- No superada
- No se pudo ejecutar, explotó !!!!

En nuestro caso, que característica(s) queremos comprobar? Si mi librería funciona bien !

---
# Vocabulario en el mundo de las pruebas

- Errores   Son cometidos por seres humanos
- Defectos  Al cometer un error podemos introducir un DEFECTO en un sistema 
- Fallos    Ese defecto puede manifestarse como un FALLO cuando pongo el sistema en funcionamiento... o no!

# Para que sirven las pruebas? 

Y no hablo solo de software...

- Me permite asegurar que un requisito se cumple de un sistema
- Detectar fallos, para lo cual pondré en funcionamiento el sistema... 
  y veo si se comporta de manera adecuada de acuerdo al requisito
  Tras identificar un fallo, se procede a identificar el defecto que lo ocasiona... DEPURACION / DEBUGGING
- Analizar los errores que se cometen. Análisis de causas raices!
- Conocer el estado del proyecto

# Clasificación de las pruebas

## En base al nivel del objeto de prueba

- Pruebas unitarias               Se centran en un COMPONENTE AISLADO del sistema
- Pruebas de integración          Se centran en la COMUNICACION entre componentes (a lo mejor solo 2)
- Pruebas de sistema(end2end)     Se centran en el COMPORTAMIENTO del sistema en su conjunto 
  - Pruebas aceptación            Suelen ser un subconjunto de las de sistema... SON LAS QUE ME PIDEN !

# Objetos de prueba

- Pruebas estáticas               No requieren poner el sistema en funcionamiento:
    - Calidad de código
    - Calidad de datos
- Pruebas dinámicas               SI REQUIEREN poner el sistema en FUNCIONAMIENTO
  - Pruebas funcionales           Se centran en la funcionalidad
  - Pruebas no funcionales        Se centran en otros aspectos
    - Pruebas de rendimiento
    - Prueba de estres
    - Pruebas de carga
    - UX
    - Backup
    - HA

##

A día de hoy el uso de la metodologías ágiles nos ha dado algunos dolores de cabeza... que no teníamos antes!
Hoy en día, entrego en producción cada 2 semanas, 3 semanas como mucho.
Entrega en producción = HACER MONTONES DE PRUEBAS !
Entregar el producto de forma incremental.

Día 15 del proyecto :
  5% de la funcionalidad => Pruebas   5%

Día 30 del proyecto :
  +5% de la funcionalidad =>          5% nuevo + 5% anterior

Día 45 del proyecto :
 +10% de la funcionalidad

Día 60 del proyecto :
  +4% de la funcionalidad

Las metodologías ágiles DISPARAN el número de pruebas!!!!
Y no hay pasta !!!!

ESTO SOLO TIENE UNA SOLUCION: AUTOMATIZAR  ! 
