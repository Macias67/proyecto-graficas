/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import controlador.NumerosJuego;
import java.util.ArrayList;
import modelo.Operadores;
import vistas.Principal;

/**
 *
 * @author Macias
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Principal.main(args);
        NumerosJuego numerosJuego = new NumerosJuego();
        ArrayList<Integer> lista = numerosJuego.getNUMEROS();
        ArrayList<Operadores> operadores = numerosJuego.getLISTA_OPERADORES();
        
        for (Integer numero : lista) {
            System.out.println(numero);
        }
        
        System.out.println("-------------------");
        
        for (Operadores op : operadores) {
            System.out.println(op.getValue());
        }
        
         System.out.println("-------------------");
        
        System.out.println("TOTAL: "+numerosJuego.getRESULTADO());
    }
}
