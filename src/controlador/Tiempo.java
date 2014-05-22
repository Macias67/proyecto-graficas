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
import vistas.Principal;

/**
 *
 * @author Macias
 */
public class Tiempo {

    private Timer timer;
    private AccionTimer timerTask;

    public Tiempo() {
        
    }

    public void init() {
        this.timer = new Timer();
        this.timerTask = new AccionTimer();
        this.timer.schedule(timerTask, 0, 1);
    }
    
    public void setProgress(JProgressBar barra) {
        this.timerTask.setProgressBar(barra);
    }

    public void setPrincipal(Principal p) {
        timerTask.setPrincial(p);
    }

    public void detener() {
        this.timer.cancel();
        this.timer.purge();
    }

    private class AccionTimer extends TimerTask {

        private JProgressBar barra;
        private Principal princial;
        private final SimpleDateFormat sdf;
        private int CONTADOR = 0;
        private NumerosJuego numerosJuego;

        public AccionTimer() {
            sdf = new SimpleDateFormat("ss:SSS"); 
        }

        public void setProgressBar(JProgressBar barra) {
            this.barra = barra;
            this.barra.setMaximum(45);
            this.barra.setStringPainted(true);
        }

        public void setPrincial(Principal princial) {
            this.princial = princial;
        }

        @Override
        public void run() {
            if (CONTADOR < 45000) {
                CONTADOR++;
                this.barra.setValue(CONTADOR / 1000);
                this.barra.setString(sdf.format(CONTADOR));
            } else {
                cancel();
                numerosJuego = NumerosJuego.getInstance();
                JOptionPane.showMessageDialog(barra.getParent(), "Se termino el tiempo, ¡Perdedor! \n Posible resultado: "+numerosJuego.mostrarResultado(), "Perdiste", JOptionPane.INFORMATION_MESSAGE);
                princial.initButtons();
            }
        }
    }

}
