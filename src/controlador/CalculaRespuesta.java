/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Macias
 */
public class CalculaRespuesta {

    private final NumerosJuego numerosJuego;
    private int RESPUESTA_FINAL;
    private int CALCULADO = 0;

    public CalculaRespuesta() {
        this.numerosJuego = NumerosJuego.getInstance();
    }

    public int resultado(String cadenaCalculo) {
        String[] tokens = cadenaCalculo.split(" ");
        int size = tokens.length;
        if (tokens.length > 1) {
            calcula(tokens[size - 2], tokens[size - 1]);
            return CALCULADO;
        } else {
            CALCULADO = Integer.parseInt(tokens[0]);
            return CALCULADO;
        }
    }

    private void calcula(String operador, String numero) {
        int num = Integer.parseInt(numero);
        switch (operador) {
            case "+":
                CALCULADO += num;
                break;
            case "-":
                CALCULADO -= num;
                break;
            case "*":
                CALCULADO *= num;
                break;
            case "/":
                CALCULADO /= num;
                break;
        }
    }

    public boolean encuentraRespuesta() {
        this.RESPUESTA_FINAL = numerosJuego.getRESULTADO();
        return (RESPUESTA_FINAL == CALCULADO);
    }

}
