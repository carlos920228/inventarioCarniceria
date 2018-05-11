
package controlinventario;
import Vista.Menu;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ControlInventario {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
     try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel()); //
            Menu inicio=new Menu();
            inicio.setLocationRelativeTo(null);
        } catch (ParseException ex) {
            
        }
        
    }
    
}
