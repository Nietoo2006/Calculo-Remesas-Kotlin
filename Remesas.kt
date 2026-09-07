import java.util.Scanner

// Función para calcular la remesa (mr) despejando la fórmula original
fun calcularRemesa(total: Double): Double {
    // Ecuación base: Total = mr + Comision + ITF
    // Sabemos que el ITF siempre es 0.00005 * mr (que equivale al 0.005%)
    
    // Calculamos primero los límites del Total (T) según los topes de mr:
    // Si mr = 1000  -> Total = 1000 + 5 + (1000 * 0.00005) = 1005.05
    // Si mr = 10001 -> Total = 10001 + (10001 * 0.005) + (10001 * 0.00005) = 10051.50505

    if (total <= 1005.05) {
        // Tramo 1: mr <= 1000
        // Total = mr + 5 + (0.00005 * mr)
        // Total = 1.00005 * mr + 5
        return (total - 5) / 1.00005
        
    } else if (total <= 10051.50505) {
        // Tramo 2: mr > 1000 y mr <= 10001
        // Total = mr + (0.005 * mr) + (0.00005 * mr)
        // Total = 1.00505 * mr
        return total / 1.00505
        
    } else {
        // Tramo 3: mr > 10001
        // Total = mr + (0.015 * mr) + (0.00005 * mr)
        // Total = 1.01505 * mr
        return total / 1.01505
    }
}

// Función para calcular la comisión basándonos en la remesa (mr)
fun calcularComision(mr: Double): Double {
    if (mr <= 1000) {
        return 5.0
    } else if (mr <= 10001) {
        return 0.005 * mr
    } else {
        return 0.015 * mr
    }
}

// Función simple para sacar el ITF de la remesa
fun calcularITF(mr: Double): Double {
    return 0.00005 * mr
}

fun main() {
    val scanner = Scanner(System.`in`)
    var continuar = "s"

    println("========================================")
    println("      SISTEMA DE CÁLCULO DE REMESAS     ")
    println("========================================")

    // Bucle para repetir el programa si el usuario lo desea
    while (continuar.lowercase() == "s") {
        print("\nIngrese el monto Total (T): ")
        val total = scanner.nextDouble()

        // Llamada a las funciones
        val mr = calcularRemesa(total)
        val comision = calcularComision(mr)
        val itf = calcularITF(mr)
        
        // Sumamos para verificar que todo cuadre
        val totalVerificado = mr + comision + itf

        println("\n--- RESULTADOS ---")
        // Utilizamos format(%.2f) para que se vea limpio en consola con 2 decimales
        println("Monto de remesa (mr) : %.2f".format(mr))
        println("Comisión aplicada    : %.2f".format(comision))
        println("ITF (0.005%%)         : %.2f".format(itf))
        println("----------------------------------")
        println("Total Comprobado     : %.2f".format(totalVerificado))

        print("\n¿Desea calcular otro monto? (s/n): ")
        continuar = scanner.next()
    }
    
    println("\nPrograma finalizado. ¡Gracias!")
}
