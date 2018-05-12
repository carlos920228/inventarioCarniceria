/*    */ package pruebatiket;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Frame;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.PrintJob;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Impresora
/*    */ {
/* 21 */   Font fuente = new Font("Dialog", 0, 15);
/*    */   
/*    */ 
/*    */   PrintJob pj;
/*    */   
/*    */ 
/*    */   Graphics pagina;
/*    */   
/*    */ 
/*    */   public Impresora()
/*    */   {
/* 32 */     this.pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void imprimir(String Cadena)
/*    */   {
/*    */     try
/*    */     {
/* 45 */       this.pagina = this.pj.getGraphics();
/* 46 */       this.pagina.setFont(this.fuente);
/* 47 */       this.pagina.setColor(Color.black);
/* 48 */       String[] datos = Cadena.split("\n");
/* 49 */       for (int i = 0; i < datos.length; i++) {
/* 50 */         int dis = 5;
/* 51 */         this.pagina.drawString(datos[i].toUpperCase(), 60, 60);
/* 52 */         this.pagina.translate(0, dis);
/* 53 */         dis += 5;
/*    */       }
/* 55 */       this.pagina.dispose();
/* 56 */       this.pj.end();
/*    */     }
/*    */     catch (Exception e) {
/* 59 */       System.out.println("LA IMPRESION HA SIDO CANCELADA...");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\softlution\Desktop\pedidos\pedidos\Pedidos.jar!\pruebatiket\Impresora.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */