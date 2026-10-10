# Gestor de Listas de Reproducción (Lista Circular Doblemente Enlazada)

## 👥 Integrantes del Equipo
- Samuel Alejandro Mosqueda Zacatenco
## 🛠️ Entorno de Desarrollo
- **Lenguaje:** Java (Compatible con Java 8, 11, 17 y superiores)
- **Estructura de Datos:** Lista Doblemente Enlazada Circular (Implementación manual mediante manejo de referencias, sin uso de colecciones nativas).

## Instrucciones de Compilación y Ejecución

Para correr el proyecto desde la consola de comandos de Windows (CMD) o cualquier terminal estándar:

1. Navega hasta el directorio donde se encuentran los archivos `.java`.
2. **Para compilar el código**, ejecuta:
   `javac *.java`
3. **Para iniciar el programa**, ejecuta:
   `java Main`

##  Pruebas de Funcionamiento Utilizadas
El sistema fue sometido a pruebas exhaustivas mediante el menú interactivo para garantizar la correcta manipulación de punteros y la complejidad algorítmica requerida:

1. **Operaciones sobre lista vacía:** Se verificó la ausencia de `NullPointerException` al intentar avanzar o eliminar.
2. **Navegación Circular:** Comprobación del salto de referencia del último nodo al primero (Avanzar) y del primero al último (Retroceder).
3. **Eliminación Quirúrgica:** Eliminación de la "canción actual" en O(1), aislando el nodo correctamente para el Recolector de Basura (Garbage Collector).
4. **Reproducción Simulada `k` veces:** Verificación de bucles circulares sin ciclos infinitos, utilizando condicionales de parada basados en el nodo de inicio.
5. **Consistencia de Inserciones:** Se probó la inserción O(1) comprobando que las referencias `prev` y `next` se actualizaran correctamente.
