# Participantes
* Carlos Fernández - 26883
* Alvaro Flores - 261868

# Análisis - Laboratorio 2

## 1. ¿Qué propiedades y métodos tendrá cada clase?
### PuntoAcceso
#### Atributos
* codigo, nombre, ubicacion, capacidadMaximaPorHora, estado.
#### Métodos
* PuntosAcceso(), getCodigo(), getNombre(), getUbicacion(), getCapacidadMaximaPorHora(), getEstado(), setNombre(), setUbicacion(), setCapicidadMaximaPorHora(), setEstado().

### Visitante
#### Atributos
* codigoEntrada, nombre, edad, cantidadAtraccionesVisitadas, puntosAcumulados, ArrayList: visitante.
#### Métodos
* Visitantes(), getCodigoEntrada(), getNombre(), getEdad(), getCantidadAtraccionesVisitadas(), getPuntosAcumulados(), setNombre(), setEdad(), setCantidadAtraccionesVisitadas(), setPuntosAcumulados()

### EnumEstado
* Abierto
* Cerrado
* Mantenimiento

### Parque
#### Atributos
* nombre, codigoIdentificacion, nombreEncargado, PuntoAcceso[] puntosAcceso
#### Métodos
* habilitarPuntosAcceso(), obtenerPuntosAcceso(), mostrarPuntosAcceso(), modificarPuntoAcceso(), cerrarPuntosAcceso(), contarPuntosAcceso(), contarEspaciosDisponibles(),
obtenerMayorCapacidad()

### Main
#### Métodos
* main(), mostrarMenu(), procesarOpcion(), leerEntero(), leerTexto().

## 2. ¿Qué tipo deben tener las propiedades y métodos de cada clase?

### PuntoAcceso
#### Atributos
* codigo = String
* nombre = String
* ubicacion = String
* capacidadMaximaPorHora = int
* estado = EstadoPuntoAcceso

#### Métodos
* PuntosAcceso() 
* getCodigo() = String
* getNombre() = String
* getUbicacion() = String
* getCapacidadMaximaPorHora() = int
* getEstado() = EstadoPuntoAcceso
* setNombre() = void
* setUbicacion() = void
* setCapicidadMaximaPorHora() = void
* setEstado() = void

### Visitante
#### Atributos
* codigoEntrada = String
* nombre = String
* edad = int
* cantidadAtraccionesVisitadas = int
* puntosAcumulados = int
* ArrayList(Visitante) = visitante
#### Métodos
* Visitantes() = String
* getCodigoEntrada() = String
* getNombre() = int
* getEdad() = int
* getCantidadAtraccionesVisitadas() = int
* getPuntosAcumulados() = int
* setNombre() = void
* setEdad() = void
* setCantidadAtraccionesVisitadas() void
* setPuntosAcumulados() = void

### EnumEstado
* Abierto
* Cerrado
* Mantenimiento

### Parque
#### Atributos
* nombre = String
* codigoIdentificacion = String
* nombreEncargado = String
* PuntoAcceso[] puntosAcceso
#### Métodos
* habilitarPuntosAcceso() = boolean
* obtenerPuntosAcceso() = PuntoAcceso
* mostrarPuntosAcceso() = void
* modificarPuntoAcceso() = boolean
* cerrarPuntosAcceso() = boolean
* contarPuntosAcceso() = int
* contarEspaciosDisponibles() = int
* obtenerMayorCapacidad() = PuntoAcceso

### Main
#### Métodos
* main() = void
* mostrarMenu() = void
* procesarOpcion() = void
* leerEntero() = int
* leerTexto() = String

## 3. ¿Cuál de las propiedades identificadas debe implementarse utilizando un arreglo básico? ¿Qué tipo de objetos almacenará y cuál será su tamaño?

Se debería implementar un:

    private PuntoAcceso[ ] puntosAcceso

Así iniciará con un nuevo acceso fijo de “puntosAcceso = new PuntoAcceso[5] “. donde cada posición guardará un punto de acceso hasta llegar a 5, este siendo su límite.

## 4. Así iniciará con un nuevo acceso fijo de “puntosAcceso = new PuntoAcceso[5] “. donde cada posición guardará un punto de acceso hasta llegar a 5, este siendo su límite.

> private ArrayList< Visitante > visitantes;

Con este arraylist se almacenarán los objetos del usuario, guardando sus datos y cuántos de ellos vinieron. Siempre iniciando con un constructor.

> visitantes = new ArrayList<>();

## 5. ¿Cuáles deben ser los modificadores de visibilidad de los miembros en cada clase?

Las siguientes propiedades deben ser privadas debido al encapsulamiento:

    private int edad;
    
    private PuntoAcceso[] puntosAcceso;
    
    private ArrayList<Visitante> visitantes;

Los constructores, getters y operaciones que otras clases necesitan utilizar serán públicos.

