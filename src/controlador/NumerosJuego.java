/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JToggleButton;
import modelo.NumeroAleatorio;
import modelo.Operadores;
import modelo.OperadoresString;

/**
 *
 * @author Macias
 */
public class NumerosJuego {

    private static NumerosJuego INSTANCE;
    
    private ArrayList<Integer> NUMEROS;
    private ArrayList<Operadores> LISTA_OPERADORES;
    private int RESULTADO;
    
    private final int MAX_NUMEROS_USADOS = 7;
    private final int MIN_NUMEROS_USADOS = 4;

    private NumerosJuego() {  
    }
    
    public static NumerosJuego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NumerosJuego();
        }
        return INSTANCE;
    }
    
    public void generateNumbers() {
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

            ArrayList<Integer> listaCompleta = new ArrayList<>();

            for (Integer numero : NUMEROS) {
                listaCompleta.add(numero);
            }

            int size = listaCompleta.size();

            if (size < MAX_NUMEROS_USADOS) {
                int diff = MAX_NUMEROS_USADOS - size;
                for (int i = 0; i < diff; i++) {
                    listaCompleta.add(NumeroAleatorio.generaNumero(1, 9));
                }
            }

            Collections.shuffle(listaCompleta);

            for (int i = 0; i < listaCompleta.size(); i++) {
                buttons[i].setText(listaCompleta.get(i) + "");
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
        } while ((resultado <= 99) || (resultado >= 1000));
        return resultado;
    }
    
    public String mostrarResultado() {
        String resultado = "";
        for (int i = 0; i < NUMEROS.size(); i++) {
            resultado += NUMEROS.get(i);
            if (i != NUMEROS.size()-1) {
                resultado += " "+OperadoresString.valueOf(LISTA_OPERADORES.get(i).name()).getValue()+" ";
            }
        }
        return resultado;
    }
}
