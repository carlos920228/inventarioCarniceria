/*    */ package pruebatiket;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrderTotal
/*    */ {
/*  9 */   char[] temp = { ' ' };
/* 10 */   public OrderTotal(char delimit) { this.temp = new char[] { delimit }; }
/*    */   
/* 12 */   public String GetTotalNombre(String totalItem) { String[] delimitado = totalItem.split("" + this.temp);
/* 13 */     return delimitado[0];
/*    */   }
/*    */   
/* 16 */   public String GetTotalCantidad(String totalItem) { String[] delimitado = totalItem.split("" + this.temp);
/* 17 */     return delimitado[1]; }
/*    */   
/* 19 */   public String GeneraTotal(String Nombre, String precio) { return Nombre + this.temp[0] + precio; }
/*    */ }


/* Location:              C:\Users\softlution\Desktop\pedidos\pedidos\Pedidos.jar!\pruebatiket\OrderTotal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */