# hotel-backend

Para correr la aplicación, primero se debe crear una base de datos en MySQL llamada

`bookingmdw`

para usuario `root` sin clave.

Correr el servidor con la base de datos y luego se debe ir al directorio base del proyecto y correr:

`mvn spring-boot:run`

# Branch naming
Al crear un branch se debe crear desde la rama `develop`, dicho branch debe seguir el siguiente formato para su nombre:

`[Código Historia de Usuario]_[Número de la tarea si existe]`

Es decir, el branch para la Historia de Usuario `TUH-01`, y la historia `T01.02` del mismo se debe llamar:

`TUH-01_02`

# Mensaje de un Commit

Cada commit debe ir acompañado con un mensaje explicativo de lo que se realizó en el mismo.
Dicho mensaje debe iniciar por el nombre del branch, dos puntos y luego la descripción de lo realizado, es decir:

`TUH-01_02: creada la base del proyecto`

# Pull Request

Cuando se haya finalizado una Tarea y se desee subir el código al repositorio, se debe crear un Pull Request apuntando
al branch `develop` y se deben agregar a todos los demás integrantes como Reviewer