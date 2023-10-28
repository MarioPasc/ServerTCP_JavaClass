# ServerTCP

Servidor TCP simple escrito en Java diseñado para recibir conexiones de clientes, procesar mensajes y enviar respuestas.

## Descripción

El programa `ServerTCP` establece un servidor TCP que escucha en un puerto específico. Una vez que un cliente se conecta, el servidor recibe mensajes, los convierte a mayúsculas, invierte el orden de los caracteres y luego envía el resultado de vuelta al cliente. La conexión se cierra cuando el cliente envía el mensaje "END".

## Características

- Escucha en un puerto específico esperando conexiones de clientes.
- Procesa los mensajes de los clientes (conversión a mayúsculas e inversión de caracteres).
- Envía respuestas procesadas a los clientes.
- Gestión de errores de conexión y desconocidos.
- Soporta múltiples conexiones de clientes de forma secuencial.

## Uso

Para ejecutar el servidor, se necesita Java y el siguiente comando:

```bash
java ServerTCP
