package Vista;

import Controlador.Utilerias;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.mProductos;
import modelo.mVentas;
import pruebatiket.Ticket;

public class verVenta extends javax.swing.JFrame {
    ArrayList data;
    DefaultTableModel table;
    String mode;
    public verVenta(ArrayList data) {
        initComponents();
        mode="good";
        this.data=data;
        table=(DefaultTableModel)jTable1.getModel();
        this.setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        llenar();
        Image f= Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("image/caba_1.png"));
        this.setIconImage(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fecha");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Cliente");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Chofer");

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField3.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("jLabel5");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Partida", "K Etiqueta", "# Piezas", "Costo", "Cantidad", "Merma", "Precio Venta", "Total", "Merma Reportada", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Total");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("0.0");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Folio");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("jLabel8");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/impresora.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancelar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(jLabel6)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new HistorialCliente();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList tab = loadData();
        imprimirTicket(tab,jLabel8.getText());
        imprimirTicket(tab,jLabel8.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!mode.equals("Cancelado")){
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
        String producto=table.getValueAt(i, 0).toString();
        String cantidad=table.getValueAt(i, 5).toString();
        String idProdu=table.getValueAt(i, 10).toString();
        switch(producto){
            case "Combo":
                new mProductos().updateExistence("1",producto);
                new mProductos().updateComboCancel(idProdu);
            break;
            case "delanteros":
                new mProductos().updateExistence("1",producto);
                new mProductos().updateComboCancel(idProdu);
            break;
            case "traseros":
                new mProductos().updateExistence("1",producto);
                new mProductos().updateComboCancel(idProdu);
            break;
            default:
                new mProductos().updateExistence(cantidad,producto);
                break;
        }
        }
        new mVentas().updateCancel(jLabel8.getText());
        JOptionPane.showMessageDialog(null,"Venta cancelada");
        new Reporteador();
        this.dispose();
        }else{
        JOptionPane.showMessageDialog(null,"Error, la venta ya fue cancelada anteriormente");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
private ArrayList loadData() {
        ArrayList data = new ArrayList();
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            ArrayList row = new ArrayList();
            row.add(table.getValueAt(i, 0).toString());
            row.add(table.getValueAt(i, 1).toString());
            row.add(table.getValueAt(i, 2).toString());
            row.add(table.getValueAt(i, 3).toString());
            row.add(table.getValueAt(i, 4).toString());
            row.add(table.getValueAt(i, 5).toString());
            row.add(table.getValueAt(i, 6).toString());
            row.add(table.getValueAt(i, 7).toString());
            row.add(table.getValueAt(i, 8).toString());
            data.add(row);
        }
        return data;
    }
    private void llenar(){
jTextField1.setText(data.get(7).toString());//Fecha
jTextField2.setText(data.get(2).toString());//Cliente
jTextField3.setText(data.get(3).toString());//chofer
jLabel5.setText(data.get(1).toString());//Usuario
jLabel7.setText(data.get(4).toString());//Total
jLabel8.setText(data.get(0).toString());//Folio
mode=data.get(8).toString();//Fecha
ArrayList tab=new mVentas().recuperarVenta(data.get(0).toString());
    for (Object o:tab) {
        ArrayList x=(ArrayList)o;
        x.remove(0);
        table.addRow(x.toArray());
    }
}
private void imprimirTicket(ArrayList productos, String folio) {
        java.util.Date date = new java.util.Date();
        Ticket ticket = new Ticket();
        java.text.SimpleDateFormat fecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.text.SimpleDateFormat hora = new java.text.SimpleDateFormat("hh:mm:ss aa");
        Ticket.AddCabecera(Ticket.DarEspacio());
          Ticket.AddSubCabecera("Cliente:  " + jTextField2.getText());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(new Utilerias().local());
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(new Utilerias().leerRfc());
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(new Utilerias().telefono());
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(new Utilerias().direccion());
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddCabecera(Ticket.DibujarLinea(40));
        Ticket.AddCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("FECHA: " + fecha.format(date) + " " + hora.format(date));
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DibujarLinea(40));
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("  REPARTIDOR: " + jTextField3.getText());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("  AUTORIZO   " + new Utilerias().usuario());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("_________________________________________________");
        Ticket.AddItem("", "", Ticket.DarEspacio());
        for (Object x : productos) {
            ArrayList pro = (ArrayList) x;
            Ticket.AddItem("Producto: " + pro.get(0).toString(),"| K. Etiqueta: "+pro.get(2).toString()," |Piezas: " + pro.get(3).toString()+" |Precio: " + pro.get(7).toString()+" |SubTotal: " + pro.get(8).toString());
            Ticket.AddItem("", "", Ticket.DarEspacio());
        }
        Ticket.AddTotal(Ticket.DibujarLinea(40), "  ");
        Ticket.AddTotal("", Ticket.DarEspacio());
        Ticket.AddTotal("   TOTAL             ", this.jLabel7.getText());
        Ticket.AddTotal("", Ticket.DarEspacio());
        Ticket.AddTotal("", Ticket.DarEspacio());
        Ticket.AddTotal("", Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DibujarLinea(40));
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("  REGIMEN DE INCORPORACION FISCAL");
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("   FOLIO " + folio);
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("Autoriza:  _______________________________");
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("Surtio:    _______________________________");
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("REPARTIDOR:_______________________________");
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea("RECIBIO:   _______________________________");
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.AddPieLinea(Ticket.DarEspacio());
        Ticket.ImprimirDocumento();
        this.jTextField1.requestFocus();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
