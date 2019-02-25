/*    */ package pruebatiket;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrderItem
/*    */ {
/*  9 */   char[] temp = { ' ' };
/* 10 */   public OrderItem(char delimit) { this.temp = new char[] { delimit }; }
/*    */   
/* 12 */   public String GetItemCantidad(String orderItem) { String[] delimitado = orderItem.split("" + this.temp);
/* 13 */     return delimitado[0];
/*    */   }
/*    */   
/* 16 */   public String GetItemNombre(String orderItem) { String[] delimitado = orderItem.split("" + this.temp);
/* 17 */     return delimitado[1];
/*    */   }
/*    */   
/* 20 */   public String GetItemPrecio(String orderItem) { String[] delimitado = orderItem.split("" + this.temp);
/* 21 */     return delimitado[2]; }
/*    */   
/* 23 */   public String GeneraItem(String cantidad, String nombre, String precio) { return cantidad + this.temp[0] + nombre + this.temp[0] + precio; }
/*    */ }


/* Location:              C:\Users\softlution\Desktop\pedidos\pedidos\Pedidos.jar!\pruebatiket\OrderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */