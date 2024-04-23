
# Currency-Converter
Primer reto de la especialización de backend impartida por Alura.



## Objectivo 
Este es un programa simple que permite a los usuarios realizar conversiones de moneda utilizando una API de tipo de cambio.


## Funcionalidades

- Conversión de moneda entre diferentes tipos.
- Guardado de registros de conversiones en un archivo JSON.
- Opción para salir del programa y persistir los registros.

## Uso

1. Ejecuta el programa desde tu terminal o línea de comandos utilizando el comando `java Principal`.
2. Sigue las instrucciones en pantalla para seleccionar la moneda de origen y destino, ingresar el valor a convertir y elegir otras opciones.
3. Los registros de conversión se guardarán automáticamente en un archivo `conversions.json` en el directorio del programa.

## Creado por

- Dulce Itamar Vigueras Ballesteros




### Diferentes opciones de monedas

![Screenshot 2024-04-23 at 12 01 07 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/598d1002-53b2-445c-b5ba-67fa6ff466e3)


### Solicitando la moneda actual, la moneda que se desea obtener y el monto a cambiar
![Screenshot 2024-04-23 at 12 12 49 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/6df340de-cc6d-4f58-8447-04762b896cc5)

### Mostrar un mensaje con el resultado
![Screenshot 2024-04-23 at 12 15 07 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/d21a689d-c0b4-40d5-bab0-49bdce2d188e)


### Un mensaje es mostrado con 3 diferentes opciones 
- Sí (Para continuar usando el programa)
- No, deseo salir del programa sin imprimir los registros. (Salir del programa sin guardar las consultas)
- Imprimir los registros que he consultado y luego salir. (Guardar un archivo con las consultas realizadas en un archivo json y luego salir del programa)
  
  ![Screenshot 2024-04-23 at 12 26 28 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/22a8411d-0bf3-49fe-93c3-d88985fbadba)



### Archivo json creado

![Screenshot 2024-04-23 at 12 25 20 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/921c62b1-93c6-4d56-8132-110f7db8088c)

## Manejo de Errores

### Diferente tipo de datos
If el usuario ingresa valores de tipos diferentes de los disponibles, un mensaje de error aparecerá y solicitará al usuario una entrada válida.

![Screenshot 2024-04-23 at 12 29 26 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/0b0114bc-b0ea-43c0-aa06-00ba1ab8a0c6)

### Valores fuera del rango de valores disponibles 
If el usuario ingresa valores fuera del rango de las opciones disponibles (fuera del 1 al 24), un mensaje de error aparecerá solicitando al usuario un valor válido.

![Screenshot 2024-04-23 at 12 37 32 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/9ae9a5f7-6bef-4d12-9d62-3dde31f67359)


### Salir del programa
24 es la opción para salir del programa

![Screenshot 2024-04-23 at 12 38 17 a m](https://github.com/DulceItamar/currency-Converter/assets/98665735/c99af6b6-d3c4-4033-8c88-0e2855799404)
