package paqueteproducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class pnl_Propuesto extends javax.swing.JPanel {

    /**
     * Variables que se pueden modificar
     */
    Scanner input = new Scanner(System.in);
    private final int tamañoPilaCola = 5;
    private int itr;
    String[] cola = {"15", "11", "9", "6", "1"};
    String[] pila = {"b", "a", "z", "y", "x"};
    private Pila p;
    private Cola c;
    private final DefaultTableModel tablaModeloPila = new DefaultTableModel();
    private final DefaultTableModel tablaModeloCola = new DefaultTableModel();
    private Timer time;

    /**
     * Creates new form pnl_Propuesto
     */
    public pnl_Propuesto() {
        crearPilaCola();
        llenarTablaModelo(tablaModeloPila, "Pila", 'p');
        llenarTablaModelo(tablaModeloCola, "Cola", 'c');

        initComponents();
        editarIndicadorPilaCola();
    }

    /**
     * Métodos que se pueden modificar
     */
    private void crearPilaCola() {
        p = new Pila(new String[tamañoPilaCola], -1, -1);
        p.push("b");
        p.push("a");
        p.push("z");
        p.push("y");
        p.push("x");

        c = new Cola(new String[tamañoPilaCola], -1, -1);
        c.insertar("15");
        c.insertar("11");
        c.insertar("9");
        c.insertar("6");
        c.insertar("1");
    }

    private void llenarTablaModelo(DefaultTableModel tablaModelo, String PilaCola, char tipo) {
        tablaModelo.addColumn("Índice");
        for (int i = 0; i < tamañoPilaCola; i++) {
            tablaModelo.addColumn(String.valueOf(i));
        }
        tablaModelo.addRow(new String[tamañoPilaCola + 1]);
        tablaModelo.setValueAt(PilaCola, 0, 0);
        switch (tipo) {
            case 'p' -> {
                for (int i = 0; i < tamañoPilaCola; i++) {
                    tablaModelo.setValueAt(p.getArray()[i], 0, i + 1);
                }
            }
            case 'c' -> {
                for (int i = 0; i < tamañoPilaCola; i++) {
                    tablaModelo.setValueAt(c.getArray()[i], 0, i + 1);
                }
            }
        }
    }

    private void editarIndicadorPilaCola() {
        lbl_Fondo.setText("Fondo: " + p.getFondo());
        lbl_Tope.setText("Tope: " + p.getTope());

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

    private void animacionTransformacion() {

        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarIndicadorPilaCola();
                editarTablaPilaCola();
            }
        });
    }

    //
    private String transformacion(int tipOp, int tipExp) {
        String notInf = "";
        String x, exp; // para almacenar el valor que retorna la cola al hacer la supresión

        switch (tipExp) {
            case 1 -> { // 15*x
                for (int i = 0; i < tamañoPilaCola; i++) {                  
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop(); // se hace pop y se disminuye en 1 el tope
                    notInf += ((p.getTope() > 0) ? "^" + (p.getTope() + 1) : ""); // por eso se suma 1 al tope
                    notInf += ((i < tamañoPilaCola - 1) ? operador(tipOp) : "");
                }
            }
            case 2 -> {
                for (int i = 0; i < tamañoPilaCola; i++) {
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop();
                    System.out.print("Ingrese el exponente n°" + (1 + i) + ": ");
                    exp = input.next();
                    notInf += (!exp.equals("1") ? "^" + exp : "");
                    notInf += ((i < tamañoPilaCola - 1) ? operador(tipOp) : "");
                }
            }
            case 3 -> {
            }
            default -> {
                System.out.println("\nError, opción no encontrada.\n");
            }
        }
        return notInf;
    }

    private String operador(int tipOp) {
        String operador = "";

        switch (tipOp) {
            case 1 -> {
                operador = (itr % 2 == 0) ? "-" : "+";
                itr++;
            }
            case 2 -> {
                operador = (Math.round((Math.random() + 1)) == 1) ? "-" : "+";
            }
            case 3 -> {
                System.out.print("Indroduzca el operador n°" + (1 + itr) + ": ");
                operador = String.valueOf(input.next().charAt(0));
                itr++; // sirve para contar los operadores también.
            }
        }
        return operador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Enunciado = new javax.swing.JLabel();
        txtArea_Enunciado = new javax.swing.JTextArea();
        txtFld_NotacionInfija = new javax.swing.JTextField();
        btn_Transformar = new javax.swing.JButton();
        scrll_TablaPila = new javax.swing.JScrollPane();
        tbl_Pila = new javax.swing.JTable();
        scrll_TablaCola = new javax.swing.JScrollPane();
        tbl_Cola = new javax.swing.JTable();
        lbl_Fondo = new javax.swing.JLabel();
        lbl_Tope = new javax.swing.JLabel();
        lbl_Frente = new javax.swing.JLabel();
        lbl_Final = new javax.swing.JLabel();
        lbl_PilaCola = new javax.swing.JLabel();
        lbl_NotacionInfija = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(245, 245, 245));
        setDoubleBuffered(false);
        setEnabled(false);
        setFocusable(false);
        setRequestFocusEnabled(false);

        lbl_Enunciado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Enunciado.setForeground(new java.awt.Color(70, 70, 70));
        lbl_Enunciado.setText("Enunciado");

        txtArea_Enunciado.setEditable(false);
        txtArea_Enunciado.setBackground(new java.awt.Color(255, 255, 255));
        txtArea_Enunciado.setColumns(20);
        txtArea_Enunciado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtArea_Enunciado.setForeground(new java.awt.Color(80, 80, 80));
        txtArea_Enunciado.setLineWrap(true);
        txtArea_Enunciado.setRows(5);
        txtArea_Enunciado.setText("Se tiene dos Estructuras de datos, PILA que contiene una lista de variables y COLA que contiene una lista de coeficientes. Debe preparar un método que empleando las operaciones de PILAS Y COLAS, arme el POLINOMIO (cadena lineal) correspondiente en notación infija. Implementación: (a) En una sola clase main, (b) En una clase main con métodos en esa misma clase, (c) en una clase main con métodos en otra clase y (d) con Swing.");
        txtArea_Enunciado.setWrapStyleWord(true);
        txtArea_Enunciado.setAutoscrolls(false);
        txtArea_Enunciado.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtArea_Enunciado.setFocusable(false);
        txtArea_Enunciado.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtArea_Enunciado.setMinimumSize(new java.awt.Dimension(750, 110));

        txtFld_NotacionInfija.setEditable(false);
        txtFld_NotacionInfija.setColumns(45);
        txtFld_NotacionInfija.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_Transformar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Transformar.setText("TRANSFORMAR");
        btn_Transformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TransformarActionPerformed(evt);
            }
        });

        scrll_TablaPila.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrll_TablaPila.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrll_TablaPila.setAutoscrolls(true);

        tbl_Pila.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Pila.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Pila.setModel(tablaModeloPila);
        tbl_Pila.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Pila.setAutoscrolls(false);
        tbl_Pila.setEnabled(false);
        tbl_Pila.setFocusable(false);
        tbl_Pila.setRequestFocusEnabled(false);
        tbl_Pila.setRowHeight(40);
        tbl_Pila.setRowSelectionAllowed(false);
        tbl_Pila.getTableHeader().setResizingAllowed(false);
        tbl_Pila.getTableHeader().setReorderingAllowed(false);
        scrll_TablaPila.setViewportView(tbl_Pila);

        scrll_TablaCola.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrll_TablaCola.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_Cola.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Cola.setForeground(new java.awt.Color(80, 80, 80));
        tbl_Cola.setModel(tablaModeloCola);
        tbl_Cola.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Cola.setEnabled(false);
        tbl_Cola.setFocusable(false);
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

        lbl_PilaCola.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_PilaCola.setForeground(new java.awt.Color(70, 70, 70));
        lbl_PilaCola.setText("Pila - Cola");

        lbl_NotacionInfija.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_NotacionInfija.setForeground(new java.awt.Color(70, 70, 70));
        lbl_NotacionInfija.setText("Notación Infija");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NotacionInfija, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_PilaCola, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Enunciado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArea_Enunciado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtFld_NotacionInfija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Transformar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrll_TablaPila, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrll_TablaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Frente)
                            .addComponent(lbl_Fondo)
                            .addComponent(lbl_Tope)
                            .addComponent(lbl_Final))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_Enunciado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtArea_Enunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_PilaCola)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbl_Fondo)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Tope))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrll_TablaPila, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrll_TablaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbl_Frente)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Final)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_NotacionInfija)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_NotacionInfija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Transformar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TransformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TransformarActionPerformed
        // valores preestablecidos
        txtFld_NotacionInfija.setText(transformacion(1, 1));
        editarIndicadorPilaCola();
        editarTablaPilaCola();
        btn_Transformar.setEnabled(false);
    }//GEN-LAST:event_btn_TransformarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Transformar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Enunciado;
    private javax.swing.JLabel lbl_Final;
    private javax.swing.JLabel lbl_Fondo;
    private javax.swing.JLabel lbl_Frente;
    private javax.swing.JLabel lbl_NotacionInfija;
    private javax.swing.JLabel lbl_PilaCola;
    private javax.swing.JLabel lbl_Tope;
    private javax.swing.JScrollPane scrll_TablaCola;
    private javax.swing.JScrollPane scrll_TablaPila;
    private javax.swing.JTable tbl_Cola;
    private javax.swing.JTable tbl_Pila;
    private javax.swing.JTextArea txtArea_Enunciado;
    private javax.swing.JTextField txtFld_NotacionInfija;
    // End of variables declaration//GEN-END:variables
}
