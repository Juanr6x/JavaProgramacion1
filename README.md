# Juego Plantas Invasoras

Este es un juego simple llamado "Plantas Invasoras". El juego está desarrollado en Java y
utiliza la biblioteca `entorno` para la interfaz del juego.

## Clases

El juego consta de varias clases:

- `Juego`: Esta es la clase principal que ejecuta el juego.
- `Calle`: Esta clase contiene toda la lógica del juego.
- `Laika`: Esta clase representa al personaje principal del juego.
- `Auto`: Esta clase representa los autos en el juego.
- `Planta`: Esta clase representa las plantas en el juego.
- `Cuadra`: Esta clase representa las cuadras en el juego.
- `BolaDeFuego`: Esta clase representa las bolas de fuego en el juego.

## Lógica del Juego

El juego comienza inicializando una instancia de `Entorno` y `Calle`. La instancia de `Calle`
contiene todas las cuadras, autos, plantas y bolas de fuego del juego. El juego se inicia con
el método `entorno.iniciar()`.

Durante cada tick (ciclo) del juego, se dibuja la calle y a Laika en el entorno. Si Laika está
viva, se mueve según las entradas del usuario y se comprueba si alguna planta la ataca. Si
Laika no está viva, se termina el juego.

Los autos y las plantas también se mueven durante cada tick. Las plantas disparan bolas de
fuego en varias direcciones.

## Informe

Para obtener más detalles sobre el juego "Plantas Invasoras", puedes consultar el informe
completo en el siguiente enlace:

[Informe Completo](https://1drv.ms/w/s!Aqz7qbuEl3rgg9p3mHw7xD0Aitylxw?e=Y6ZC8h)
