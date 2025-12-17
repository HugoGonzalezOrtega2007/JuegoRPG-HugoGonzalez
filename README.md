# JuegoRPG-HugoGonzalez

¿Cómo jugar?

Al iniciar el programa, el juego dará la bienvenida al usuario y le pedirá que introduzca el nombre de su personaje junto con la clase que desea utilizar (mago, guerrero, druida, elfo, etc.). Una vez hecho esto, el programa preguntará si se quiere modificar algo antes de empezar. Si el usuario escribe "SI", podrá volver a introducir tanto el nombre como la clase. Si escribe "NO", la partida comenzará.

El personaje empezará la aventura con 100 puntos de vida (PS) como máximo, 50 puntos de magia (PM) con un máximo de 100, un multiplicador de daño de 1.0, 15 puntos de daño físico, 35 puntos de daño mágico y 0 monedas de oro. Los PS y PM no podrán superar nunca su valor máximo.

Nada más comenzar, el personaje se encontrará con un enemigo aleatorio (ogro, goblin, mago oscuro, slime, etc.). El programa mostrará un mensaje indicando el encuentro. La vida del enemigo será un número aleatorio entre 40 y 100, y en cada nuevo combate esta vida aumentará 5 puntos, haciendo los enfrentamientos progresivamente más difíciles.

Durante el combate se mostrarán las estadísticas del enemigo y del jugador, y el usuario podrá elegir entre varias opciones escribiendo su nombre tal y como aparece en el programa.

Opciones durante el combate
ATACAR:

Al escoger esta opción, el personaje realiza un ataque físico. El tipo de ataque se decide de forma aleatoria mediante el sistema de interacción. Si el ataque es normal, el daño infligido será el daño físico multiplicado por el multiplicador de daño. Si el ataque es esquivado, no se realizará ningún daño. En caso de que el ataque sea crítico, el daño será el daño normal multiplicado por 1.5.

ATAQUE MÁGICO:

En esta opción el jugador realiza un ataque mágico que consume exactamente 25 PM. El daño causado al enemigo será el daño mágico multiplicado por el multiplicador de daño. Este ataque no utiliza interacciones aleatorias, por lo que siempre hará daño si el jugador tiene puntos de magia suficientes.

OBJETOS:

Esta opción permite al jugador usar los objetos almacenados en su inventario, que tiene un tamaño máximo de 10 objetos. Las pociones de vida aumentan la vida actual del personaje en 25 PS, las pociones mágicas aumentan los puntos de magia en 25 PM, las pociones de daño aumentan permanentemente el daño base en 5 puntos, y las pociones de daño extremo aumentan permanentemente el multiplicador de daño en 0.05.

RENDIRSE:

Si el jugador decide rendirse, el combate termina inmediatamente y el personaje pierde exactamente 5 monedas de oro. Si después de esta pérdida el oro del jugador queda en 0 o en negativo, el personaje muere y la partida finaliza.

Turno del enemigo

Tras la acción del jugador, el enemigo realiza su ataque. El daño base del enemigo será un número aleatorio entre 10 y 20, y el tipo de ataque también se decidirá de forma aleatoria. Si el ataque es normal, el daño se aplica sin modificaciones; si es esquivado, el jugador no recibe daño; y si es crítico, el enemigo inflige el doble del daño normal. Al final de cada turno, el jugador recupera automáticamente 10 PM.

Después del combate

El combate termina cuando el enemigo muere, cuando el jugador muere o cuando el jugador se rinde. Si el jugador gana, recibe un objeto aleatorio del conjunto de recompensas y una cantidad aleatoria de oro entre 1 y 5 monedas. Además, el personaje recupera una cantidad aleatoria de vida comprendida entre 25 PS y su vida máxima menos 50 PS.

Tras una victoria, el programa muestra un mensaje indicando que el héroe ve una taberna a lo lejos y pregunta si desea entrar. Si el jugador entra, se mostrarán tres objetos aleatorios con precios aleatorios. El jugador solo podrá comprar un objeto y únicamente si dispone del oro suficiente. Si no compra nada, el juego continúa con un nuevo combate.

Fin del juego

La partida termina cuando los PS del personaje llegan a 0 o cuando el jugador se rinde y se queda sin dinero. En ese momento, el programa preguntará si se desea seguir jugando. Si el usuario decide continuar, el juego volverá a empezar desde la creación del personaje.
