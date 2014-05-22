/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CalculaRespuesta;
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
    private String cadenaCalculo = "";
    private int SECUENCIA = 2;

    private final Tiempo tiempo;

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
        this.tiempo = new Tiempo();
    }

    public void initButtons() {
        numeroJuego.generateNumbers();
        numeroJuego.setButtonsNumber(arrayButtons);
        jLabelResultado.setText(numeroJuego.getRESULTADO() + "");
        jButtonInicio.setEnabled(true);
        reset();
        System.out.println(numeroJuego.mostrarResultado());
    }

    private void addCadenaToggle(JToggleButton button) {
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
    }

    private void addCadenaOperador(String string) {
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
            tiempo.detener();
            JOptionPane.showMessageDialog(this, "¡Increíble! Has ganado, felicidades...", "Ganador", JOptionPane.INFORMATION_MESSAGE);
            initButtons();
        }
    }

    private void reset() {
        SECUENCIA = 2;
        System.out.println(SECUENCIA);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar = new javax.swing.JProgressBar();
        btnGenerar = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
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
        jButtonReiniciar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar.setToolTipText("00:45");
        jProgressBar.setString("00:00");

        btnGenerar.setText("Generar");
        btnGenerar.setFocusable(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jButtonInicio.setText("Iniciar");
        jButtonInicio.setEnabled(false);
        jButtonInicio.setFocusable(false);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

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

        jButtonReiniciar.setText("Reiniciar");
        jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInicio)
                        .addGap(232, 232, 232))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButtonResta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCociente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGenerar, jButtonInicio});

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerar)
                            .addComponent(jButtonInicio)
                            .addComponent(jButtonReiniciar))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Números", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Letras", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButtonReiniciarActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
        tiempo.init();
        tiempo.setProgress(jProgressBar);
        tiempo.setPrincipal(this);
    }//GEN-LAST:event_jButtonInicioActionPerformed

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
    private javax.swing.JButton jButtonCociente;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonProducto;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JButton jButtonResta;
    private javax.swing.JButton jButtonSuma;
    private javax.swing.JLabel jLabelCalculo;
    private javax.swing.JLabel jLabelCuenta;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCalculo;
    private javax.swing.JPanel jPanelResultado;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    // End of variables declaration//GEN-END:variables
}
