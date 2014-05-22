/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import modelo.JSONParseador;
import modelo.NumeroAleatorio;
import modelo.URLConnection;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Macias
 */
public class GeneraPalabra implements Runnable {

    private final String API_SUBPALABRAS = "http://store.apicultur.com/api/subpalabras/1.0.0/";
    private final String API_DICCIONARIO = "http://store.apicultur.com/api/dicc/1.0.0/definicion/10/";
    private final String API_KEY = "X8Hg4xooJ6ybIDYMDFnR1jGaksca";

    private final char[] VOCALES = {97, 101, 105, 111, 117};

    private JSONParseador jsonParseador;

    private String PALABRA_FINAL;
    private String DEFINICION;
    private int TOTAL_LETRAS = 9;
    private ArrayList<String> listaLetras;
    
    private JLabel label;

    private void generarPalabra() {
        String letras = "";
        int longitud_palabra;
        try {
            do {
                letras = "";
                longitud_palabra = 0;
                int cantidadLetras = NumeroAleatorio.generaNumero(4, TOTAL_LETRAS);

                for (int i = 0; i < cantidadLetras; i++) {
                    if (i % 2 == 0) {
                        letras += VOCALES[NumeroAleatorio.generaNumero(0, 4)];
                    } else {
                        int consonante = 0;
                        boolean bandera = true;
                        do {
                            consonante = NumeroAleatorio.generaNumero(97, 122);
                            if ((consonante != 97) && (consonante != 101) && (consonante != 105)
                                    && (consonante != 111) && (consonante != 117)) {
                                bandera = false;
                                letras += (char) consonante;
                            }
                        } while (bandera);
                    }
                }

                String url = API_SUBPALABRAS + letras + "/1/" + cantidadLetras;

                URLConnection urlConnection = new URLConnection();
                jsonParseador = new JSONParseador();

                ArrayList<String> lista = jsonParseador.parsearJSONArray(urlConnection.sendGetApiJSON(url, API_KEY));

                PALABRA_FINAL = seleccionarPalabra(lista);

                url = API_DICCIONARIO + PALABRA_FINAL;
                String[] array = jsonParseador.parsearJSONDiccionario(urlConnection.sendGetApiJSON(url, API_KEY));
                PALABRA_FINAL = array[0];
                DEFINICION = array[1];

                longitud_palabra = PALABRA_FINAL.length();

            } while (longitud_palabra < 4);
            
            mixLetras();

        } catch (ParseException ex) {
            Logger.getLogger(GeneraPalabra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GeneraPalabra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String seleccionarPalabra(ArrayList<String> lista) {
        String palabra = lista.get(0);
        return palabra;
    }

    private void mixLetras() {
        char[] letras = PALABRA_FINAL.toCharArray();
        listaLetras = new ArrayList();
        for (int i = 0; i < letras.length; i++) {
            listaLetras.add(letras[i] + "");
        }

        if (listaLetras.size() < TOTAL_LETRAS) {
            int faltantes = TOTAL_LETRAS - listaLetras.size();
            for (int i = 0; i < faltantes; i++) {
                listaLetras.add((char) NumeroAleatorio.generaNumero(97, 122) + "");
            }
        }
        
        Collections.shuffle(listaLetras);
    }

    public String getPALABRA_FINAL() {
        return PALABRA_FINAL;
    }

    public String getDEFINICION() {
        return DEFINICION;
    }

    public ArrayList<String> getListaLetras() {
        return listaLetras;
    }

    @Override
    public void run() {
        while (PALABRA_FINAL == null && DEFINICION == null) {            
            this.label.setForeground(Color.red);
            this.label.setText("Generando palabra...");
            generarPalabra();
        }
        this.label.setText("");
        System.out.println(PALABRA_FINAL);
        System.out.println(DEFINICION);
        System.out.println(listaLetras);
    }
    
    public void iniciar(JLabel label) {
        this.label = label;
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
}
