package view.dataTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import view.ViewManager;
import net.miginfocom.swing.MigLayout;




public class CustomerCellEditListener extends MouseAdapter {

	
	private class PopUpChangeDialog extends JPopupMenu {
		JMenuItem anItem;

		public PopUpChangeDialog() {
			anItem = new JMenuItem("+ Edit the Item");
			anItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					try {
						NewItemDialogFrame dialog = new NewItemDialogFrame(ViewManager.CUSTOMER);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			add(anItem);
		}
	}

	
    public void mouseClicked(MouseEvent e){
    	if (SwingUtilities.isRightMouseButton(e)) {
        	System.out.println("Right-Click MouseEvent in JTable fired");
            JTable target = (JTable)e.getSource();
            int row = target.getSelectedRow();
            String cellData = (String)target.getModel().getValueAt(row, 0);
            long selectedId = Long.parseLong(cellData);
            System.out.println("....... Clicked in row "+row);
        }
    }
}
