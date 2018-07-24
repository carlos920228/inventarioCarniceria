package Vista;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderRow extends DefaultTableCellRenderer{
    private int columna;
    public RenderRow(int col)
{
    this.columna = col;
}

@Override
public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
{        
    setBackground(Color.white);
    table.setForeground(Color.black);
    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
    if(table.getValueAt(row,columna).equals("Pagado"))
    {
        this.setForeground(Color.RED);
    }else{
    this.setForeground(Color.BLACK);
    }
    return this;
  }
  }

