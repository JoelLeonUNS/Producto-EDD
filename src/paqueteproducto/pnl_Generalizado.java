package paqueteproducto;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class pnl_Generalizado extends javax.swing.JPanel {

    /**
     * Variables que se pueden modificar
     */
    private int cont = 0;
    private pnl_GeneralizadoInicial gInicial = new pnl_GeneralizadoInicial();
    private pnl_GeneralizadoSiguiente gSiguiente = new pnl_GeneralizadoSiguiente();
    private pnl_GeneralizadoFinal gFinal = new pnl_GeneralizadoFinal();

    /**
     * Creates new form pnl_Generalizado
     */
    public pnl_Generalizado() {
        initComponents();
        enlazarPanel(gInicial);
        btn_Atras.setEnabled(false);
    }

    /**
     * Métodos que se pueden modificar
     */
    private void enlazarPanel(JPanel panel) {
        panel.setSize(850, 500);
        panel.setLocation(0, 0);

        pnl_GeneralizadoPrincipal.removeAll();
        pnl_GeneralizadoPrincipal.add(panel, BorderLayout.CENTER);
        pnl_GeneralizadoPrincipal.revalidate();
        pnl_GeneralizadoPrincipal.repaint();
    }

    private void actualizarComponentes() {
        actualizarP();
        actualizarC();
        actualizarTablaModeloPila();
        actualizarTablaModeloCola();
        gFinal.activarSetTablaModelo(true);
        actualizarTipOp();
        actualizarTipExp();
        actualizarcOperador();
        actualizarcExponente();
    }

    private void activarBtnSiguiente_1() {
        if (gInicial.confirmarLlenadoDeColaPila()) {
            enlazarPanel(gSiguiente);

            actualizarTamañoPilaCola();
            crearColaEOyComprobarCambioDeTamaño();
            resetearTerminoOperador();
            resetearTerminoExponente();

            btn_Siguiente.setEnabled(true);
            btn_Atras.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los datos para poder seguir, por favor.");
            cont--;
        }
    }

    private void activarBtnSiguiente_2() {
        if (gSiguiente.confirmarLlenadoDeMenu()) {
            enlazarPanel(gFinal);
            actualizarComponentes();

            btn_Siguiente.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los datos para poder seguir, por favor.");
            cont--;
        }

        // comprobación del botón transformar
        if (gInicial.getP().getTope() != -1 && gInicial.getC().getFin() != -1) {
            gFinal.getBtn_Transformar().setEnabled(true);
        }
    }

    private void crearColaEOyComprobarCambioDeTamaño() {
        // esto es para crear la cola si es que el tamaño se ha modificado
        if (gSiguiente.getcOperador() == null) {
            gSiguiente.setcOperador(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
        } else {
            if (gSiguiente.getcOperador().getFin() == -1) {
                gSiguiente.setcOperador(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
            } else {
                if (gSiguiente.getcOperador().getN() != gInicial.getTamañoPilaCola() - 1) {
                    JOptionPane.showMessageDialog(null, "El tamaño de la pila y cola se han cambiado, \npor ello los operadores que se guardaron se \nhan borrado, puesto que antes se habían \nconsiderado solo " + (gSiguiente.getcOperador().getN() + 1) + " operadores.");
                    gSiguiente.setcOperador(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
                }
            }
        }
        if (gSiguiente.getcExponente() == null) {
            gSiguiente.setcExponente(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
        } else {
            if (gSiguiente.getcExponente().getFin() == -1) {
                gSiguiente.setcExponente(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
            } else {
                if (gSiguiente.getcExponente().getN() != gInicial.getTamañoPilaCola() - 1) {
                    JOptionPane.showMessageDialog(null, "El tamaño de la pila y cola se han cambiado, \npor ello los exponentes que guardaron se \nhan borrado, puesto que antes se habían \nconsiderado solo " + (gSiguiente.getcExponente().getN() + 1) + " exponentes.");
                    gSiguiente.setcExponente(new Cola(new String[gInicial.getTamañoPilaCola()], -1, -1));
                }
            }
        }
    }

    // ---------------------------------------------
    private void actualizarTamañoPilaCola() {
        gSiguiente.setTamañoPilaCola(gInicial.getTamañoPilaCola());
        gFinal.setTamañoPilaCola(gInicial.getTamañoPilaCola());
    }

    private void actualizarP() {
        gFinal.setP(gInicial.getP());
    }

    private void actualizarC() {
        gFinal.setC(gInicial.getC());
    }

    private void actualizarTablaModeloPila() {
        gFinal.setTablaModeloPila(gInicial.getTablaModeloPila());
    }

    private void actualizarTablaModeloCola() {
        gFinal.setTablaModeloCola(gInicial.getTablaModeloCola());
    }

    private void actualizarTipOp() {
        gFinal.setTipOp(gSiguiente.getTipOp());
    }

    private void actualizarTipExp() {
        gFinal.setTipExp(gSiguiente.getTipExp());
    }

    private void actualizarcOperador() {
        gFinal.setcOperador(gSiguiente.getcOperador());
    }

    private void actualizarcExponente() {
        gFinal.setcExponente(gSiguiente.getcExponente());
    }

    private void resetearTerminoOperador() {
        if (gSiguiente.getcOperador() != null) { // primero se pregunta si ya sea creado el objeto
            if (gSiguiente.getcOperador().getFin() == -1) {
                gSiguiente.setTerminoOperador(0);

                // si está selecionado, entonces ya debe estar activado, pues el
                // el término operador ya se ha reseteado
                if (gSiguiente.getRdBtn_MO3().isSelected()) {
                    gSiguiente.getCbBx_Operador().setEnabled(true);
                    gSiguiente.getBtn_DefinirOperador().setEnabled(true);
                }
            }
        }
    }

    private void resetearTerminoExponente() {
        if (gSiguiente.getcExponente() != null) { // primero se pregunta si ya sea creado el objeto
            if (gSiguiente.getcExponente().getFin() == -1) {
                gSiguiente.setTerminoExponente(0);

                // si está selecionado, entonces ya debe estar activado, pues el
                // el término exponente ya se ha reseteado
                if (gSiguiente.getRdBtn_ME2().isSelected()) {
                    gSiguiente.getTxtFld_Exponente().setEnabled(true);
                    if (!gSiguiente.getTxtFld_Exponente().getText().equals("")) {
                        gSiguiente.getBtn_DefinirExponente().setEnabled(true);
                    }
                }
            }
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

        pnl_AtrasSiguiente = new javax.swing.JPanel();
        btn_Siguiente = new javax.swing.JButton();
        btn_Atras = new javax.swing.JButton();
        pnl_GeneralizadoPrincipal = new javax.swing.JPanel();

        setBackground(new java.awt.Color(245, 245, 245));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_AtrasSiguiente.setBackground(new java.awt.Color(245, 245, 245));

        btn_Siguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Siguiente.setText("SIGUIENTE");
        btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiguienteActionPerformed(evt);
            }
        });

        btn_Atras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Atras.setText("ATRÁS");
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_AtrasSiguienteLayout = new javax.swing.GroupLayout(pnl_AtrasSiguiente);
        pnl_AtrasSiguiente.setLayout(pnl_AtrasSiguienteLayout);
        pnl_AtrasSiguienteLayout.setHorizontalGroup(
            pnl_AtrasSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AtrasSiguienteLayout.createSequentialGroup()
                .addContainerGap(612, Short.MAX_VALUE)
                .addComponent(btn_Atras)
                .addGap(18, 18, 18)
                .addComponent(btn_Siguiente)
                .addGap(50, 50, 50))
        );
        pnl_AtrasSiguienteLayout.setVerticalGroup(
            pnl_AtrasSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AtrasSiguienteLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(pnl_AtrasSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        add(pnl_AtrasSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 850, -1));

        pnl_GeneralizadoPrincipal.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout pnl_GeneralizadoPrincipalLayout = new javax.swing.GroupLayout(pnl_GeneralizadoPrincipal);
        pnl_GeneralizadoPrincipal.setLayout(pnl_GeneralizadoPrincipalLayout);
        pnl_GeneralizadoPrincipalLayout.setHorizontalGroup(
            pnl_GeneralizadoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        pnl_GeneralizadoPrincipalLayout.setVerticalGroup(
            pnl_GeneralizadoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        add(pnl_GeneralizadoPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiguienteActionPerformed
        cont++;
        switch (cont) {
            case 0 -> {
                btn_Atras.setEnabled(false);
                btn_Siguiente.setEnabled(true);
                enlazarPanel(gInicial);
            }
            case 1 -> {
                activarBtnSiguiente_1();
            }
            case 2 -> {
                activarBtnSiguiente_2();
            }
        }
    }//GEN-LAST:event_btn_SiguienteActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        cont--;
        switch (cont) {
            case 0 -> {
                btn_Atras.setEnabled(false);
                btn_Siguiente.setEnabled(true);
                enlazarPanel(gInicial);
                // se actualiza
                gInicial.editarIndicadorPila();
                gInicial.editarIndicadorCola();
            }
            case 1 -> {
                btn_Siguiente.setEnabled(true);
                btn_Atras.setEnabled(true);
                enlazarPanel(gSiguiente);
                // se actualiza
                resetearTerminoOperador();
                resetearTerminoExponente();

            }
            case 2 -> {
                enlazarPanel(gFinal);
                btn_Siguiente.setEnabled(false);

            }
        }
    }//GEN-LAST:event_btn_AtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_Siguiente;
    private javax.swing.JPanel pnl_AtrasSiguiente;
    private javax.swing.JPanel pnl_GeneralizadoPrincipal;
    // End of variables declaration//GEN-END:variables
}
