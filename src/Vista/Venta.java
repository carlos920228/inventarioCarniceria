/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Utilerias;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.mClientes;
import modelo.mEntradas;
import modelo.mProductos;
import modelo.mRepartidor;
import modelo.mSalidas;
import modelo.mSucursal;
import modelo.mVentas;
import pruebatiket.Ticket;

public class Venta extends javax.swing.JFrame {
DefaultTableModel table;
    ArrayList combos;//posicion 8 guarda el id del combo, modificar estado a 1 para que salga de inventario
    int partida;
    public Venta() {
        initComponents();
        Image f= Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("image/caba_1.png"));
        this.setIconImage(f);
        setTitle("Ventas");
        setVisible(true);
        jTextField1.setText(new Controlador.Utilerias().fecha());
        loadProductList();
        loadClientes();
        chofer();
        partida = 1;
        table = (DefaultTableModel) jTable1.getModel();
        jLabel7.setText(new Controlador.Utilerias().usuario());
        setVisible(true);
        this.jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                if (Venta.this.jTable1.getSelectedRows().length > 0) {
                    Venta.this.total();
                    modificarSubTotal();
                }
            }
        });
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    public Venta(ArrayList tabla, ArrayList datos, ArrayList combos) {
        initComponents();
        Image f= Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("image/caba_1.png"));
        this.setIconImage(f);
        setTitle("Salidas");
        jTextField1.setText(new Controlador.Utilerias().fecha());
        loadProductList();
        loadClientes();
        chofer();
        table = (DefaultTableModel) jTable1.getModel();
        this.jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                if (Venta.this.jTable1.getSelectedRows().length > 0) {
                    Venta.this.total();
                    modificarSubTotal();
                }
            }
        });
        jLabel7.setText(new Controlador.Utilerias().usuario());
        setVisible(true);
        loadTableData(tabla);
        loadTable(combos);
        jComboBox3.setSelectedIndex((int) datos.get(0));
        jComboBox1.setSelectedIndex((int)datos.get(2));
        this.combos = combos;
        this.setExtendedState(MAXIMIZED_BOTH);

    }
private void loadClientes(){
jComboBox1.removeAllItems();
 ArrayList products = new mClientes().clientesList();
        for (Object o : products) {
            jComboBox1.addItem(o.toString());
        }
}
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
    }//Carga el contenido de la tabla 
