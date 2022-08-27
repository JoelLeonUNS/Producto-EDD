package paqueteproducto;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class pnl_GeneralizadoFinal extends javax.swing.JPanel {

    /**
     * Variables que se pueden modificar
     */
    private final int anchoTabla = 500;
    private int itr;
    private int tipOp, tipExp;
    private int tamañoPilaCola;
    private Pila p;
    private Cola c;
    private Cola cOperador, cExponente;
    private DefaultTableModel tablaModeloPila;
    private DefaultTableModel tablaModeloCola;

    /**
     * Creates new form pnl_GeneralizadoFinal
     */
    public pnl_GeneralizadoFinal() {
        initComponents();
    }

    /**
     * Métodos que se pueden modificar
     */
    private void editarIndicadorPila() {
        lbl_Fondo.setText("Fondo: " + p.getFondo());
        lbl_Tope.setText("Tope: " + p.getTope());
    }

    private void editarIndicadorCola() {
        lbl_Frente.setText("Frente: " + c.getFrente());
        lbl_Final.setText("Final: " + c.getFin());
    }

    private void editarTablaPilaCola() {
        for (int i = 0; i < tamañoPilaCola; i++) {
            tablaModeloPila.setValueAt(p.getArray()[i], 0, i + 1);
        }
        for (int i = 0; i < tamañoPilaCola; i++) {
            tablaModeloCola.setValueAt(c.getArray()[i], 0, i + 1);
        }
    }

    public void activarSetTablaModelo(boolean estado) {
        if (estado) {
            tbl_Pila.setModel(tablaModeloPila);
            centrarColumna(tbl_Pila);
            definirAnchoDeColumnas(tbl_Pila);
            
            tbl_Cola.setModel(tablaModeloCola);
            centrarColumna(tbl_Cola);
            definirAnchoDeColumnas(tbl_Cola);
            
            // también 
            editarIndicadorPila();
            editarIndicadorCola();
        }
    }
    
    private void centrarColumna(JTable tbl) {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        // centrar cabecera
        ((DefaultTableCellRenderer) tbl.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        // centrar los datos
        for (int i = 0; i <= tamañoPilaCola; i++) {
            tbl.getColumnModel().getColumn(i).setCellRenderer(cellRender);
        }
    }
    
    private void definirAnchoDeColumnas(JTable tbl) {
        int anchoJusto = anchoTabla / (tamañoPilaCola + 1);
        if (anchoJusto < 60) {
            tbl.setAutoResizeMode(0);
            for (int i = 0; i <= tamañoPilaCola; i++) {
                tbl.getColumnModel().getColumn(i).setPreferredWidth(60);
            }
        } else {
            tbl.setAutoResizeMode(2);
        }

    }
    
    //
    private String transformacion(int tipOp, int tipExp) {
        String notInf = "";
        String x, exponente, operador; // para almacenar el valor que retorna la cola al hacer la supresión

        switch (tipExp) {
            case 1 -> { // 15*x
                for (int i = 0; i < tamañoPilaCola; i++) {
                    operador = operador(tipOp);
                    notInf += ((i != 0 || !operador.equals("+")) ? operador : "");
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop(); // se hace pop y se disminuye en 1 el tope
                    notInf += ((p.getTope() > 0) ? "^" + (p.getTope() + 1) : ""); // por eso se suma 1 al tope
                }
            }
            case 2 -> {
                for (int i = 0; i < tamañoPilaCola; i++) {
                    operador = operador(tipOp);
                    notInf += ((i != 0 || !operador.equals("+")) ? operador : "");
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop();
                    exponente = cExponente.suprimir();
                    notInf += (!exponente.equals("1") ? "^" + exponente : "");
                }
            }
        }
        return notInf;
    }

    private String operador(int tipOp) {
        String operador = "";

        switch (tipOp) {
            case 1 -> {
                operador = (itr % 2 == 0) ? "+" : "-";
                itr++;
            }
            case 2 -> {
                operador = (Math.round((Math.random() + 1)) == 1) ? "-" : "+";
            }
            case 3 -> {
                operador = cOperador.suprimir();
            }
        }
        return operador;
    }

    // ---------------------------------------------

    public JButton getBtn_Transformar() {
        return btn_Transformar;
    }
    
    
    // ---------------------------------------------
    public void setTipOp(int tipOp) {
        this.tipOp = tipOp;
    }

    public void setTipExp(int tipExp) {
        this.tipExp = tipExp;
    }

    public void setTamañoPilaCola(int tamañoPilaCola) {
        this.tamañoPilaCola = tamañoPilaCola;
    }

    public void setP(Pila p) {
        this.p = p;
    }

    public void setC(Cola c) {
        this.c = c;
    }

    public void setcOperador(Cola cOperador) {
        this.cOperador = cOperador;
    }

    public void setcExponente(Cola cExponente) {
        this.cExponente = cExponente;
    }

    public void setTablaModeloPila(DefaultTableModel tablaModeloPila) {
        this.tablaModeloPila = tablaModeloPila;
    }

    public void setTablaModeloCola(DefaultTableModel tablaModeloCola) {
        this.tablaModeloCola = tablaModeloCola;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        scrll_TablaPila = new javax.swing.JScrollPane();
        tbl_Pila = new javax.swing.JTable();
        scrll_TablaCola = new javax.swing.JScrollPane();
        tbl_Cola = new javax.swing.JTable();
        lbl_Fondo = new javax.swing.JLabel();
        lbl_Tope = new javax.swing.JLabel();
        lbl_Frente = new javax.swing.JLabel();
        lbl_Final = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_NotacionInfija = new javax.swing.JLabel();
        txtFld_NotacionInfija = new javax.swing.JTextField();
        btn_Transformar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(70, 70, 70));
        jLabel2.setText("Pila - Cola");

        scrll_TablaPila.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrll_TablaPila.setAutoscrolls(true);

        tbl_Pila.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Pila.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Pila.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Pila.setAutoscrolls(false);
        tbl_Pila.setEnabled(false);
        tbl_Pila.setFocusable(false);
        tbl_Pila.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Pila.setRequestFocusEnabled(false);
        tbl_Pila.setRowHeight(40);
        tbl_Pila.setRowSelectionAllowed(false);
        tbl_Pila.getTableHeader().setResizingAllowed(false);
        tbl_Pila.getTableHeader().setReorderingAllowed(false);
        scrll_TablaPila.setViewportView(tbl_Pila);

        scrll_TablaCola.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_Cola.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Cola.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Cola.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Cola.setEnabled(false);
        tbl_Cola.setFocusable(false);
        tbl_Cola.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Cola.setInheritsPopupMenu(true);
        tbl_Cola.setRequestFocusEnabled(false);
        tbl_Cola.setRowHeight(40);
        tbl_Cola.setRowSelectionAllowed(false);
        tbl_Cola.getTableHeader().setResizingAllowed(false);
        tbl_Cola.getTableHeader().setReorderingAllowed(false);
        scrll_TablaCola.setViewportView(tbl_Cola);

        lbl_Fondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Fondo.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Fondo.setText("Fondo: ?");

        lbl_Tope.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Tope.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Tope.setText("Tope: ?");

        lbl_Frente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Frente.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Frente.setText("Frente: ?");

        lbl_Final.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Final.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Final.setText("Final: ?");

        lbl_NotacionInfija.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_NotacionInfija.setForeground(new java.awt.Color(70, 70, 70));
        lbl_NotacionInfija.setText("Notación Infija");

        txtFld_NotacionInfija.setEditable(false);
        txtFld_NotacionInfija.setColumns(45);
        txtFld_NotacionInfija.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_NotacionInfija.setForeground(new java.awt.Color(70, 70, 70));

        btn_Transformar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Transformar.setForeground(new java.awt.Color(70, 70, 70));
        btn_Transformar.setText("TRANSFORMAR");
        btn_Transformar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Transformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TransformarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_NotacionInfija, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrll_TablaCola, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(scrll_TablaPila))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Frente)
                            .addComponent(lbl_Fondo)
                            .addComponent(lbl_Tope)
                            .addComponent(lbl_Final)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFld_NotacionInfija, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Transformar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrll_TablaPila, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrll_TablaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Fondo)
                        .addGap(20, 20, 20)
                        .addComponent(lbl_Tope)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_Frente)
                        .addGap(20, 20, 20)
                        .addComponent(lbl_Final)
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_NotacionInfija)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_NotacionInfija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Transformar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TransformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TransformarActionPerformed
        System.out.println("tipOp: " + tipOp);
        System.out.println("tipExp: " + tipExp);
        System.out.println("tamañoPilaCola: " + tamañoPilaCola);

        txtFld_NotacionInfija.setText(transformacion(tipOp, tipExp));

        editarIndicadorPila();
        editarIndicadorCola();
        editarTablaPilaCola();

        if (p.getTope() == -1 && c.getFin() == -1) {
            btn_Transformar.setEnabled(false);
            itr = 0; // se reinicia a 0, para un próximo uso
        } else {
            btn_Transformar.setEnabled(true);
        }
    }//GEN-LAST:event_btn_TransformarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Transformar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Final;
    private javax.swing.JLabel lbl_Fondo;
    private javax.swing.JLabel lbl_Frente;
    private javax.swing.JLabel lbl_NotacionInfija;
    private javax.swing.JLabel lbl_Tope;
    private javax.swing.JScrollPane scrll_TablaCola;
    private javax.swing.JScrollPane scrll_TablaPila;
    private javax.swing.JTable tbl_Cola;
    private javax.swing.JTable tbl_Pila;
    private javax.swing.JTextField txtFld_NotacionInfija;
    // End of variables declaration//GEN-END:variables
}
