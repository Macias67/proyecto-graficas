/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.NumeroAleatorio;
import modelo.Operadores;

/**
 *
 * @author Macias
 */
public class NumerosJuego {

    private final ArrayList<Integer> NUMEROS;
    private ArrayList<Operadores> LISTA_OPERADORES;
    private final int RESULTADO;
    private final int MAX_NUMEROS_USADOS = 7;
    private final int MIN_NUMEROS_USADOS = 4;

    public NumerosJuego() {
        NUMEROS = getListaNumeros();
        RESULTADO = resultado();
    }

    public ArrayList<Integer> getNUMEROS() {
        return NUMEROS;
    }

    public ArrayList<Operadores> getLISTA_OPERADORES() {
        return LISTA_OPERADORES;
    }

    public int getRESULTADO() {
        return RESULTADO;
    }

    private ArrayList<Integer> getListaNumeros() {
        int usados = NumeroAleatorio.generaNumero(MIN_NUMEROS_USADOS, MAX_NUMEROS_USADOS);
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < usados; i++) {
            int numero;
            int min = (i == usados - 1) ? 10 : 1;
            int max = (i == usados - 1) ? 99 : 10;
            numero = NumeroAleatorio.generaNumero(min, max);
            numeros.add(numero);
        }
        return numeros;
    }

    private ArrayList<Operadores> getListaOperadores() {
        int usados = NUMEROS.size() - 1;
        ArrayList<Operadores> operadores = new ArrayList<>();
        for (int i = 0; i < usados; i++) {
            int operador = NumeroAleatorio.generaNumero(1, Operadores.values().length);
            if (Operadores.SUMA.getValue() == operador) {
                operadores.add(Operadores.SUMA);
            } else if (Operadores.RESTA.getValue() == operador) {
                operadores.add(Operadores.RESTA);
            } else if (Operadores.PRODUCTO.getValue() == operador) {
                operadores.add(Operadores.PRODUCTO);
            } else if (Operadores.COCIENTE.getValue() == operador) {
                operadores.add(Operadores.COCIENTE);
            }
        }
        return operadores;
    }

    private int resultado() {
        int resultado = 0;
        do {
            LISTA_OPERADORES = getListaOperadores();
            System.out.println("calculo...");
            for (int i = 0; i < NUMEROS.size(); i++) {
                resultado = NUMEROS.get(i);
                for (int j = 0; j < LISTA_OPERADORES.size(); j++) {
                    switch (LISTA_OPERADORES.get(j)) {
                        case SUMA:
                            resultado += NUMEROS.get(j + 1);
                            break;
                        case RESTA:
                            resultado -= NUMEROS.get(j + 1);
                            break;
                        case PRODUCTO:
                            resultado *= NUMEROS.get(j + 1);
                            break;
                        case COCIENTE:
                            resultado /= NUMEROS.get(j + 1);
                            break;
                    }
                }
                break;
            }
        } while ((resultado <= 0) || (resultado >= 1000));
        return resultado;
    }
}
