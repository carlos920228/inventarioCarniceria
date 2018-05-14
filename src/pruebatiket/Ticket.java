/*    */ package pruebatiket;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import javax.print.Doc;
/*    */ import javax.print.DocFlavor;
/*    */ import javax.print.DocFlavor.BYTE_ARRAY;
/*    */ import javax.print.DocPrintJob;
/*    */ import javax.print.PrintService;
/*    */ import javax.print.PrintServiceLookup;
/*    */ import javax.print.SimpleDoc;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ public class Ticket
/*    */ {
/* 16 */   static ArrayList<String> CabezaLineas = new ArrayList();
/* 17 */   static ArrayList<String> subCabezaLineas = new ArrayList();
/* 18 */   static ArrayList<String> items = new ArrayList();
/* 19 */   static ArrayList<String> totales = new ArrayList();
/* 20 */   static ArrayList<String> LineasPie = new ArrayList();
/* 21 */   public static void AddCabecera(String line) { CabezaLineas.add(line); }
/* 22 */   public static void AddSubCabecera(String line) { subCabezaLineas.add(line); }
/*    */   
/* 24 */   public static void AddItem(String cantidad, String item, String price) { OrderItem newItem = new OrderItem(' ');
/* 25 */     items.add(newItem.GeneraItem(cantidad, item, price));
/*    */   }
/*    */   
/* 28 */   public static void AddTotal(String name, String price) { OrderTotal newTotal = new OrderTotal(' ');
/* 29 */     totales.add(newTotal.GeneraTotal(name, price)); }
/*    */   
/* 31 */   public static void AddPieLinea(String line) { LineasPie.add(line); }
/*    */   
/* 33 */   public static String DibujarLinea(int valor) { String raya = ""; for (int x = 0; x < valor; x++) raya = raya + "_"; return raya;
/*    */   }
/*    */   
/* 36 */   public static String cortarHoja() { return "\033m"; }
/*    */   
/* 38 */   public static String DarEspacio() { return "\n"; }
/*    */   
/* 40 */   public static void ImprimirDocumento() { String cadena = "";
/* 41 */     for (int cabecera = 0; cabecera < CabezaLineas.size(); cabecera++) {
/* 42 */       cadena = cadena + (String)CabezaLineas.get(cabecera);
/*    */     }
/* 44 */     for (int subcabecera = 0; subcabecera < subCabezaLineas.size(); subcabecera++) {
/* 45 */       cadena = cadena + (String)subCabezaLineas.get(subcabecera);
/*    */     }
/* 47 */     for (int ITEM = 0; ITEM < items.size(); ITEM++) cadena = cadena + (String)items.get(ITEM);
/* 48 */     for (int total = 0; total < totales.size(); total++) cadena = cadena + (String)totales.get(total);
/* 49 */     for (int pie = 0; pie < LineasPie.size(); pie++) { cadena = cadena + (String)LineasPie.get(pie);
/*    */     }
/* 51 */     DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
/* 52 */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
/* 53 */     DocPrintJob pj = service.createPrintJob();
/* 54 */     cadena = cadena + cortarHoja();
/* 55 */     char[] ABRIR_GAVETA = { '\033', 'p', '\000', '\n', 'd' };
/* 56 */     cadena = cadena + String.valueOf(ABRIR_GAVETA);
/* 57 */     byte[] bytes = cadena.getBytes();
/* 58 */     Doc doc = new SimpleDoc(bytes, flavor, null);
/*    */     try {
/* 60 */       pj.print(doc, null);
/*    */       
/* 62 */       CabezaLineas.removeAll(CabezaLineas);
/* 63 */       subCabezaLineas.removeAll(subCabezaLineas);
/* 64 */       items.removeAll(items);
/* 65 */       totales.removeAll(totales);
/* 66 */       LineasPie.removeAll(LineasPie);
               System.out.println(cadena);
/* 67 */       cadena = "";
/*    */     } catch (Exception e) {
/* 69 */       JOptionPane.showMessageDialog(null, "Error al imprimir :(");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\softlution\Desktop\pedidos\pedidos\Pedidos.jar!\pruebatiket\Ticket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */