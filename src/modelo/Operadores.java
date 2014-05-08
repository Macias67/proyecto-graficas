/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Macias
 */
public enum Operadores {

    SUMA(1), RESTA(2), PRODUCTO(3), COCIENTE(4);
    
    private final int value;

    Operadores(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
