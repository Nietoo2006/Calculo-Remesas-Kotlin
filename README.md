# Sistema de Cálculo de Remesas en Kotlin

Este repositorio contiene un algoritmo desarrollado en **Kotlin** para calcular el monto real de una remesa (`mr`) a partir de un monto total (`T`), descontando el Impuesto a las Transacciones Financieras (ITF) y una comisión escalonada.

## 📝 Descripción del Proyecto

El programa resuelve un problema matemático inverso: en lugar de sumar los cargos al monto de la remesa, el usuario ingresa el **Monto Total** que se pagó, y el sistema calcula automáticamente cuál fue la remesa original, cuánto se cobró de comisión y cuánto de ITF. 

Para lograr esto, el algoritmo utiliza funciones algebraicas despejadas según los topes establecidos en las reglas de negocio.

## 📊 Reglas de Negocio (Enunciado)

El sistema considera los siguientes cargos:
1. **ITF (Impuesto a las Transacciones Financieras):** 0.005% del monto de la remesa.
2. **Comisión:** Depende del monto de la remesa (`mr`) según la siguiente tabla:

| Monto de Remesa (`mr`) | Comisión aplicada |
| :--- | :--- |
| `mr <= 1000` | 5.00 |
| `1000 < mr <= 10001` | 0.5% de `mr` |
| `mr > 10001` | 1.5% de `mr` |

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Kotlin
* **Entrada de datos:** `java.util.Scanner` (Modo consola)
* **Conceptos aplicados:** Funciones, estructuras condicionales (`if/else`), bucles (`while`) y operadores aritméticos.

## ⚙️ Estructura del Código

El código está modularizado en funciones para hacerlo más limpio y fácil de mantener:
* `calcularRemesa(total: Double)`: Determina el monto de la remesa evaluando los saltos matemáticos.
* `calcularComision(mr: Double)`: Calcula la comisión según las reglas de negocio.
* `calcularITF(mr: Double)`: Calcula el impuesto fijo.
* `main()`: Maneja la interfaz por consola y el bucle de repetición.

## 🚀 Cómo ejecutar el programa

1. Clona este repositorio en tu computadora o descarga el archivo `.kt`.
2. Abre el archivo en **IntelliJ IDEA** (o cualquier IDE compatible con Kotlin).
3. Ejecuta la función `main`.
4. La consola te pedirá ingresar el Monto Total (T). Ingresa un número (ej. `1500.50`) y presiona Enter.
5. El programa te mostrará el desglose detallado y te preguntará si deseas calcular otro monto.

---
*Desarrollado como tarea académica de Algoritmos y Programación.*
