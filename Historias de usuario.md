#  Historias de usuario

## 01 Items:
Como `jugador` quiero que el `juego` posea una serie de `items`, y con estos aumentar las stats de los personajes, de manera tal que sea
notorio el cambio con los mismos a la hora de batallar, y poder ver la vida y la energía de los personajes con las stats que corresponden al tener los items equipados. Los items se obtendrán mediante una batalla, de haberla ganado, el personaje ganador obtendrá un item.
### Condiciones de aceptación:
1. El item debe modificar al menos un atributo de mi personaje.
2. El item debe tener una foto única que lo representa junto con su nombre.
3. Sólo debe dar un item al personaje ganador de la batalla.

## 02 Inventario:
Como `jugador` quiero que mi `personaje` posea un `inventario` en el cual pueda visualizar los `items` del `personaje` y a su vez, visualizar los `atributos` que estos items aumentan a las stats del personaje. Teniendo en cuenta que el inventario tiene un máximo de 9 items.
### Condiciones de aceptación:
1. Debo poder visualizar correctamente los items de mi personaje.
2. Mi inventario debe llenarse cuando éste posea 9 items.
3. Al ganar una batalla con el inventario lleno, esta no debe darme ningún item.

## 03 Manipulación del inventario:
Como jugador, quiero tener la habilidad de `eliminar` items del inventario del personaje de manera tal de dejar libre el espacio ocupado por éste item.
### Condiciones de aceptación:
1. Debo notar de inmediato el cambio de atributos de mi personaje al eliminar el item.
2. Una vez eliminatdo, si salgo y vuelvo a entrar al juego, el item debe de no aparecer en mi inventario.

## 04 Mercado:
Como `jugador` quiero que mi `personaje` posea la habilidad de intercambiar sus items con los de otro `personaje`, y que realizado el `intercambio` se aprecien las nuevas `stats` de mi `personaje`. Nótese que existe un área de `comercio`, solo se puede comerciar si solo si están dentro de dicha zona.
### Condiciones de aceptación:
1. Sólo se debe permitir el intercambio de items es decir no puede existir un intercambio entre un item y no recibir ninguno.
2. Se debe controlar que la suma total de los items finales de cada `personaje` no supere el límite máximo, de hacerlo, no se debe permitir el intercambio.
3. El intercambio debe ser realizado sí sólo si ambos `personajes` aceptan el intercambio.
4. Cuando selecciono un `item`, debe aparecer las `stats` de este, para que el `jugador` sepa que `stats` posee ese `item`.
5. Si un `jugador` pretende comerciar con otro y este ultimo está fuera de la zona de comercio, se debe mostrar el mensaje correspondiente.
6. Si un `jugador` pretende comerciar con otro y éste está fuera de la zona de comercio, se debe msotrar el mensaje correspondiente.

## 05 Chat:
Como `jugador` quiero poseer la habilidad de comunicarme con otros `jugadores` mediante un `Chat`, así como también quiero una `Sala` en la cual el mensaje enviado sea recibido por todos los `jugadores`.
### Condiciones de aceptación:
1. Al enviar un mensaje el `jugador` receptor debe recibirlo instantáneamente.
2. Al enviar un mensaje en la `Sala` todos los jugadores deben recibir el mensaje instantáneamente.
3. Se debe poder batallar y hablar al mismo tiempo.
4. Se debe poder comerciar y hablar al mismo tiempo.

## 06 Skills:
Como `jugador` quiero tener la posibilidad de aumentar puntos a los `stats` de mi `personaje`. Para ello se deben acumular los puntos a medida que mi `personaje` aumenta de nivel.
### Condiciones de aceptación:
1. Al aumentar de nivel se deben acumular 3 puntos.
2. Se deben poder asignar los puntos a los stats que desee (siempre que alcancen mis puntos acumulados).
3. Se deben poder resetear los puntos de los stats, volviendo a su estado original (momento en el que se creo el personaje), y volver a asignarlos como desee.

## 07 NPC:
Como `jugador` quiero tener la posibilidad de pelear en contra de enemigos sin la necesidad de estar conectado con otros jugadores.
### Condiciones de aceptación:
1. Al acercarse al enemigo se comienza una batalla con el jugador, una vez derrotados estos deben desaparecer del mapa.
2. No debera haber mas de 10 enemigos al mismo tiempo.
3. Los enemigos solo puede luchar contra un jugador a la vez.

## 08 Cheats:
Como `jugador` quiero tener la posibilidad de obtener una ventaja sobre el resto.
### Condiciones de aceptación:
1. Al enviar el mensaje "war aint what it used to be" por el chat, mi personaje se vuelve invisible para el resto, exceptuando que haya otro invisible el cual me podria ver. Pudiendo sacarse el cheat enviando de nuevo la misma palabra.
2. Al enviar el mensaje "iddqd" por el chat, mi personaje se vuelve invulnerable a ataques del resto, exceptuando que haya otro invulnerable. En ese caso, los dos pelearan como si no tuvieran el cheat. Pudiendo sacarse el cheat enviando de nuevo la misma palabra.
3. Al enviar el mensaje "bigdaddy" por el chat, mi personaje tendra el doble de fuerza. En caso de enviar "tinydaddy", mi personaje tendra la mitad de la fuerza. Pudiendo sacarse el cheat enviando la palabra "bigdaddyoff" o "tinydaddyoff" segun sea el caso.
4. Al enviar el mensaje "noclip" por el chat, mi personaje podra atravesar paredes. Pudiendo sacarse el cheat enviando la palabra "siclip"
5. Al enviar el mensaje "run" por el chat, mi personaje podra correr dentro del juego moviendose mas rapido. Pudiendo sacarse el cheat enviando la palabra "walk"