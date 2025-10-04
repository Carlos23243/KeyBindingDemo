# KeyBindingDemo
# Captura de Tecla 'C' en Java Swing (Key Bindings)

Este proyecto es una implementación en **Java Swing** para demostrar la correcta captura de eventos de teclado en un componente específico de una Interfaz Gráfica de Usuario (GUI), utilizando la técnica recomendada de **Key Bindings**.

---

## Objetivo del Ejercicio

Implementar un mecanismo robusto para detectar la pulsación de la tecla **'C'** sobre una ventana de Swing y ejecutar una acción programada como respuesta.

La acción específica implementada es:
1.  Imprimir un mensaje de confirmación en la **consola**.
2.  **Alternar el estado de selección** del primer elemento de la `JList` (Seleccionar/Deseleccionar).

---

## Tecnología y Requisitos

* **Lenguaje:** Java
* **Framework GUI:** Java Swing
* **Manejo de Teclado:** Key Bindings (`InputMap` y `ActionMap`)
* **Componentes:** `JFrame`, `JPanel`, `JList`, `JButton`.

### Solución Técnica: Key Bindings

Se utilizó el mecanismo de **Key Bindings** (`javax.swing.InputMap` y `javax.swing.ActionMap`) en lugar de `KeyListener` para garantizar una captura de eventos más predecible y desacoplada del foco.

La configuración clave es la siguiente:

* **Componente de Registro:** El `JPanel` principal.
* **Condición de Foco:** `JComponent.WHEN_IN_FOCUSED_WINDOW`. Esto permite que la acción se active cuando la ventana está enfocada, independientemente de si la `JList` o el `JButton` tienen el foco directo.
* **KeyStroke:** Se mapeó el `KeyStroke` correspondiente a la tecla `KeyEvent.VK_C` a una instancia de `AbstractAction`.
