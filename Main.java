/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraextendida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Emilio
 */


// Ventana gráfica
public class Main extends JFrame {

    // Instancias de lógica (POO)
    private final Calculadora calc = new Calculadora();
    private final ConversorTemperatura conversor = new ConversorTemperatura();
    private final Raizcuadrada_Exponente avanzado = new Raizcuadrada_Exponente();

    // Componentes Calculadora
    private JTextField txtNum1, txtNum2, txtResCalc;

    // Componentes Temperatura
    private JTextField txtTempInput, txtResTemp;

    // Componentes Raíz y Exponente
    private JTextField txtBase, txtExp, txtResAvanzado;

    public Main() {
        setTitle("Calculadora Extendida y Conversor");
        setSize(480, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.addTab("Calculadora", crearPanelCalculadora());
        pestanas.addTab("Temperatura", crearPanelTemperatura());
        pestanas.addTab("Raíz y Exponente", crearPanelAvanzado());

        add(pestanas);
    }

    // Panel 1: Operaciones básicas (+, -, *, /)
    private JPanel crearPanelCalculadora() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        txtNum1 = new JTextField();
        txtNum2 = new JTextField();
        txtResCalc = new JTextField();
        txtResCalc.setEditable(false);

        panel.add(new JLabel("Número 1:"));
        panel.add(txtNum1);
        panel.add(new JLabel("Número 2:"));
        panel.add(txtNum2);

        JButton btnSumar = new JButton("+");
        JButton btnRestar = new JButton("-");
        JButton btnMultiplicar = new JButton("×");
        JButton btnDividir = new JButton("÷");

        btnSumar.addActionListener(e -> operar('+'));
        btnRestar.addActionListener(e -> operar('-'));
        btnMultiplicar.addActionListener(e -> operar('*'));
        btnDividir.addActionListener(e -> operar('/'));

        panel.add(btnSumar);
        panel.add(btnRestar);
        panel.add(btnMultiplicar);
        panel.add(btnDividir);

        panel.add(new JLabel("Resultado:"));
        panel.add(txtResCalc);

        return panel;
    }

    private void operar(char op) {
        try {
            double n1 = Double.parseDouble(txtNum1.getText().trim());
            double n2 = Double.parseDouble(txtNum2.getText().trim());
            double res = 0;

            switch (op) {
                case '+': res = calc.sumar(n1, n2); break;
                case '-': res = calc.restar(n1, n2); break;
                case '*': res = calc.multiplicar(n1, n2); break;
                case '/': res = calc.dividir(n1, n2); break;
            }
            txtResCalc.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar números válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Aritmético", JOptionPane.ERROR_MESSAGE);
            txtResCalc.setText("Error: Div/0");
        }
    }

    // Panel 2: Conversor de Temperatura
    private JPanel crearPanelTemperatura() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        txtTempInput = new JTextField();
        txtResTemp = new JTextField();
        txtResTemp.setEditable(false);

        panel.add(new JLabel("Valor a convertir:"));
        panel.add(txtTempInput);

        JButton btnFtoC = new JButton("°F → °C");
        JButton btnCtoF = new JButton("°C → °F");

        btnFtoC.addActionListener(e -> {
            try {
                double val = Double.parseDouble(txtTempInput.getText().trim());
                double res = conversor.fahrenheitACelsius(val);
                txtResTemp.setText(String.format("%.2f °C", res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCtoF.addActionListener(e -> {
            try {
                double val = Double.parseDouble(txtTempInput.getText().trim());
                double res = conversor.celsiusAFahrenheit(val);
                txtResTemp.setText(String.format("%.2f °F", res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(btnFtoC);
        panel.add(btnCtoF);
        panel.add(new JLabel("Resultado:"));
        panel.add(txtResTemp);

        return panel;
    }

    // Panel 3: Raíz cuadrada y Exponente
    private JPanel crearPanelAvanzado() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        txtBase = new JTextField();
        txtExp = new JTextField();
        txtResAvanzado = new JTextField();
        txtResAvanzado.setEditable(false);

        panel.add(new JLabel("Número / Base:"));
        panel.add(txtBase);
        panel.add(new JLabel("Exponente (solo potencia):"));
        panel.add(txtExp);

        JButton btnRaiz = new JButton("Raíz Cuadrada (√)");
        JButton btnPotencia = new JButton("Exponencial (^)");

        btnRaiz.addActionListener(e -> {
            try {
                double b = Double.parseDouble(txtBase.getText().trim());
                double res = avanzado.calcularRaiz(b);
                txtResAvanzado.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido en la base.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPotencia.addActionListener(e -> {
            try {
                double b = Double.parseDouble(txtBase.getText().trim());
                double p = Double.parseDouble(txtExp.getText().trim());
                double res = avanzado.calcularExponente(b, p);
                txtResAvanzado.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar base y exponente válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(btnRaiz);
        panel.add(btnPotencia);
        panel.add(new JLabel("Resultado:"));
        panel.add(txtResAvanzado);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