private void modificarSubTotal() {
/* 456 */     int fila = this.jTable1.getSelectedRow();
/* 457 */     Float cantidad = Float.parseFloat(this.table.getValueAt(fila, 2).toString());
/* 458 */     if (cantidad == 0) {
/* 459 */       int eliminar = this.jTable1.getSelectedRow();
/* 460 */       this.table.removeRow(eliminar);
/* 461 */       total();
/*     */     } else {
/* 463 */       float precio = Float.parseFloat(this.table.getValueAt(fila, 6).toString());
/* 464 */       float subtotal = cantidad * precio;
/* 465 */       this.table.setValueAt(Float.valueOf(subtotal), fila, 7);
/* 466 */       total();
/*     */     }
/*     */   }
/**
 * Método que envia los metadatos a otra pantalla 
 * f
 * @return 
 */
    private ArrayList data() {
        ArrayList data = new ArrayList();
        data.add(jComboBox3.getSelectedIndex());
        data.add(total());
        data.add(jComboBox1.getSelectedIndex());
        return data;
    }

    private ArrayList dataInsert() {
        ArrayList data = new ArrayList();
        Producto chofer = (Producto) jComboBox3.getSelectedItem();
        data.add(jComboBox1.getSelectedItem().toString());//cliente
        data.add(chofer.getName());//repartidor
        data.add(total());//total
        return data;
    }
    private void chofer() {
        DefaultComboBoxModel mCombo = new DefaultComboBoxModel();
        DefaultComboBoxModel mCombo2 = new DefaultComboBoxModel();
        jComboBox3.setModel(mCombo);
        ArrayList repartidor = new mRepartidor().listRepartidores();
        for (Object o : repartidor) {
            ArrayList data = (ArrayList) o;
            Producto p = new Producto(data.get(0).toString(), data.get(1).toString());
            mCombo.addElement(p);
            mCombo2.addElement(p);
        }
    }

    private void loadProductList() {
        DefaultComboBoxModel mCombo = new DefaultComboBoxModel();
        jComboBox4.setModel(mCombo);
        ArrayList products = new mProductos().productList();
        for (Object o : products) {
            ArrayList data = (ArrayList) o;
            Producto p = new Producto(data.get(0).toString(), data.get(1).toString());
            mCombo.addElement(p);
        }
    }

    private void saveRowsTrf() {
        ArrayList tab = loadData();//Datos de la tabla 
        ArrayList info = dataInsert();//MetaDatos de la venta 
        String id = new mVentas().insertSale(info);
        if (!id.equals("Error")) {
            int error = 0;
            for (Object o : tab) {
                ArrayList x = (ArrayList) o;
                
                if (x.get(0).toString().equals("Combo")||x.get(0).toString().equals("traseros")||x.get(0).toString().equals("delanteros")) { 
                    if (new mVentas().insertRowSale(x, id)) {
                        new mProductos().updateExistence("-" + x.get(5).toString(), x.get(0).toString());
                        new mProductos().updateCombo(x.get(8).toString(),jComboBox1.getSelectedItem().toString());
                    } else {
                        System.out.println("Error al insertar la partida combo " + x.get(6).toString() + " " + x.get(0).toString() + ", no se afecto la existecia");
                        error = error + 1;
                    }
                } else {
                    if (new mVentas().insertRowSale(x, id)) {
                        new mProductos().updateExistence("-" + x.get(5).toString(), x.get(0).toString());
                    } else {
                        System.out.println("Error al insertar la partida " + x.get(5).toString() + " " + x.get(0).toString() + " no se afecto la existecia");
                        error = error + 1;
                    }
                }
            }
            imprimirTicket(tab,id);
            imprimirTicket(tab,id);
            JOptionPane.showMessageDialog(null, "Transferencia guardada con " + error + " Errores");
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la venta, contactar a SISTEMAS");
        }
    }

    private void reset() {
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        int a = this.table.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            this.table.removeRow(i);
        }
        jLabel9.setText("0.0");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Chofer");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Productos");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setText("jTextField1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("jLabel7");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Partida", "K Etiqueta", "# Piezas", "Costo", "Cantidad", "Precio Venta", "Total", "idCombo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox4KeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Bote_de_basura_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setText("TOTAL");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel9.setText("0.0");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(207, 207, 207))
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox3)
                        .addComponent(jLabel4))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGap(114, 114, 114)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyTyped
        if (evt.getKeyChar() == '\n') {
            Producto p = (Producto) jComboBox4.getSelectedItem();
             switch(p.getName()){
                case "Combo": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                case "combo": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                case "Traseros": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                case "traseros": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                case "Delanteros": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                case "delanteros": new listaCombos(data(), loadData(),"venta",p.getName());
                              this.dispose();
                              break;
                default:           Producto p2 = (Producto) jComboBox4.getSelectedItem();
                                   table.addRow(new Object[]{p2.getName(), "0", "0", "0", "0", new mEntradas().ultimoCosto(p.getName()), "1", "0","0"});
                                   total();
                break;
            }
        }
    }//GEN-LAST:event_jComboBox4KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Menu();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(validar()){
        saveRowsTrf();}else{
        JOptionPane.showMessageDialog(null,"Favor de revisar los precios, se encontraron anomalías");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
private void loadTable(ArrayList da) {
        for (Object o : da) {
            ArrayList r = (ArrayList) o;
            table.addRow(new Object[]{r.get(0).toString(),r.get(1).toString(),r.get(2).toString(),r.get(3).toString(),r.get(5).toString(),r.get(6).toString(),"0","0",r.get(7).toString()});
            total();
            partida = partida + 1;
        }
    }
private void loadTableData(ArrayList da) {
        for (Object o : da) {
            ArrayList r = (ArrayList) o;
            table.addRow(r.toArray());
            total();
            partida = partida + 1;
        }
    }
private Double total() {
        Double total = 0.0;
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals("Combo")) {
                float cantidad = Float.parseFloat(this.table.getValueAt(i, 2).toString());
                float precio = Float.parseFloat(this.table.getValueAt(i, 6).toString());
                float subtotal = cantidad * precio;
                total += subtotal;
            } else {
                if (table.getValueAt(i, 6) != null) {
                    float cantidad = Float.parseFloat(this.table.getValueAt(i, 2).toString());
                    float precio = Float.parseFloat(this.table.getValueAt(i, 6).toString());
                    float subtotal = cantidad * precio;
                    total += subtotal;
                }
            }
        }
        
        this.jLabel9.setText(new Utilerias().moneda(total));
        return total;
    }
private void imprimirTicket(ArrayList productos, String folio) {
        java.util.Date date = new java.util.Date();
        Ticket ticket = new Ticket();
        java.text.SimpleDateFormat fecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.text.SimpleDateFormat hora = new java.text.SimpleDateFormat("hh:mm:ss aa");
        Ticket.AddCabecera(Ticket.DarEspacio());
          Ticket.AddSubCabecera("Cliente:  " + jComboBox1.getSelectedItem().toString());
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
        Ticket.AddSubCabecera("  REPARTIDOR: " + jComboBox3.getSelectedItem().toString());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("  AUTORIZO   " + new Utilerias().usuario());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera(Ticket.DarEspacio());
        Ticket.AddSubCabecera("_________________________________________________");
        Ticket.AddItem("", "", Ticket.DarEspacio());
        for (Object x : productos) {
            ArrayList pro = (ArrayList) x;
            Ticket.AddItem("Producto: " + pro.get(0).toString(),"| K. Etiqueta: "+pro.get(2).toString()," |Precio: " + pro.get(6).toString()+" |SubTotal: " + pro.get(7).toString());
            Ticket.AddItem("", "", Ticket.DarEspacio());
        }
        Ticket.AddTotal(Ticket.DibujarLinea(40), "  ");
        Ticket.AddTotal("", Ticket.DarEspacio());
        Ticket.AddTotal("   TOTAL             ", this.jLabel9.getText());
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
private boolean validar(){
    boolean b=true;
    for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            Double d=Double.parseDouble(table.getValueAt(i, 6).toString());
            if(d<10){
            b=false;
            }
}
return b;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
