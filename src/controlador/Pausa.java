/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;

/**
 *
 * @author Macias
 */
public class Pausa implements Runnable {

    private boolean paused = false;
    private boolean stopped = false;

    public void play() {
        paused = false;
        stopped = false;
        new Thread(this, "Player").start();
    }

    public synchronized void pause() {
        paused = true;
    }

    public synchronized void resume() {
        paused = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
// If it was paused then resume and then stop
        notify();
    }

    Pausa() {
    }

    @Override
    public void run() {
        Date t0 = new Date();
        while (!stopped) {
            try {
                synchronized (this) {
                    if (paused) {
                        System.out.println("Paused");
                        wait();
                        System.out.println("Resumed");
                    }
                }
                long secs = ((new Date()).getTime() - t0.getTime()) / 1000;
                System.out.println(secs);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Pausa p = new Pausa();
        p.play();
        Thread.sleep(5000);
        p.pause();
        Thread.sleep(5000);
        p.resume();
        Thread.sleep(5000);

    }

}
