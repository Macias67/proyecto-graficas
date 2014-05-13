/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Macias
 */
public enum OperadoresString {
    
    SUMA("+"), RESTA("-"), PRODUCTO("*"), COCIENTE("/");
    
    private final String value;

    OperadoresString(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
}
