package view.dataTable;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.ViewManager;

public class CustomerListSelectionListener implements ListSelectionListener {

	private JTable table;

	public CustomerListSelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("ListSelectionEvent "+e);
		if (!e.getValueIsAdjusting()) {
			String selectedData = null;
			String selectedId = null;

			int[] selectedRow = table.getSelectedRows();
			int[] selectedColumns = table.getSelectedColumns();

			for (int i = 0; i < selectedRow.length; i++) {
				for (int j = 0; j < selectedColumns.length; j++) {
					selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
				}
				selectedId = (String) table.getValueAt(selectedRow[i], 0);
			}
			System.out.println("Selected data: " + selectedData+"  id: "+selectedId);
			ViewManager.getInstance().selectCustomer(selectedId);
		}

	}
	

/*	public void mouseClicked(MouseEvent e) {
		System.out.println("Clistener Mouse clicked");
		if (e.isPopupTrigger()) {
			PopUpChangeDialog menu = new PopUpChangeDialog();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	*/

}