## 6. ¿Qué parámetros serán requeridos por los métodos en sus clases?

### En PuntoAcceso:
    habilitarPuntoAcceso(int posicion, PuntoAcceso punto)

Se necesita la posición y el objeto.

    modificarPuntoAcceso(int posicion, int nuevaCapacidad, EstadoPuntoAcceso nuevoEstado)

Llama a la posición y los nuevos valores.

    cerrarPuntoAcceso(int posicion)

Ubica la posición que se dejará en null.

### En visitantes:

    registrarVisitante(Visitante visitante)

Recibe el visitante que se agregará a la ArrayList.

    buscarVisitante(String codigoEntrada)

Recibe el código que se desea localizar.

    modificarVisitante(String codigoEntrada, String nuevoNombre, int nuevaEdad, int nuevasAtracciones, int nuevosPuntos)

Recibe el código del visitante que será modificado y sus nuevos datos.

## 7. ¿Cómo proveerá de valores iniciales a sus objetos? ¿Qué valores deberán validarse antes de modificar el estado de los objetos?

Los valores serán creados por medio de constructores. Al iniciar el programa, se pedirá el nombre del parque, su código de identificación y el nombre del encargado. Estos datos se enviarán al constructor de la clase Parque.
El constructor de Parque también creará un arreglo con cinco posiciones para los puntos de acceso y un ArrayList inicialmente vacío para los visitantes, para así marcar un máximo de posiciones.

Al crear un objeto PuntoAcceso, el constructor recibirá el código, nombre, ubicación, capacidad máxima y estado. Antes de guardar la capacidad, se deberá verificar que sea mayor que cero. Si no cumple esta condición, se generará una IllegalArgumentException.
Al crear un objeto Visitante, se deberá verificar que la edad sea mayor que cero, la cantidad de atracciones visitadas no sea negativa y que los puntos acumulados no sean negativos. De no ser así, se generará una IllegalArgumentException.


## 8. ¿Cómo determinará si una posición del arreglo contiene un punto de acceso o contiene null?

Primero se debe comprobar que el índice se encuentre dentro de sus límites. Como el arreglo tiene cinco espacios. Después de validar el índice, el programa comparará el contenido de la posición con null. Si la posición es diferente de null, significa que contiene un objeto PuntoAcceso habilitado. Si es igual a null, significa que el espacio se encuentra disponible.

Al recorrer el arreglo para mostrar los puntos habilitados, el programa deberá evaluar esta condición antes de utilizar los métodos del objeto. De esta manera, las posiciones vacías no se mostrarán como puntos existentes y así evitando una posible NullPointerException.

Para cerrar un punto de acceso, después de validar que la posición existe y contiene un objeto, se le asigna nuevamente el valor null.

## 9. ¿Cómo realizará las operaciones de búsqueda, modificación y eliminación dentro del ArrayList?

Para buscar un visitante, se recorrerá todo el ArrayList. En cada iteración se comparará el código de entrada almacenado con el código proporcionado por el usuario. Si los códigos coinciden, se devolverá el objeto encontrado. Si el recorrido termina sin encontrar coincidencias, el método devolverá null. Esto permitirá comprobar que no se registre un segundo visitante con un código existente.

Para modificar un visitante, primero se buscará mediante su código de entrada. Si el objeto existe, se validarán los nuevos valores antes de realizar cualquier cambio. Después de comprobar que los objetos de edad, las atracciones y los puntos cumplen los parámetros establecidos, se utilizarán los setters para actualizar la información. Si el visitante no existe, el programa mostrará un mensaje y regresará al menú sin finalizar inesperadamente. Así evitar que el visitante quede erróneo si alguno de los nuevos valores es incorrecto.

Para eliminar un visitante, primero se localizará su objeto dentro del ArrayList. Al encontrarlo, se utilizará un remove para retirarlo de la colección. 

## 10. ¿Qué situaciones del programa pueden producir excepciones? Identifique qué excepciones deberán manejarse y en qué partes del programa utilizará try-catch y finally.

Se debe crear una excepción al momento que el programa solicita un número y el usuario escribe un dato de otro tipo. Así que aplicamos un bloque try-catch. Dentro del catch, el programa limpiará la entrada incorrecta y permitirá que el usuario vuelva a ingresar el dato. Así se evita que el sistema finalice.

También se generará un IllegalArgumentException cuando se crea un punto de acceso con una capacidad menor o igual que cero, con un visitante con una edad menor o igual que cero, al establecer una cantidad negativa de atracciones y al establecer una cantidad negativa de puntos.

El acceso a una posición incorrecta podría producir un error. Así que debe prevenirse comprobando que la posición se encuentre entre los límites del arreglo.
Intentar utilizar los métodos de una posición que contiene null podría producir un error. Entonces, se debe verificar el contenido de la posición antes de utilizarla.

