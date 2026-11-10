/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraextendida;

/**
 *
 * @author Emilio
 */
public class ConversorTemperatura {

    //Convierte grados Celsius a Fahrenheit
     
    public double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    //Convierte grados Fahrenheit a Celsius: °C = (°F − 32) × 5/9
    public double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
