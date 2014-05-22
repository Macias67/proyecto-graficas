/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CalculaRespuesta;
import controlador.GeneraPalabra;
import controlador.NumerosJuego;
import controlador.Tiempo;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import modelo.OperadoresString;

/**
 *
 * @author Macias
 */
public class Principal extends javax.swing.JFrame {

    private final NumerosJuego numeroJuego;
    private final JToggleButton[] arrayButtons;
    private final CalculaRespuesta calculaRespuesta;
    private Tiempo tiempo;
    private String cadenaCalculo = "";
    private int SECUENCIA = 2;

    private boolean INICIO = false;
    
    private GeneraPalabra generaPalabra;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.arrayButtons = new JToggleButton[]{
            jToggleButton1,
            jToggleButton2,
            jToggleButton3,
            jToggleButton4,
            jToggleButton5,
            jToggleButton6,
            jToggleButton7
        };
        this.numeroJuego = NumerosJuego.getInstance();
        this.calculaRespuesta = new CalculaRespuesta();
    }

    public void initButtons() {
        numeroJuego.generateNumbers();
        numeroJuego.setButtonsNumber(arrayButtons);
        jLabelResultado.setText(numeroJuego.getRESULTADO() + "");
        reset();
        btnGenerar.setEnabled(true);
        btnIniciar.setEnabled(false);
        btnReiniciar.setEnabled(false);
        jTabbedPane.setEnabled(true);
        INICIO = false;
        System.out.println(numeroJuego.mostrarResultado());
    }

    private void addCadenaToggle(JToggleButton button) {
        if (INICIO) {
            if (maxCaracteres()) {
                if (ordenSecuencia()) {
                    if (button.isSelected()) {
                        String string = button.getText();
                        if (!string.isEmpty()) {
                            if (cadenaCalculo.isEmpty()) {
                                cadenaCalculo = string;
                            } else {
                                cadenaCalculo += " " + string;
                            }
                            refreshCalculo();
                            SECUENCIA++;
                        } else {
                            button.setSelected(false);
                            JOptionPane.showMessageDialog(this, "No se han iniciado valores", "No hay valores", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        button.setSelected(!button.isSelected());
                        JOptionPane.showMessageDialog(this, "Ya seleccionaste este botton", "Seleciona otra opción", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    button.setSelected(!button.isSelected());
                    JOptionPane.showMessageDialog(this, "Tienes que colocar un operador", "Falta operador", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                button.setSelected(true);
                JOptionPane.showMessageDialog(this, "Haz llegado al tope de números", "Máximo de números", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            button.setSelected(false);
            JOptionPane.showMessageDialog(this, "Inicia el juego", "Inicia", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCadenaOperador(String string) {
        if (INICIO) {
            if (maxCaracteres()) {
                if (!ordenSecuencia()) {
                    if (!string.isEmpty()) {
                        if (cadenaCalculo.isEmpty()) {
                            cadenaCalculo = string;
                        } else {
                            cadenaCalculo += " " + string;
                        }
                        jLabelCalculo.setText(cadenaCalculo);
                        SECUENCIA++;
                    } else {
                        JOptionPane.showMessageDialog(this, "No se han iniciado valores", "No hay valores", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Tienes que colocar un número", "Falta número", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Haz llegado al tope de números", "Máximo de números", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Iniciar el juego", "Inicia", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean ordenSecuencia() {
        return (SECUENCIA % 2 == 0);
    }

    private boolean maxCaracteres() {
        return (SECUENCIA < 15);
    }

    private void refreshCalculo() {
        jLabelCalculo.setText(cadenaCalculo);
        jLabelCuenta.setText(calculaRespuesta.resultado(cadenaCalculo) + "");
        if (calculaRespuesta.encuentraRespuesta()) {
            jLabelEstado.setText("=");
            jLabelCuenta.setForeground(Color.GREEN);
            jLabelEstado.setForeground(Color.GREEN);
            jLabelResultado.setForeground(Color.GREEN);
            this.tiempo.stop();
            JOptionPane.showMessageDialog(this, "¡Increíble! Has ganado, felicidades :D", "Ganador", JOptionPane.INFORMATION_MESSAGE);
            initButtons();
        }
    }

    private void reset() {
        SECUENCIA = 2;
        cadenaCalculo = "";

        jProgressBar.setValue(0);
        jProgressBar.setString("00:00");

        jLabelCalculo.setText("");

        jLabelCuenta.setText("0");
        jLabelEstado.setText("!=");

        jLabelCuenta.setForeground(Color.RED);
        jLabelEstado.setForeground(Color.RED);
        jLabelResultado.setForeground(Color.RED);
        for (JToggleButton button : arrayButtons) {
            button.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar = new javax.swing.JProgressBar();
        jButtonSuma = new javax.swing.JButton();
        jButtonResta = new javax.swing.JButton();
        jButtonProducto = new javax.swing.JButton();
        jButtonCociente = new javax.swing.JButton();
        jPanelCalculo = new javax.swing.JPanel();
        jLabelCalculo = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jPanelResultado = new javax.swing.JPanel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelResultado = new javax.swing.JLabel();
        jLabelCuenta = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnReiniciar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanelCalculo2 = new javax.swing.JPanel();
        jLabelCalculo2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabelStatusPalabra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnGenerarLetras = new javax.swing.JButton();
        btnReiniciarLetras = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnIniciarLetras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jProgressBar.setToolTipText("00:45");
        jProgressBar.setString("00:00");

        jButtonSuma.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonSuma.setText("+");
        jButtonSuma.setFocusable(false);
        jButtonSuma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSumaActionPerformed(evt);
            }
        });

        jButtonResta.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonResta.setText("-");
        jButtonResta.setFocusable(false);
        jButtonResta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRestaActionPerformed(evt);
            }
        });

        jButtonProducto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonProducto.setText("x");
        jButtonProducto.setFocusable(false);
        jButtonProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductoActionPerformed(evt);
            }
        });

        jButtonCociente.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonCociente.setText("/");
        jButtonCociente.setFocusable(false);
        jButtonCociente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCociente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCocienteActionPerformed(evt);
            }
        });

        jPanelCalculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCalculo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabelCalculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCalculo.setText("¡Bienvenido!");

        javax.swing.GroupLayout jPanelCalculoLayout = new javax.swing.GroupLayout(jPanelCalculo);
        jPanelCalculo.setLayout(jPanelCalculoLayout);
        jPanelCalculoLayout.setHorizontalGroup(
            jPanelCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCalculoLayout.setVerticalGroup(
            jPanelCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton1.setFocusable(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton2.setFocusable(false);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton3.setFocusable(false);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton4.setFocusable(false);
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton5.setFocusable(false);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton6.setFocusable(false);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jToggleButton7.setFocusable(false);
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jPanelResultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelEstado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(204, 0, 0));
        jLabelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEstado.setText("!=");

        jLabelResultado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelResultado.setForeground(new java.awt.Color(204, 0, 0));
        jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelResultado.setText("0");

        jLabelCuenta.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelCuenta.setForeground(new java.awt.Color(204, 0, 0));
        jLabelCuenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCuenta.setText("0");

        javax.swing.GroupLayout jPanelResultadoLayout = new javax.swing.GroupLayout(jPanelResultado);
        jPanelResultado.setLayout(jPanelResultadoLayout);
        jPanelResultadoLayout.setHorizontalGroup(
            jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelResultadoLayout.setVerticalGroup(
            jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadoLayout.createSequentialGroup()
                .addGroup(jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstado)
                    .addComponent(jLabelCuenta))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnReiniciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setEnabled(false);
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciar.setText("INICIAR");
        btnIniciar.setEnabled(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCalculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSuma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonResta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCociente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(232, 232, 232)
                        .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuma)
                    .addComponent(jButtonResta)
                    .addComponent(jButtonProducto)
                    .addComponent(jButtonCociente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReiniciar)
                    .addComponent(btnGenerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Números", jPanel1);

        jProgressBar2.setToolTipText("00:45");
        jProgressBar2.setString("00:00");

        jPanelCalculo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCalculo2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabelCalculo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCalculo2.setText("¡Bienvenido!");

        javax.swing.GroupLayout jPanelCalculo2Layout = new javax.swing.GroupLayout(jPanelCalculo2);
        jPanelCalculo2.setLayout(jPanelCalculo2Layout);
        jPanelCalculo2Layout.setHorizontalGroup(
            jPanelCalculo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCalculo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCalculo2Layout.setVerticalGroup(
            jPanelCalculo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalculo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCalculo2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("B");
        jButton1.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("A");
        jButton2.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("C");
        jButton3.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("D");
        jButton4.setToolTipText("");
        jButton4.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("E");
        jButton5.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setText("F");
        jButton6.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setText("G");
        jButton7.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.setText("H");
        jButton8.setPreferredSize(new java.awt.Dimension(50, 23));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton9.setText("I");
        jButton9.setPreferredSize(new java.awt.Dimension(50, 23));

        jLabelStatusPalabra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelStatusPalabra.setForeground(new java.awt.Color(204, 0, 0));
        jLabelStatusPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnGenerarLetras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerarLetras.setText("Generar");
        btnGenerarLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarLetrasActionPerformed(evt);
            }
        });

        btnReiniciarLetras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReiniciarLetras.setText("Reiniciar");

        btnIniciarLetras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciarLetras.setText("INICIAR");
        btnIniciarLetras.setEnabled(false);

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jPanelCalculo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelStatusPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGenerarLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReiniciarLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIniciarLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCalculo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelStatusPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerarLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReiniciarLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane.addTab("Letras", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton1);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton2);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton3);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton4);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton5);
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton6);
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        addCadenaToggle(jToggleButton7);
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jButtonSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSumaActionPerformed
        // TODO add your handling code here:
        addCadenaOperador(OperadoresString.SUMA.getValue());
    }//GEN-LAST:event_jButtonSumaActionPerformed

    private void jButtonRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRestaActionPerformed
        // TODO add your handling code here:
        addCadenaOperador(OperadoresString.RESTA.getValue());
    }//GEN-LAST:event_jButtonRestaActionPerformed

    private void jButtonProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductoActionPerformed
        // TODO add your handling code here:
        addCadenaOperador(OperadoresString.PRODUCTO.getValue());
    }//GEN-LAST:event_jButtonProductoActionPerformed

    private void jButtonCocienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCocienteActionPerformed
        // TODO add your handling code here:
        addCadenaOperador(OperadoresString.COCIENTE.getValue());
    }//GEN-LAST:event_jButtonCocienteActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        initButtons();
        btnIniciar.setEnabled(true);
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        INICIO = true;
        btnReiniciar.setEnabled(true);
        btnGenerar.setEnabled(false);
        btnIniciar.setEnabled(false);
        jTabbedPane.setEnabled(false);
        this.tiempo = new Tiempo();
        this.tiempo.setElements(jProgressBar, this);
        this.tiempo.start();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnGenerarLetrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarLetrasActionPerformed
        // TODO add your handling code here:
        generaPalabra = new GeneraPalabra();
        generaPalabra.iniciar(jLabelStatusPalabra);
    }//GEN-LAST:event_btnGenerarLetrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal principal = new Principal();
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGenerarLetras;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnIniciarLetras;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnReiniciarLetras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonCociente;
    private javax.swing.JButton jButtonProducto;
    private javax.swing.JButton jButtonResta;
    private javax.swing.JButton jButtonSuma;
    private javax.swing.JLabel jLabelCalculo;
    private javax.swing.JLabel jLabelCalculo1;
    private javax.swing.JLabel jLabelCalculo2;
    private javax.swing.JLabel jLabelCuenta;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JLabel jLabelStatusPalabra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCalculo;
    private javax.swing.JPanel jPanelCalculo1;
    private javax.swing.JPanel jPanelCalculo2;
    private javax.swing.JPanel jPanelResultado;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    // End of variables declaration//GEN-END:variables
}
