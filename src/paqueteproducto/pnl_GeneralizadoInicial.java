package paqueteproducto;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class pnl_GeneralizadoInicial extends javax.swing.JPanel {

    /**
     * Variables que se pueden modificar
     */
    Scanner input = new Scanner(System.in);
    private final int anchoTabla = 465; // valor constante
    private int tamañoPilaCola;
    private Pila p;
    private Cola c;

    private DefaultTableModel tablaModeloPila;
    private DefaultTableModel tablaModeloCola;

    /**
     * Creates new form pnl_GeneralizadoIncial
     */
    public pnl_GeneralizadoInicial() {
        initComponents();
        btn_Definir.setEnabled(false);
        btn_InsertarCola.setEnabled(false);
        btn_InsertarPila.setEnabled(false);
        txtFld_InsertarCola.setEnabled(false);
        txtFld_InsertarPila.setEnabled(false);
    }

    /**
     * Métodos que se pueden modificar
     */
    private void crearPilaCola() {
        p = new Pila(new String[tamañoPilaCola], -1, -1);
        c = new Cola(new String[tamañoPilaCola], -1, -1);
    }

    private void llenarTablaModelo(String PilaCola) {
        switch (PilaCola) {
            case "Pila" -> {
                tablaModeloPila = new DefaultTableModel();
                tablaModeloPila.addColumn("Índice");
                for (int i = 0; i < tamañoPilaCola; i++) {
                    tablaModeloPila.addColumn(String.valueOf(i));
                }
                tablaModeloPila.addRow(new String[tamañoPilaCola + 1]);
                tablaModeloPila.setValueAt(PilaCola, 0, 0);
                tbl_Pila.setModel(tablaModeloPila);

                // centrar los datos
                centrarColumna(tbl_Pila);
                definirAnchoDeColumnas(tbl_Pila);

            }
            case "Cola" -> {
                tablaModeloCola = new DefaultTableModel();
                tablaModeloCola.addColumn("Índice");
                for (int i = 0; i < tamañoPilaCola; i++) {
                    tablaModeloCola.addColumn(String.valueOf(i));
                }
                tablaModeloCola.addRow(new String[tamañoPilaCola + 1]);
                tablaModeloCola.setValueAt(PilaCola, 0, 0);
                tbl_Cola.setModel(tablaModeloCola);

                // centrar los datos
                centrarColumna(tbl_Cola);
                definirAnchoDeColumnas(tbl_Cola);
            }
        }

    }

    public void editarIndicadorPila() {
        lbl_Fondo.setText("Fondo: " + p.getFondo());
        lbl_Tope.setText("Tope: " + p.getTope());
    }

    public void editarIndicadorCola() {
        lbl_Frente.setText("Frente: " + c.getFrente());
        lbl_Final.setText("Final: " + c.getFin());
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

    public boolean confirmarLlenadoDeColaPila() {
        boolean llenado = false;
        if (p != null && c != null) { // primero se pregunta si ya sean creado los objetos
            if (p.getTope() == p.getN() && c.getFin() == c.getN()) {
                llenado = true;
            }
        }
        return llenado;
    }

    private boolean identificarNumeros(String dato) {
        boolean estado = true;
        for (int i = 0; i < dato.length(); i++) {
            if (!(dato.charAt(i) >= '0' && dato.charAt(i) <= '9' || (dato.charAt(0) == '-' && dato.length() != 1))) {
                JOptionPane.showMessageDialog(null, "El dato ingresado no es un número.");
                estado = false;
                break;
            } else if (dato.length() == 1 && dato.charAt(0) == '0') {
                JOptionPane.showMessageDialog(null, "Defina un tamaño mayor a cero.");
                estado = false;
            } else if (dato.charAt(0) == '-' && dato.length() != 1) {
                JOptionPane.showMessageDialog(null, "Defina un tamaño no negativo.");
                estado = false;
                break;
            }
        }
        return estado;
    }

    private boolean identificarCoeficiente(String dato) {
        boolean estado = true;
        int inicio;
        inicio = ((dato.charAt(0) == '-' && dato.length() != 1) ? 1 : 0);
        for (int i = inicio; i < dato.length(); i++) {
            if (!(dato.charAt(i) >= '0' && dato.charAt(i) <= '9')) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números en la cola.");
                estado = false;
                break;
            }
        }
        return estado;
    }

    private boolean identificarVariable(String dato) {
        boolean estado = true;
        for (int i = 0; i < dato.length(); i++) {
            if (!((dato.charAt(i) >= 'a' && dato.charAt(i) <= 'z') || (dato.charAt(i) >= 'A' && dato.charAt(i) <= 'Z'))) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan letras en la pila.");
                estado = false;
                break;
            } else if (dato.length() != 1) {
                JOptionPane.showMessageDialog(null, "Para representar una variable solo \nse hace uso de una letra.");
                estado = false;
                break;
            }
        }
        return estado;
    }

    // --- Getters ----------------------------------------
    public Pila getP() {
        return p;
    }

    public Cola getC() {
        return c;
    }

    public int getTamañoPilaCola() {
        return tamañoPilaCola;
    }

    public DefaultTableModel getTablaModeloPila() {
        return tablaModeloPila;
    }

    public DefaultTableModel getTablaModeloCola() {
        return tablaModeloCola;
    }

    // ---------------------------------------------
    public int getTopePila() {
        return p.getTope();
    }

    public int getNPila() {
        return p.getN();
    }

    public int getFinCola() {
        return c.getFin();
    }

    public int getNCola() {
        return c.getN();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtArea_Indicaciones = new javax.swing.JTextArea();
        lbl_Indicaciones = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_Tamaño = new javax.swing.JLabel();
        txtFld_Tamaño = new javax.swing.JTextField();
        btn_Definir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_Insertar = new javax.swing.JLabel();
        txtFld_InsertarPila = new javax.swing.JTextField();
        btn_InsertarPila = new javax.swing.JButton();
        btn_InsertarCola = new javax.swing.JButton();
        txtFld_InsertarCola = new javax.swing.JTextField();
        scrll_TablaPila = new javax.swing.JScrollPane();
        tbl_Pila = new javax.swing.JTable();
        lbl_PilaCola = new javax.swing.JLabel();
        scrll_TablaCola = new javax.swing.JScrollPane();
        tbl_Cola = new javax.swing.JTable();
        lbl_Tope = new javax.swing.JLabel();
        lbl_Fondo = new javax.swing.JLabel();
        lbl_Frente = new javax.swing.JLabel();
        lbl_Final = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(850, 500));

        txtArea_Indicaciones.setEditable(false);
        txtArea_Indicaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtArea_Indicaciones.setColumns(20);
        txtArea_Indicaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtArea_Indicaciones.setForeground(new java.awt.Color(80, 80, 80));
        txtArea_Indicaciones.setLineWrap(true);
        txtArea_Indicaciones.setRows(5);
        txtArea_Indicaciones.setText("• Los datos introducidos en la pila son letras, en cambio en la cola solo se introducen números.\n• El tamaño de la pila y cola debe ser la misma, y necesario llenarlas.\n• Como operadores solo se acepta el signo de resta \"-\" y el de suma \"+\".");
        txtArea_Indicaciones.setWrapStyleWord(true);
        txtArea_Indicaciones.setAutoscrolls(false);
        txtArea_Indicaciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtArea_Indicaciones.setFocusable(false);
        txtArea_Indicaciones.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtArea_Indicaciones.setMinimumSize(new java.awt.Dimension(750, 110));

        lbl_Indicaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Indicaciones.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Indicaciones.setText("Indicaciones");

        lbl_Tamaño.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Tamaño.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Tamaño.setText("Tamaño");

        txtFld_Tamaño.setColumns(10);
        txtFld_Tamaño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_Tamaño.setForeground(new java.awt.Color(70, 70, 70));
        txtFld_Tamaño.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFld_TamañoFocusLost(evt);
            }
        });
        txtFld_Tamaño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFld_TamañoKeyReleased(evt);
            }
        });

        btn_Definir.setForeground(new java.awt.Color(70, 70, 70));
        btn_Definir.setText("DEFINIR");
        btn_Definir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Definir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DefinirActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbl_Insertar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Insertar.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Insertar.setText("Insetar");

        txtFld_InsertarPila.setColumns(10);
        txtFld_InsertarPila.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_InsertarPila.setForeground(new java.awt.Color(70, 70, 70));
        txtFld_InsertarPila.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFld_InsertarPilaFocusLost(evt);
            }
        });
        txtFld_InsertarPila.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFld_InsertarPilaKeyReleased(evt);
            }
        });

        btn_InsertarPila.setForeground(new java.awt.Color(70, 70, 70));
        btn_InsertarPila.setText("PILA");
        btn_InsertarPila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_InsertarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarPilaActionPerformed(evt);
            }
        });

        btn_InsertarCola.setForeground(new java.awt.Color(70, 70, 70));
        btn_InsertarCola.setText("COLA");
        btn_InsertarCola.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_InsertarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarColaActionPerformed(evt);
            }
        });

        txtFld_InsertarCola.setColumns(10);
        txtFld_InsertarCola.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_InsertarCola.setForeground(new java.awt.Color(70, 70, 70));
        txtFld_InsertarCola.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFld_InsertarColaFocusLost(evt);
            }
        });
        txtFld_InsertarCola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFld_InsertarColaKeyReleased(evt);
            }
        });

        scrll_TablaPila.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrll_TablaPila.setAutoscrolls(true);

        tbl_Pila.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Pila.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Pila.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_Pila.setEnabled(false);
        tbl_Pila.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Pila.setName(""); // NOI18N
        tbl_Pila.setRowHeight(40);
        tbl_Pila.getTableHeader().setResizingAllowed(false);
        tbl_Pila.getTableHeader().setReorderingAllowed(false);
        scrll_TablaPila.setViewportView(tbl_Pila);

        lbl_PilaCola.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_PilaCola.setForeground(new java.awt.Color(70, 70, 70));
        lbl_PilaCola.setText("Pila - Cola");

        scrll_TablaCola.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_Cola.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Cola.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Cola.setEnabled(false);
        tbl_Cola.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Cola.setRowHeight(40);
        tbl_Cola.getTableHeader().setResizingAllowed(false);
        tbl_Cola.getTableHeader().setReorderingAllowed(false);
        scrll_TablaCola.setViewportView(tbl_Cola);

        lbl_Tope.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Tope.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Tope.setText("Tope: ?");

        lbl_Fondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Fondo.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Fondo.setText("Fondo: ?");

        lbl_Frente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Frente.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Frente.setText("Frente: ?");

        lbl_Final.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Final.setForeground(new java.awt.Color(80, 80, 80));
        lbl_Final.setText("Final: ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(lbl_Indicaciones)
                    .addComponent(txtArea_Indicaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_Insertar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_Tamaño, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFld_Tamaño, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFld_InsertarPila, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_Definir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_InsertarPila, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtFld_InsertarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_InsertarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_PilaCola, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrll_TablaCola, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(scrll_TablaPila, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Frente)
                            .addComponent(lbl_Fondo)
                            .addComponent(lbl_Tope)
                            .addComponent(lbl_Final))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_Indicaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtArea_Indicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_Tamaño)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btn_Definir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFld_Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_Insertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btn_InsertarPila, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFld_InsertarPila, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btn_InsertarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFld_InsertarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_PilaCola)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrll_TablaPila, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(scrll_TablaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbl_Fondo)
                                .addGap(20, 20, 20)
                                .addComponent(lbl_Tope)
                                .addGap(44, 44, 44)
                                .addComponent(lbl_Frente)
                                .addGap(20, 20, 20)
                                .addComponent(lbl_Final)))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DefinirActionPerformed
        if (!txtFld_Tamaño.getText().equals("")) {
            if (identificarNumeros(txtFld_Tamaño.getText())) {
                btn_Definir.setEnabled(true);
                tamañoPilaCola = Integer.valueOf(txtFld_Tamaño.getText());

                crearPilaCola();
                llenarTablaModelo("Pila");
                llenarTablaModelo("Cola");
                txtFld_InsertarPila.setEnabled(true);
                txtFld_InsertarCola.setEnabled(true);
                btn_Definir.setEnabled(false);
            } else {
                txtFld_Tamaño.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un dato.");
        }

        // borrar luego
        System.out.println("Tamaño de la pila y cola: " + tamañoPilaCola);
    }//GEN-LAST:event_btn_DefinirActionPerformed

    private void txtFld_TamañoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFld_TamañoKeyReleased
        if (!txtFld_Tamaño.getText().equals("")) {
            btn_Definir.setEnabled(true);
        }
    }//GEN-LAST:event_txtFld_TamañoKeyReleased

    private void txtFld_TamañoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFld_TamañoFocusLost
        if (txtFld_Tamaño.getText().equals("")) {
            btn_Definir.setEnabled(false);
        }
    }//GEN-LAST:event_txtFld_TamañoFocusLost

    private void btn_InsertarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarPilaActionPerformed
        if (identificarVariable(txtFld_InsertarPila.getText())) {
            p.push(txtFld_InsertarPila.getText());
            if (tablaModeloPila.getValueAt(0, p.getTope() + 1) == null) {
                tablaModeloPila.setValueAt(txtFld_InsertarPila.getText(), 0, p.getTope() + 1);
                // se suma 1 al tope de la pila, porque en la posición 0 (de la tabla) está la palabra "Pila"
                editarIndicadorPila();
                // verifica el estado actual de la cola y pila
                confirmarLlenadoDeColaPila();
            }
        }
    }//GEN-LAST:event_btn_InsertarPilaActionPerformed

    private void txtFld_InsertarPilaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFld_InsertarPilaKeyReleased
        if (!txtFld_InsertarPila.getText().equals("")) {
            btn_InsertarPila.setEnabled(true);
        }
    }//GEN-LAST:event_txtFld_InsertarPilaKeyReleased

    private void txtFld_InsertarPilaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFld_InsertarPilaFocusLost
        if (txtFld_InsertarPila.getText().equals("")) {
            btn_InsertarPila.setEnabled(false);
        }
    }//GEN-LAST:event_txtFld_InsertarPilaFocusLost

    private void btn_InsertarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarColaActionPerformed
        if (identificarCoeficiente(txtFld_InsertarCola.getText())) {
            c.insertar(txtFld_InsertarCola.getText());
            if (tablaModeloCola.getValueAt(0, c.getFin() + 1) == null) {
                tablaModeloCola.setValueAt(txtFld_InsertarCola.getText(), 0, c.getFin() + 1);
                // se suma 1 al fin de la cola, porque en la posición 0 (de la tabla) está la palabra "Cola"
                editarIndicadorCola();
                // verifica el estado actual de la cola y pila
                confirmarLlenadoDeColaPila();
            }
        }
    }//GEN-LAST:event_btn_InsertarColaActionPerformed

    private void txtFld_InsertarColaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFld_InsertarColaKeyReleased
        if (!txtFld_InsertarCola.getText().equals("")) {
            btn_InsertarCola.setEnabled(true);
        }
    }//GEN-LAST:event_txtFld_InsertarColaKeyReleased

    private void txtFld_InsertarColaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFld_InsertarColaFocusLost
        if (txtFld_InsertarCola.getText().equals("")) {
            btn_InsertarCola.setEnabled(false);
        }
    }//GEN-LAST:event_txtFld_InsertarColaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Definir;
    private javax.swing.JButton btn_InsertarCola;
    private javax.swing.JButton btn_InsertarPila;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_Final;
    private javax.swing.JLabel lbl_Fondo;
    private javax.swing.JLabel lbl_Frente;
    private javax.swing.JLabel lbl_Indicaciones;
    private javax.swing.JLabel lbl_Insertar;
    private javax.swing.JLabel lbl_PilaCola;
    private javax.swing.JLabel lbl_Tamaño;
    private javax.swing.JLabel lbl_Tope;
    private javax.swing.JScrollPane scrll_TablaCola;
    private javax.swing.JScrollPane scrll_TablaPila;
    private javax.swing.JTable tbl_Cola;
    private javax.swing.JTable tbl_Pila;
    private javax.swing.JTextArea txtArea_Indicaciones;
    private javax.swing.JTextField txtFld_InsertarCola;
    private javax.swing.JTextField txtFld_InsertarPila;
    private javax.swing.JTextField txtFld_Tamaño;
    // End of variables declaration//GEN-END:variables
}
