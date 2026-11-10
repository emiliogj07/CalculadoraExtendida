/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraextendida;

/**
 *
 * @author Emilio
 */
public class Raizcuadrada_Exponente {
    //Calcula la raíz cuadrada de un número validando que no sea negativo.
    public double calcularRaiz(double numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz de un número negativo.");
        }
        return Math.sqrt(numero);
    }

    // Eleva una base a un exponente dado.
    public double calcularExponente(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
