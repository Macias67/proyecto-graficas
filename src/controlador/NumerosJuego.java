/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JToggleButton;
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

    public void setButtonsNumber(JToggleButton[] buttons) {
        if (buttons.length == MAX_NUMEROS_USADOS) {
            
            int totalNumeros = NUMEROS.size();

            if (totalNumeros < MAX_NUMEROS_USADOS) {
                
                int diferencia = MAX_NUMEROS_USADOS - totalNumeros;
                
                for (int i = 0; i < totalNumeros; i++) {
                    if (i == totalNumeros - 1) {
                        buttons[MAX_NUMEROS_USADOS-1].setText(NUMEROS.get(i) + "");
                    } else {
                        buttons[i].setText(NUMEROS.get(i) + "");
                    }
                }
                
                int continuacion = MAX_NUMEROS_USADOS - diferencia - 1;
                
                System.out.println(continuacion);
                for (; continuacion < totalNumeros-1; continuacion++) {
                    System.out.println(continuacion);
                }
                System.out.println(NUMEROS);
            }
        }
    }

    private ArrayList<Integer> getListaNumeros() {
        int usados = NumeroAleatorio.generaNumero(MIN_NUMEROS_USADOS, MAX_NUMEROS_USADOS);
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < usados; i++) {
            int numero;
            int min = (i == usados - 1) ? 10 : 1;
            int max = (i == usados - 1) ? 99 : 9;
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
            boolean banderaPorDecimales = false;
            LISTA_OPERADORES = getListaOperadores();
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
                            if (resultado % NUMEROS.get(j + 1) == 0) {
                                resultado /= NUMEROS.get(j + 1);
                            } else {
                                banderaPorDecimales = true;
                                j = LISTA_OPERADORES.size() - 1;
                            }
                            break;
                    }
                }
                break;
            }
            resultado = (banderaPorDecimales) ? 0 : resultado;
        } while ((resultado <= 0) || (resultado >= 1000));
        return resultado;
    }
}
