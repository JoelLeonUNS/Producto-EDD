package paqueteproducto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class pnl_GeneralizadoSiguiente extends javax.swing.JPanel {

    /**
     * Variables que se pueden modificar
     */
    private int tipOp, tipExp;
    private int terminoOperador, terminoExponente;
    private int tamañoPilaCola;
    private Cola cOperador, cExponente;
    private DefaultComboBoxModel<String> listaModeloOperadores = new DefaultComboBoxModel<String>();

    /**
     * Creates new form pnl_GeneralizadoSiguiente
     */
    public pnl_GeneralizadoSiguiente() {
        initComponents();
        agruparRadioBotones();

        listaModeloOperadores.addElement("+");
        listaModeloOperadores.addElement("-");
        cbBx_Operador.setEnabled(false);
        btn_DefinirOperador.setEnabled(false);
        txtFld_Exponente.setEnabled(false);
        btn_DefinirExponente.setEnabled(false);
    }

    /**
     * Métodos que se pueden modificar
     */
    private void agruparRadioBotones() {
        btnGrp_MO.add(rdBtn_MO1);
        btnGrp_MO.add(rdBtn_MO2);
        btnGrp_MO.add(rdBtn_MO3);

        btnGrp_ME.add(rdBtn_ME1);
        btnGrp_ME.add(rdBtn_ME2);
    }

    private boolean identificarExponente(String dato) {
        boolean estado = true;
        int inicio;
        inicio = ((dato.charAt(0) == '-' && dato.length() != 1) ? 1 : 0);
        for (int i = inicio; i < dato.length(); i++) {
            if (!(dato.charAt(i) >= '0' && dato.charAt(i) <= '9')) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números como exponente.");
                estado = false;
                break;
            } else if (dato.length() == 1 && dato.charAt(0) == '0') {
                JOptionPane.showMessageDialog(null, "Defina un exponente diferente a cero.");
                estado = false;
            }
        }
        return estado;
    }

    public boolean confirmarLlenadoDeMenu() {
        boolean llenado = false;
        if ((rdBtn_MO1.isSelected() || rdBtn_MO2.isSelected() || rdBtn_MO3.isSelected()) && (rdBtn_ME1.isSelected() || rdBtn_ME2.isSelected())) {
            if (rdBtn_MO3.isSelected() && rdBtn_ME2.isSelected()) {
                llenado = confirmarLlenadoDeOperador() && confirmarLlenadoDeExponente();
            }
            if (rdBtn_MO3.isSelected() && !rdBtn_ME2.isSelected()) {
                llenado = confirmarLlenadoDeOperador();
            }
            if (!rdBtn_MO3.isSelected() && rdBtn_ME2.isSelected()) {
                llenado = confirmarLlenadoDeExponente();
            }
            if (!rdBtn_MO3.isSelected() && !rdBtn_ME2.isSelected()) {
                llenado = true;
            }
        }
        return llenado;
    }

    public boolean confirmarLlenadoDeOperador() {
        boolean llenado = false;
        if (cOperador != null) { // primero se pregunta si ya sea creado el objeto
            if (cOperador.getFin() == cOperador.getN()) {
                llenado = true;
            }
        }
        return llenado;
    }

    public boolean confirmarLlenadoDeExponente() {
        boolean llenado = false;
        if (cExponente != null) { // primero se pregunta si ya sea creado el objeto
            if (cExponente.getFin() == cExponente.getN()) {
                llenado = true;
            }
        }
        return llenado;
    }

    // --- Getters ----------------------------------------
    public int getTipOp() {
        return tipOp;
    }

    public int getTipExp() {
        return tipExp;
    }

    public Cola getcOperador() {
        return cOperador;
    }

    public Cola getcExponente() {
        return cExponente;
    }

    //
    public JRadioButton getRdBtn_ME2() {
        return rdBtn_ME2;
    }

    public JRadioButton getRdBtn_MO3() {
        return rdBtn_MO3;
    }

    public JButton getBtn_DefinirOperador() {
        return btn_DefinirOperador;
    }

    public JComboBox<String> getCbBx_Operador() {
        return cbBx_Operador;
    }

    public JLabel getLbl_TerminoExponente() {
        return lbl_TerminoExponente;
    }

    public JLabel getLbl_TerminoOperador() {
        return lbl_TerminoOperador;
    }

    public JTextField getTxtFld_Exponente() {
        return txtFld_Exponente;
    }

    public JButton getBtn_DefinirExponente() {
        return btn_DefinirExponente;
    }

    // --- Setters ----------------------------------------
    public void setTerminoExponente(int terminoExponente) {
        this.terminoExponente = terminoExponente;
    }

    public void setTerminoOperador(int terminoOperador) {
        this.terminoOperador = terminoOperador;
    }

    public void setTamañoPilaCola(int tamañoPilaCola) {
        this.tamañoPilaCola = tamañoPilaCola;
    }

    public void setcOperador(Cola cOperador) {
        this.cOperador = cOperador;
    }

    public void setcExponente(Cola cExponente) {
        this.cExponente = cExponente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp_MO = new javax.swing.ButtonGroup();
        btnGrp_ME = new javax.swing.ButtonGroup();
        lbl_MenuOperadores = new javax.swing.JLabel();
        lbl_MenuExponentes = new javax.swing.JLabel();
        rdBtn_MO1 = new javax.swing.JRadioButton();
        rdBtn_MO2 = new javax.swing.JRadioButton();
        rdBtn_MO3 = new javax.swing.JRadioButton();
        rdBtn_ME1 = new javax.swing.JRadioButton();
        rdBtn_ME2 = new javax.swing.JRadioButton();
        lbl_Operador = new javax.swing.JLabel();
        btn_DefinirOperador = new javax.swing.JButton();
        lbl_Exponente = new javax.swing.JLabel();
        txtFld_Exponente = new javax.swing.JTextField();
        btn_DefinirExponente = new javax.swing.JButton();
        cbBx_Operador = new javax.swing.JComboBox<>();
        lbl_TerminoOperador = new javax.swing.JLabel();
        txtArea_IndicacionExponente = new javax.swing.JTextArea();
        lbl_TerminoExponente = new javax.swing.JLabel();
        txtArea_IndicacionOperador = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(245, 245, 245));

        lbl_MenuOperadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_MenuOperadores.setForeground(new java.awt.Color(70, 70, 70));
        lbl_MenuOperadores.setText("Menú: Operadores");

        lbl_MenuExponentes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_MenuExponentes.setForeground(new java.awt.Color(70, 70, 70));
        lbl_MenuExponentes.setText("Menú: Exponentes");

        rdBtn_MO1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtn_MO1.setForeground(new java.awt.Color(80, 80, 80));
        rdBtn_MO1.setText("Operadores con patrón: + - + - + ...");
        rdBtn_MO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtn_MO1ActionPerformed(evt);
            }
        });

        rdBtn_MO2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtn_MO2.setForeground(new java.awt.Color(80, 80, 80));
        rdBtn_MO2.setText("Operadores aleatorios.");
        rdBtn_MO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtn_MO2ActionPerformed(evt);
            }
        });

        rdBtn_MO3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtn_MO3.setForeground(new java.awt.Color(80, 80, 80));
        rdBtn_MO3.setText("Seleccionar los operadores desde la lista.");
        rdBtn_MO3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtn_MO3ActionPerformed(evt);
            }
        });

        rdBtn_ME1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtn_ME1.setForeground(new java.awt.Color(80, 80, 80));
        rdBtn_ME1.setText("Exponentes descendentes con excepción al último.");
        rdBtn_ME1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtn_ME1ActionPerformed(evt);
            }
        });

        rdBtn_ME2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtn_ME2.setForeground(new java.awt.Color(80, 80, 80));
        rdBtn_ME2.setText("Introducir por teclado los exponentes.");
        rdBtn_ME2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtn_ME2ActionPerformed(evt);
            }
        });

        lbl_Operador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Operador.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Operador.setText("Operador");

        btn_DefinirOperador.setForeground(new java.awt.Color(70, 70, 70));
        btn_DefinirOperador.setText("DEFINIR");
        btn_DefinirOperador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DefinirOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DefinirOperadorActionPerformed(evt);
            }
        });

        lbl_Exponente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Exponente.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Exponente.setText("Exponente");

        txtFld_Exponente.setColumns(10);
        txtFld_Exponente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_Exponente.setForeground(new java.awt.Color(70, 70, 70));
        txtFld_Exponente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFld_ExponenteFocusLost(evt);
            }
        });
        txtFld_Exponente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFld_ExponenteKeyReleased(evt);
            }
        });

        btn_DefinirExponente.setForeground(new java.awt.Color(70, 70, 70));
        btn_DefinirExponente.setText("DEFINIR");
        btn_DefinirExponente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DefinirExponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DefinirExponenteActionPerformed(evt);
            }
        });

        cbBx_Operador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbBx_Operador.setForeground(new java.awt.Color(70, 70, 70));
        cbBx_Operador.setModel(listaModeloOperadores);

        lbl_TerminoOperador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TerminoOperador.setForeground(new java.awt.Color(80, 80, 80));
        lbl_TerminoOperador.setText("Término n°?");

        txtArea_IndicacionExponente.setEditable(false);
        txtArea_IndicacionExponente.setBackground(new java.awt.Color(255, 255, 255));
        txtArea_IndicacionExponente.setColumns(20);
        txtArea_IndicacionExponente.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtArea_IndicacionExponente.setForeground(new java.awt.Color(100, 100, 100));
        txtArea_IndicacionExponente.setLineWrap(true);
        txtArea_IndicacionExponente.setRows(5);
        txtArea_IndicacionExponente.setText("Ingrese un exponente para cada varible del polinomio.");
        txtArea_IndicacionExponente.setWrapStyleWord(true);
        txtArea_IndicacionExponente.setAutoscrolls(false);
        txtArea_IndicacionExponente.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtArea_IndicacionExponente.setFocusable(false);
        txtArea_IndicacionExponente.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtArea_IndicacionExponente.setMinimumSize(new java.awt.Dimension(750, 110));

        lbl_TerminoExponente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TerminoExponente.setForeground(new java.awt.Color(80, 80, 80));
        lbl_TerminoExponente.setText("Término n°?");

        txtArea_IndicacionOperador.setEditable(false);
        txtArea_IndicacionOperador.setBackground(new java.awt.Color(255, 255, 255));
        txtArea_IndicacionOperador.setColumns(20);
        txtArea_IndicacionOperador.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtArea_IndicacionOperador.setForeground(new java.awt.Color(100, 100, 100));
        txtArea_IndicacionOperador.setLineWrap(true);
        txtArea_IndicacionOperador.setRows(5);
        txtArea_IndicacionOperador.setText("Seleccione el tipo de operador para cada término del polinomio.");
        txtArea_IndicacionOperador.setWrapStyleWord(true);
        txtArea_IndicacionOperador.setAutoscrolls(false);
        txtArea_IndicacionOperador.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtArea_IndicacionOperador.setFocusable(false);
        txtArea_IndicacionOperador.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtArea_IndicacionOperador.setMinimumSize(new java.awt.Dimension(750, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdBtn_MO1)
                            .addComponent(lbl_MenuOperadores)
                            .addComponent(rdBtn_ME2)
                            .addComponent(rdBtn_ME1)
                            .addComponent(lbl_MenuExponentes)
                            .addComponent(rdBtn_MO3)
                            .addComponent(rdBtn_MO2))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_Exponente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Operador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbBx_Operador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DefinirOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_TerminoOperador)
                            .addComponent(lbl_TerminoExponente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFld_Exponente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DefinirExponente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtArea_IndicacionOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtArea_IndicacionExponente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_MenuOperadores)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtn_MO1)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtn_MO2)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtn_MO3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Operador)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_TerminoOperador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cbBx_Operador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_DefinirOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArea_IndicacionOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_MenuExponentes)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtn_ME1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdBtn_ME2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Exponente)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_TerminoExponente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtFld_Exponente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_DefinirExponente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArea_IndicacionExponente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdBtn_MO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtn_MO1ActionPerformed
        // verifica el estado actual de las opciones seleccionadas
        confirmarLlenadoDeMenu();

        tipOp = 1;
        cbBx_Operador.setEnabled(false);
        btn_DefinirOperador.setEnabled(false);
    }//GEN-LAST:event_rdBtn_MO1ActionPerformed

    private void rdBtn_MO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtn_MO2ActionPerformed
        // verifica el estado actual de las opciones seleccionadas
        confirmarLlenadoDeMenu();

        tipOp = 2;
        cbBx_Operador.setEnabled(false);
        btn_DefinirOperador.setEnabled(false);
    }//GEN-LAST:event_rdBtn_MO2ActionPerformed

    private void rdBtn_MO3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtn_MO3ActionPerformed
        // verifica el estado actual de las opciones seleccionadas
        confirmarLlenadoDeMenu();

        tipOp = 3;
        if (terminoOperador <= tamañoPilaCola) {
            cbBx_Operador.setEnabled(true);
            btn_DefinirOperador.setEnabled(true);
        }

        if (terminoOperador < 1) {
            terminoOperador++;
            lbl_TerminoOperador.setText("Término n°" + terminoOperador);
        }
    }//GEN-LAST:event_rdBtn_MO3ActionPerformed

    private void rdBtn_ME1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtn_ME1ActionPerformed
        // verifica el estado actual de las opciones seleccionadas
        confirmarLlenadoDeMenu();

        tipExp = 1;
        txtFld_Exponente.setEnabled(false);
        btn_DefinirExponente.setEnabled(false);
    }//GEN-LAST:event_rdBtn_ME1ActionPerformed

    private void rdBtn_ME2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtn_ME2ActionPerformed
        // verifica el estado actual de las opciones seleccionadas
        confirmarLlenadoDeMenu();

        tipExp = 2;

        if (terminoExponente <= tamañoPilaCola) {
            txtFld_Exponente.setEnabled(true);
        }

        if (terminoExponente < 1) {
            terminoExponente++;
            lbl_TerminoExponente.setText("Término n°" + terminoExponente);
        }

    }//GEN-LAST:event_rdBtn_ME2ActionPerformed

    private void btn_DefinirOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DefinirOperadorActionPerformed
        if (terminoOperador < tamañoPilaCola) {
            terminoOperador++;
            lbl_TerminoOperador.setText("Término n°" + terminoOperador);
        }
        cOperador.insertar((String) listaModeloOperadores.getSelectedItem());
        if (cOperador.getFin() == tamañoPilaCola - 1) {
            btn_DefinirOperador.setEnabled(false);
            cbBx_Operador.setEnabled(false);
            terminoOperador++;

            // verifica el estado actual de la cola de Operadores y Menú
            confirmarLlenadoDeMenu();
        }

        // prueba en consola
        for (int i = 0; i <= cOperador.getFin(); i++) {
            System.out.print(cOperador.getArray()[i] + " ");
        }
        System.out.println("");
    }//GEN-LAST:event_btn_DefinirOperadorActionPerformed

    private void btn_DefinirExponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DefinirExponenteActionPerformed
        if (identificarExponente(txtFld_Exponente.getText())) {
            if (terminoExponente < tamañoPilaCola) {
                terminoExponente++;
                lbl_TerminoExponente.setText("Término n°" + terminoExponente);
            }
            cExponente.insertar(txtFld_Exponente.getText());
            if (cExponente.getFin() == tamañoPilaCola - 1) {
                btn_DefinirExponente.setEnabled(false);
                txtFld_Exponente.setEnabled(false);
                terminoExponente++;

                // verifica el estado actual de la cola de Exponentes y Menú
                confirmarLlenadoDeMenu();
            }
        }

        // prueba en consola
        for (int i = 0; i <= cExponente.getFin(); i++) {
            System.out.print(cExponente.getArray()[i] + " ");
        }
        System.out.println("");
    }//GEN-LAST:event_btn_DefinirExponenteActionPerformed

    private void txtFld_ExponenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFld_ExponenteKeyReleased
        if (!txtFld_Exponente.getText().equals("")) {
            btn_DefinirExponente.setEnabled(true);
        }
    }//GEN-LAST:event_txtFld_ExponenteKeyReleased

    private void txtFld_ExponenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFld_ExponenteFocusLost
        if (txtFld_Exponente.getText().equals("")) {
            btn_DefinirExponente.setEnabled(false);
        }
    }//GEN-LAST:event_txtFld_ExponenteFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrp_ME;
    private javax.swing.ButtonGroup btnGrp_MO;
    private javax.swing.JButton btn_DefinirExponente;
    private javax.swing.JButton btn_DefinirOperador;
    private javax.swing.JComboBox<String> cbBx_Operador;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Exponente;
    private javax.swing.JLabel lbl_MenuExponentes;
    private javax.swing.JLabel lbl_MenuOperadores;
    private javax.swing.JLabel lbl_Operador;
    private javax.swing.JLabel lbl_TerminoExponente;
    private javax.swing.JLabel lbl_TerminoOperador;
    private javax.swing.JRadioButton rdBtn_ME1;
    private javax.swing.JRadioButton rdBtn_ME2;
    private javax.swing.JRadioButton rdBtn_MO1;
    private javax.swing.JRadioButton rdBtn_MO2;
    private javax.swing.JRadioButton rdBtn_MO3;
    private javax.swing.JTextArea txtArea_IndicacionExponente;
    private javax.swing.JTextArea txtArea_IndicacionOperador;
    private javax.swing.JTextField txtFld_Exponente;
    // End of variables declaration//GEN-END:variables
}
