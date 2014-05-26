/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import vistas.Principal;

/**
 *
 * @author Macias
 */
public class Tiempo {

    private final Timer timer;
    private TimerTask timerTask;
    private final SimpleDateFormat simpleDateFormat;
    private JToggleButton[] arregloBotones;
    private JProgressBar barra;
    private Principal frame;
    private NumerosJuego numerosJuego;
    private int CONTADOR = 0;
    private final int TIEMPO = 45000;
    private String resp;

    public Tiempo() {
        this.timer = new Timer();
        this.simpleDateFormat = new SimpleDateFormat("ss:SSS");
    }

    public void setElements(JProgressBar barra, Principal frame) {
        this.barra = barra;
        this.barra.setMaximum(TIEMPO / 1000);
        this.barra.setStringPainted(true);
        this.frame = frame;
    }

    public void startNumeros() {
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                if (CONTADOR < TIEMPO) {
                    CONTADOR++;
                    barra.setValue(CONTADOR / 1000);
                    barra.setString(simpleDateFormat.format(CONTADOR));
                } else {
                    cancel();
                    numerosJuego = NumerosJuego.getInstance();
                    JOptionPane.showMessageDialog(barra.getParent(), "Se termino el tiempo, ¡Perdedor! \n Posible resultado: " + numerosJuego.mostrarResultado(), "Perdiste", JOptionPane.INFORMATION_MESSAGE);
                    frame.initButtons();
                }
            }
        };
        this.timer.scheduleAtFixedRate(timerTask, 0, 1);
    }
    
    public void startLetras(String respuesta) {
        this.resp = respuesta;
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                if (CONTADOR < TIEMPO) {
                    CONTADOR++;
                    barra.setValue(CONTADOR / 1000);
                    barra.setString(simpleDateFormat.format(CONTADOR));
                } else {
                    cancel();
                    JOptionPane.showMessageDialog(barra.getParent(), "Se termino el tiempo, ¡Perdedor! \n Resultado: " + resp.toUpperCase(), "Perdiste", JOptionPane.INFORMATION_MESSAGE);
                    frame.initButtonsLetras();
                }
            }
        };
        this.timer.scheduleAtFixedRate(timerTask, 0, 1);
    }

    public void stop() {
        this.timer.cancel();
        this.timer.purge();
    }

}
