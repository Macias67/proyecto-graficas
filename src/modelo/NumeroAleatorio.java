/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Macias
 */
public class NumeroAleatorio {

    private static Random random;

    public static int generaNumero(int minimo, int maximo) {
        random = new Random();
        int max = maximo - minimo + 1;
        return random.nextInt(max) + minimo;
    }
}
